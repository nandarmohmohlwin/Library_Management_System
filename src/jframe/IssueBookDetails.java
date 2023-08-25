package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IssueBookDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbl_issueBookDetails;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBookDetails frame = new IssueBookDetails();
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
	public IssueBookDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4_4_1 = new JLabel("Issue Book Details");
		lblNewLabel_4_4_1.setIcon(new ImageIcon(IssueBookDetails.class.getResource("/images/AddNewBookIcons/icons8_Books_52px_1.png")));
		lblNewLabel_4_4_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_4_4_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_4_4_1.setFont(new Font("Courier New", Font.BOLD, 25));
		lblNewLabel_4_4_1.setBounds(366, 51, 367, 100);
		contentPane.add(lblNewLabel_4_4_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 0, 0));
		panel_3.setBounds(355, 161, 360, 5);
		contentPane.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 256, 779, 192);
		contentPane.add(scrollPane);
		
		tbl_issueBookDetails = new JTable();
		tbl_issueBookDetails.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Issue Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status" }));
		tbl_issueBookDetails.setFont(new Font("Courier New", Font.PLAIN, 12));
		scrollPane.setViewportView(tbl_issueBookDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 0, 131, 40);
		contentPane.add(panel_1);
		
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
		lblNewLabel.setIcon(new ImageIcon(IssueBookDetails.class.getResource("/images/AddNewBookIcons/icons8_Rewind_48px.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 111, 18);
		panel_1.add(lblNewLabel);
		
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
	
	
}
