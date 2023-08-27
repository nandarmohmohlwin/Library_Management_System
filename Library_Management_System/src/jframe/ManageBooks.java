package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ManageBooks extends JFrame {

	private JPanel contentPane;
	private JTextField txt_bookId;
	private JTextField txt_bookName;
	private JTextField txt_author;
	private JTextField txt_quantity;
	private JTable tbl_bookDetails;
	
	DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBooks frame = new ManageBooks();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 302, 800);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 0, 131, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage page = new MainPage();
				page.setExtendedState(JFrame.MAXIMIZED_BOTH);
				page.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(ManageBooks.class.getResource("/images/AddNewBookIcons/icons8_Rewind_48px.png")));
		lblNewLabel.setBounds(10, 11, 111, 18);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ManageBooks.class.getResource("/images/AddNewBookIcons/icons8_Contact_26px.png")));
		lblNewLabel_4.setBounds(23, 91, 35, 52);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Book ID");
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(83, 78, 128, 24);
		panel.add(lblNewLabel_3);
		
		txt_bookId = new JTextField();
		txt_bookId.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_bookId.setColumns(10);
		txt_bookId.setBounds(80, 109, 196, 24);
		panel.add(txt_bookId);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(ManageBooks.class.getResource("/images/AddNewBookIcons/icons8_Moleskine_26px.png")));
		lblNewLabel_4_1.setBounds(23, 185, 35, 52);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Book Name");
		lblNewLabel_3_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(83, 172, 128, 24);
		panel.add(lblNewLabel_3_1);
		
		txt_bookName = new JTextField();
		txt_bookName.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_bookName.setColumns(10);
		txt_bookName.setBounds(80, 203, 196, 24);
		panel.add(txt_bookName);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(ManageBooks.class.getResource("/images/AddNewBookIcons/icons8_Collaborator_Male_26px.png")));
		lblNewLabel_4_2.setBounds(23, 282, 35, 52);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Author Name");
		lblNewLabel_3_2.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(83, 269, 128, 24);
		panel.add(lblNewLabel_3_2);
		
		txt_author = new JTextField();
		txt_author.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_author.setColumns(10);
		txt_author.setBounds(80, 300, 196, 24);
		panel.add(txt_author);
		
		JLabel lblNewLabel_4_3 = new JLabel("");
		lblNewLabel_4_3.setIcon(new ImageIcon(ManageBooks.class.getResource("/images/AddNewBookIcons/icons8_Unit_26px.png")));
		lblNewLabel_4_3.setBounds(23, 377, 35, 52);
		panel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Quantity");
		lblNewLabel_3_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(83, 364, 128, 24);
		panel.add(lblNewLabel_3_3);
		
		txt_quantity = new JTextField();
		txt_quantity.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_quantity.setColumns(10);
		txt_quantity.setBounds(80, 395, 196, 24);
		panel.add(txt_quantity);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addBook() == true) {
					JOptionPane.showMessageDialog(null, "Book Added");
					clearTable();
					setBookDetailsToTabble();
				}else {
					JOptionPane.showMessageDialog(null, "Book Addition Failed");
				}
			}
		});
		btnAdd.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnAdd.setBounds(8, 489, 89, 30);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(updateBook() == true ) {
					JOptionPane.showMessageDialog(null, "Update Successfully");
					clearTable();
					setBookDetailsToTabble();
				}else {
					JOptionPane.showMessageDialog(null, "Update Fail");
				}
			}
		});
		btnUpdate.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnUpdate.setBounds(107, 489, 89, 30);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deleteBook() == true ) {
					JOptionPane.showMessageDialog(null, "Delete Successfully");
					clearTable();
					setBookDetailsToTabble();
				}else {
					JOptionPane.showMessageDialog(null, "Delete Fail");
				}
			}
		});
		btnDelete.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnDelete.setBounds(206, 489, 89, 30);
		panel.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(301, 0, 854, 405);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4_4_1 = new JLabel(" Manage Books ");
		lblNewLabel_4_4_1.setIcon(new ImageIcon(ManageBooks.class.getResource("/images/AddNewBookIcons/icons8_Books_52px_1.png")));
		lblNewLabel_4_4_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_4_4_1.setFont(new Font("Courier New", Font.BOLD, 30));
		lblNewLabel_4_4_1.setBounds(173, 25, 335, 52);
		panel_2.add(lblNewLabel_4_4_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(70, 164, 594, 205);
		panel_2.add(scrollPane_1);
		
		tbl_bookDetails = new JTable();
		tbl_bookDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo = tbl_bookDetails.getSelectedRow();
				TableModel model = tbl_bookDetails.getModel();
				
				txt_bookId.setText(model.getValueAt(rowNo, 0).toString());
				txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
				txt_author.setText(model.getValueAt(rowNo, 2).toString());
				txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
				
			}
		});
		tbl_bookDetails.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book ID", "Book Name", "Author Name", "Quantity"
			}
		));
		scrollPane_1.setViewportView(tbl_bookDetails);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 0, 0));
		panel_3.setBounds(161, 88, 335, 5);
		panel_2.add(panel_3);
		
		setBookDetailsToTabble();
	}
	
	public void setBookDetailsToTabble() {
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from book_details";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String book_name = rs.getString("book_name");
				String author = rs.getString("author");
				int quantity = rs.getInt("quantity");
				
				Object[] obj = {book_id, book_name, author, quantity};
				
				model = (DefaultTableModel) tbl_bookDetails.getModel();
				model.addRow(obj);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public boolean addBook() {
		boolean isAdded = false;
//		int book_id = Integer.parseInt(txt_bookId.getText());
		String book_name = txt_bookName.getText();
		String author = txt_author.getText();
		int quantity = Integer.parseInt(txt_quantity.getText());
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "insert into book_details(book_name, author, quantity) values (?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, book_name);
			pst.setString(2, author);
			pst.setInt(3, quantity);
			
			int rowsAffected = pst.executeUpdate();
			
			if(rowsAffected > 0) {
				isAdded = true;
			}else {
				isAdded = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}
	
	public boolean updateBook() {
		boolean isUpdate = false;
		int book_id = Integer.parseInt(txt_bookId.getText());
		String book_name = txt_bookName.getText();
		String author = txt_author.getText();
		int quantity = Integer.parseInt(txt_quantity.getText());
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "update book_details set book_name = ?, author = ?, quantity = ? where book_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, book_name);
			pst.setString(2, author);
			pst.setInt(3, quantity);
			pst.setInt(4, book_id);
			
			int rowsAffected = pst.executeUpdate();
			
			if(rowsAffected > 0) {
				isUpdate = true;
			}else {
				isUpdate = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdate;
	}
	
	public boolean deleteBook() {
		boolean isDelete = false;
		int book_id = Integer.parseInt(txt_bookId.getText());
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "delete from book_details where book_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setInt(1, book_id);
			
			int rowsAffected = pst.executeUpdate();
			
			if(rowsAffected > 0) {
				isDelete = true;
			}else {
				isDelete = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isDelete;
	}
	
	//clear table
	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
		model.setRowCount(0);
	}
	
}
