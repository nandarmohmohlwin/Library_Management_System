package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReturnBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_bookId;
	private JTextField txt_studentId;
	JLabel lbl_issueId, lbl_bookName, lbl_studentName, lbl_issueDate, lbl_dueDate;
	JLabel lbl_bookError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setTitle("Issue Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(520, 0, 386, 720);
		panel.setBackground(new Color(255, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4_4_1 = new JLabel("Book Details ");
		lblNewLabel_4_4_1.setIcon(
				new ImageIcon(ReturnBook.class.getResource("/images/AddNewBookIcons/icons8_Literature_100px_1.png")));
		lblNewLabel_4_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_4_1.setFont(new Font("Courier New", Font.BOLD, 25));
		lblNewLabel_4_4_1.setBounds(23, 70, 311, 100);
		panel.add(lblNewLabel_4_4_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 181, 335, 5);
		panel.add(panel_3);

		JLabel lblNewLabel_1 = new JLabel("Issue ID :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 255, 129, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Book Name :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 318, 129, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Student Name :");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 378, 140, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Issue Date :");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(10, 448, 129, 19);
		panel.add(lblNewLabel_1_3);

		lbl_issueId = new JLabel("");
		lbl_issueId.setForeground(Color.WHITE);
		lbl_issueId.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_issueId.setBounds(122, 251, 248, 19);
		panel.add(lbl_issueId);

		lbl_bookName = new JLabel("");
		lbl_bookName.setForeground(Color.WHITE);
		lbl_bookName.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_bookName.setBounds(122, 319, 248, 19);
		panel.add(lbl_bookName);

		lbl_studentName = new JLabel("");
		lbl_studentName.setForeground(Color.WHITE);
		lbl_studentName.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_studentName.setBounds(153, 378, 217, 19);
		panel.add(lbl_studentName);

		lbl_issueDate = new JLabel("");
		lbl_issueDate.setForeground(Color.WHITE);
		lbl_issueDate.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_issueDate.setBounds(134, 448, 236, 19);
		panel.add(lbl_issueDate);

		lbl_bookError = new JLabel("");
		lbl_bookError.setForeground(Color.WHITE);
		lbl_bookError.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_bookError.setBounds(46, 591, 248, 19);
		panel.add(lbl_bookError);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Due Date :");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(10, 509, 129, 19);
		panel.add(lblNewLabel_1_3_1);
		
		lbl_dueDate = new JLabel("");
		lbl_dueDate.setForeground(Color.WHITE);
		lbl_dueDate.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_dueDate.setBounds(122, 509, 248, 19);
		panel.add(lbl_dueDate);

		JLabel lblNewLabel_4_4_1_1_1 = new JLabel("Issue Book");
		lblNewLabel_4_4_1_1_1
				.setIcon(new ImageIcon(ReturnBook.class.getResource("/images/AddNewBookIcons/icons8_Books_52px_1.png")));
		lblNewLabel_4_4_1_1_1.setBackground(new Color(0, 64, 0));
		lblNewLabel_4_4_1_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_4_4_1_1_1.setFont(new Font("Courier New", Font.BOLD, 20));
		lblNewLabel_4_4_1_1_1.setBounds(1079, 85, 208, 100);
		contentPane.add(lblNewLabel_4_4_1_1_1);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(255, 0, 0));
		panel_3_1_1.setBounds(1025, 180, 335, 5);
		contentPane.add(panel_3_1_1);

		JLabel lblNewLabel_1_5_1 = new JLabel("Book ID :");
		lblNewLabel_1_5_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_5_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_5_1.setBounds(955, 239, 127, 14);
		contentPane.add(lblNewLabel_1_5_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Student ID :");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(955, 302, 140, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		txt_bookId = new JTextField();
		txt_bookId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		txt_bookId.setBounds(1135, 237, 213, 20);
		contentPane.add(txt_bookId);
		txt_bookId.setColumns(10);

		txt_studentId = new JTextField();
		txt_studentId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		txt_studentId.setColumns(10);
		txt_studentId.setBounds(1135, 300, 213, 20);
		contentPane.add(txt_studentId);

		JButton btn_issueBook = new JButton("RETURN BOOK");
		btn_issueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (returnBook() == true) {
					JOptionPane.showMessageDialog(null, "Book Returned Successfully");
					updateBookCount();
				} else {
					JOptionPane.showMessageDialog(null, "Book Returned Failed");
				}
			}
		});
		btn_issueBook.setFont(new Font("Courier New", Font.PLAIN, 18));
		btn_issueBook.setBounds(1088, 527, 208, 37);
		contentPane.add(btn_issueBook);
		
		JButton btn_issueBook_1 = new JButton("FIND");
		btn_issueBook_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getIssueBookDetails();
			}
		});
		btn_issueBook_1.setFont(new Font("Courier New", Font.PLAIN, 18));
		btn_issueBook_1.setBounds(1088, 431, 208, 37);
		contentPane.add(btn_issueBook_1);
		
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 0, 131, 40);
				contentPane.add(panel_1);
				panel_1.setLayout(null);
				panel_1.setBackground(new Color(0, 0, 255));
				
						JLabel lblNewLabel = new JLabel("Back");
						lblNewLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								MainPage frame = new MainPage();
								frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
								frame.setVisible(true);
								dispose();
							}
						});
						lblNewLabel
								.setIcon(new ImageIcon(ReturnBook.class.getResource("/images/AddNewBookIcons/icons8_Rewind_48px.png")));
						lblNewLabel.setForeground(Color.WHITE);
						lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
						lblNewLabel.setBounds(10, 11, 111, 18);
						panel_1.add(lblNewLabel);
						
						JLabel lblNewLabel_2 = new JLabel("");
						lblNewLabel_2.setIcon(new ImageIcon(ReturnBook.class.getResource("/images/icons/library-2.png")));
						lblNewLabel_2.setBounds(0, 92, 521, 520);
						contentPane.add(lblNewLabel_2);
	}

	public void getIssueBookDetails() {
		int bookId = Integer.parseInt(txt_bookId.getText());
		int studentId = Integer.parseInt(txt_studentId.getText());

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from issue_book_details where book_id = ? and student_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setInt(1, bookId);
			pst.setInt(2, studentId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				lbl_issueId.setText(rs.getString("id"));
				lbl_bookName.setText(rs.getString("book_name"));
				lbl_studentName.setText(rs.getString("student_name"));
				lbl_issueDate.setText(rs.getString("issue_date"));
				lbl_dueDate.setText(rs.getString("due_date"));
				lbl_bookError.setText("");
			} else {
				lbl_bookError.setText("Invalid book id");
				lbl_issueId.setText("");
				lbl_bookName.setText("");
				lbl_studentName.setText("");
				lbl_issueDate.setText("");
				lbl_dueDate.setText("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean returnBook() {
		boolean isReturned = false;
		int bookId = Integer.parseInt(txt_bookId.getText());
		int studentId = Integer.parseInt(txt_studentId.getText());

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "update issue_book_details set status = ? where book_id = ? and student_id = ? and status = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, "returned");
			pst.setInt(2, bookId);
			pst.setInt(3, studentId);
			pst.setString(4, "pending");

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				isReturned = true;
			} else {
				isReturned = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isReturned;
	}

	public void updateBookCount() {
		int book_id = Integer.parseInt(txt_bookId.getText());
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "update book_details set quantity = quantity + 1 where book_id = ? ";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, book_id);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(this, "Book count updated");
			} else {
				JOptionPane.showMessageDialog(this, "Book count can't updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
