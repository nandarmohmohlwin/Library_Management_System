package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewAllRecords extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbl_issueBookDetails;
	DefaultTableModel model;
	JDateChooser date_fromDate, date_toDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllRecords frame = new ViewAllRecords();
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
	public ViewAllRecords() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 1500, 200);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4_4_1 = new JLabel("View All Records");
		lblNewLabel_4_4_1.setIcon(new ImageIcon(
				ViewAllRecords.class.getResource("/images/AddNewBookIcons/icons8_Literature_100px_1.png")));
		lblNewLabel_4_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_1.setFont(new Font("Courier New", Font.BOLD, 25));
		lblNewLabel_4_4_1.setBounds(260, 0, 367, 100);
		panel.add(lblNewLabel_4_4_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(247, 111, 360, 5);
		panel.add(panel_3);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Issue Date :");
		lblNewLabel_1_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(10, 157, 127, 14);
		panel.add(lblNewLabel_1_2_1_1);

		date_fromDate = new JDateChooser();
		date_fromDate.setBounds(190, 151, 213, 20);
		panel.add(date_fromDate);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Issue Date :");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_1.setBounds(423, 157, 127, 14);
		panel.add(lblNewLabel_1_2_1_1_1);

		date_toDate = new JDateChooser();
		date_toDate.setBounds(603, 151, 213, 20);
		panel.add(date_toDate);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (date_fromDate.getDate() != null && date_toDate.getDate() != null) {
					clearTable();
					search();
				} else {
					JOptionPane.showMessageDialog(null, "User should select date");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnNewButton.setBounds(913, 151, 89, 23);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 0, 131, 40);
		panel.add(panel_1);

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
		lblNewLabel.setIcon(
				new ImageIcon(ViewAllRecords.class.getResource("/images/AddNewBookIcons/icons8_Rewind_48px.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 111, 18);
		panel_1.add(lblNewLabel);
		
		JButton btnAll = new JButton("All");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTable();
				setIssueBookDetailsToTabble();
			}
		});
		btnAll.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnAll.setBounds(1074, 151, 89, 23);
		panel.add(btnAll);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 244, 940, 192);
		contentPane.add(scrollPane);

		tbl_issueBookDetails = new JTable();
		tbl_issueBookDetails.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Issue Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status" }));
		tbl_issueBookDetails.setFont(new Font("Courier New", Font.PLAIN, 12));
		scrollPane.setViewportView(tbl_issueBookDetails);

		setIssueBookDetailsToTabble();
	}

	public void setIssueBookDetailsToTabble() {
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from issue_book_details";
			PreparedStatement pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String book_name = rs.getString("book_name");
				String student_name = rs.getString("student_name");
				String issue_date = rs.getString("issue_date");
				String due_date = rs.getString("due_date");
				String status = rs.getString("status");

				Object[] obj = { id, book_name, student_name, issue_date, due_date, status };

				model = (DefaultTableModel) tbl_issueBookDetails.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// clear table
	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
		model.setRowCount(0);
	}

	public void search() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String from_date = sdf.format(date_fromDate.getDate());
		String to_date = sdf.format(date_toDate.getDate());

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from issue_book_details where issue_date between ? and ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, from_date);
			pst.setString(2, to_date);

			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String book_name = rs.getString("book_name");
				String student_name = rs.getString("student_name");
				String issue_date = rs.getString("issue_date");
				String due_date = rs.getString("due_date");
				String status = rs.getString("status");
				
				Object[] obj = {id, book_name, student_name, issue_date, due_date, status };

				model = (DefaultTableModel) tbl_issueBookDetails.getModel();
				model.addRow(obj);
			}		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
