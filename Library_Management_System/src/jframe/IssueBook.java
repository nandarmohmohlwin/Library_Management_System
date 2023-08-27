package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IssueBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_bookId;
	private JTextField txt_studentId;
	JLabel lbl_bookId, lbl_bookName, lbl_author, lbl_quantity;
	JLabel lbl_studentId, lbl_studentName, lbl_course, lbl_branch;
	JLabel lbl_bookError, lbl_studentError;
	JDateChooser issueDate, dueDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setTitle("Issue Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 386, 720);
		panel.setBackground(new Color(255, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 255));
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
		lblNewLabel
				.setIcon(new ImageIcon(IssueBook.class.getResource("/images/AddNewBookIcons/icons8_Rewind_48px.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 111, 18);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_4_4_1 = new JLabel("Book Details ");
		lblNewLabel_4_4_1.setIcon(
				new ImageIcon(IssueBook.class.getResource("/images/AddNewBookIcons/icons8_Literature_100px_1.png")));
		lblNewLabel_4_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_4_1.setFont(new Font("Courier New", Font.BOLD, 25));
		lblNewLabel_4_4_1.setBounds(23, 70, 311, 100);
		panel.add(lblNewLabel_4_4_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 181, 335, 5);
		panel.add(panel_3);

		JLabel lblNewLabel_1 = new JLabel("Book ID :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 255, 115, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Book Name :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 318, 115, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Author :");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 378, 115, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Quantity : ");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(10, 448, 115, 19);
		panel.add(lblNewLabel_1_3);

		lbl_bookId = new JLabel("");
		lbl_bookId.setForeground(Color.WHITE);
		lbl_bookId.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_bookId.setBounds(122, 251, 248, 19);
		panel.add(lbl_bookId);

		lbl_bookName = new JLabel("");
		lbl_bookName.setForeground(Color.WHITE);
		lbl_bookName.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_bookName.setBounds(122, 319, 248, 19);
		panel.add(lbl_bookName);

		lbl_author = new JLabel("");
		lbl_author.setForeground(Color.WHITE);
		lbl_author.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_author.setBounds(122, 378, 248, 19);
		panel.add(lbl_author);

		lbl_quantity = new JLabel("");
		lbl_quantity.setForeground(Color.WHITE);
		lbl_quantity.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_quantity.setBounds(122, 448, 248, 19);
		panel.add(lbl_quantity);

		lbl_bookError = new JLabel("");
		lbl_bookError.setForeground(Color.WHITE);
		lbl_bookError.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_bookError.setBounds(40, 539, 248, 19);
		panel.add(lbl_bookError);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 255));
		panel_2.setBounds(403, 0, 380, 700);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_4_4_1_1 = new JLabel("Student Details ");
		lblNewLabel_4_4_1_1.setIcon(new ImageIcon(
				IssueBook.class.getResource("/images/AddNewBookIcons/icons8_Student_Registration_100px_2.png")));
		lblNewLabel_4_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_4_1_1.setFont(new Font("Courier New", Font.BOLD, 25));
		lblNewLabel_4_4_1_1.setBounds(0, 70, 345, 100);
		panel_2.add(lblNewLabel_4_4_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(10, 181, 335, 5);
		panel_2.add(panel_3_1);

		lbl_branch = new JLabel("");
		lbl_branch.setForeground(Color.WHITE);
		lbl_branch.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_branch.setBounds(156, 446, 163, 19);
		panel_2.add(lbl_branch);

		lbl_course = new JLabel("");
		lbl_course.setForeground(Color.WHITE);
		lbl_course.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_course.setBounds(156, 376, 163, 19);
		panel_2.add(lbl_course);

		lbl_studentName = new JLabel("");
		lbl_studentName.setForeground(Color.WHITE);
		lbl_studentName.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_studentName.setBounds(156, 317, 163, 19);
		panel_2.add(lbl_studentName);

		lbl_studentId = new JLabel("");
		lbl_studentId.setForeground(Color.WHITE);
		lbl_studentId.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_studentId.setBounds(156, 249, 163, 19);
		panel_2.add(lbl_studentId);

		JLabel lblNewLabel_1_5 = new JLabel("Student ID :");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(10, 253, 127, 14);
		panel_2.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_1_1 = new JLabel("Student Name :");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 316, 140, 14);
		panel_2.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Course : ");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(10, 376, 115, 14);
		panel_2.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("Branch : ");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(10, 446, 115, 19);
		panel_2.add(lblNewLabel_1_3_1);

		lbl_studentError = new JLabel("");
		lbl_studentError.setForeground(Color.WHITE);
		lbl_studentError.setFont(new Font("Courier New", Font.PLAIN, 16));
		lbl_studentError.setBounds(46, 542, 248, 19);
		panel_2.add(lbl_studentError);

		JLabel lblNewLabel_4_4_1_1_1 = new JLabel("Issue Book");
		lblNewLabel_4_4_1_1_1
				.setIcon(new ImageIcon(IssueBook.class.getResource("/images/AddNewBookIcons/icons8_Books_52px_1.png")));
		lblNewLabel_4_4_1_1_1.setBackground(new Color(0, 64, 0));
		lblNewLabel_4_4_1_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_4_4_1_1_1.setFont(new Font("Courier New", Font.BOLD, 20));
		lblNewLabel_4_4_1_1_1.setBounds(945, 78, 208, 100);
		contentPane.add(lblNewLabel_4_4_1_1_1);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(255, 0, 0));
		panel_3_1_1.setBounds(891, 173, 335, 5);
		contentPane.add(panel_3_1_1);

		JLabel lblNewLabel_1_5_1 = new JLabel("Book ID :");
		lblNewLabel_1_5_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_5_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_5_1.setBounds(821, 232, 127, 14);
		contentPane.add(lblNewLabel_1_5_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Student ID :");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(821, 295, 140, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Issue Date :");
		lblNewLabel_1_2_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_2_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(821, 355, 127, 14);
		contentPane.add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Due Date :");
		lblNewLabel_1_3_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_3_1_1.setFont(new Font("Courier New", Font.PLAIN, 16));
		lblNewLabel_1_3_1_1.setBounds(821, 425, 115, 19);
		contentPane.add(lblNewLabel_1_3_1_1);

		txt_bookId = new JTextField();
		txt_bookId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!txt_bookId.getText().equals("")) {
					getBookDetails();
				}

			}
		});
		txt_bookId.setBounds(1001, 230, 213, 20);
		contentPane.add(txt_bookId);
		txt_bookId.setColumns(10);

		txt_studentId = new JTextField();
		txt_studentId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!txt_studentId.getText().equals("")) {
					getStudentDetails();
				}
			}
		});
		txt_studentId.setColumns(10);
		txt_studentId.setBounds(1001, 293, 213, 20);
		contentPane.add(txt_studentId);

		issueDate = new JDateChooser();
		issueDate.setBounds(1001, 349, 213, 20);
		contentPane.add(issueDate);

		dueDate = new JDateChooser();
		dueDate.setBounds(1001, 424, 213, 20);
		contentPane.add(dueDate);

		JButton btn_issueBook = new JButton("ISSUE BOOK");
		btn_issueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lbl_quantity.getText().equals("0")){
					JOptionPane.showMessageDialog(null,  "Book is not available");
				} else {
					if (isAlreadyIssued() == true) {
						JOptionPane.showMessageDialog(null, "This student already has this book");
					} else {
						try {
							if (issueBookDetails() == true) {
								JOptionPane.showMessageDialog(null, "Issue Book Successfully");
								updateBookCount();
								int quantity = Integer.parseInt(lbl_quantity.getText());
								lbl_quantity.setText(Integer.toString(quantity - 1));
							} else {
								JOptionPane.showMessageDialog(null, "Issue Book Failed");
							}
						} catch (HeadlessException e1) {
							e1.printStackTrace();
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				}				
			}
		});
		btn_issueBook.setFont(new Font("Courier New", Font.PLAIN, 18));
		btn_issueBook.setBounds(954, 520, 208, 37);
		contentPane.add(btn_issueBook);
	}

	public void getBookDetails() {
		int bookId = Integer.parseInt(txt_bookId.getText());

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from book_details where book_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setInt(1, bookId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				lbl_bookId.setText(rs.getString("book_id"));
				lbl_bookName.setText(rs.getString("book_name"));
				lbl_author.setText(rs.getString("author"));
				lbl_quantity.setText(rs.getString("quantity"));
				lbl_bookError.setText("");
			} else {
				lbl_bookError.setText("Invalid book id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getStudentDetails() {
		int studentId = Integer.parseInt(txt_studentId.getText());

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from student_details where student_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setInt(1, studentId);

			ResultSet rs = pst.executeQuery();

			// use if instead of while to use else
			if (rs.next()) {
				lbl_studentId.setText(rs.getString("student_id"));
				lbl_studentName.setText(rs.getString("student_name"));
				lbl_course.setText(rs.getString("course"));
				lbl_branch.setText(rs.getString("branch"));
				lbl_studentError.setText("");
			} else {
				lbl_studentError.setText("Invalid student id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean issueBookDetails() throws ParseException {
		boolean isIssued = false;
		int book_id = Integer.parseInt(txt_bookId.getText());
		String book_name = lbl_bookName.getText();
		int student_id = Integer.parseInt(txt_studentId.getText());
		String student_name = lbl_studentName.getText();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String issue_date = sdf.format(issueDate.getDate());
		String due_date = sdf.format(dueDate.getDate());

//		Date ISSUEDATE = (Date) issueDate.getDate();
//		Date DUEDATE = (Date) dueDate.getDate();
//		
//		long l1 = ISSUEDATE.getTime();
//		long l2 = DUEDATE.getTime();
//		
//		java.sql.Date issue_date1 = new java.sql.Date(l1);
//		java.sql.Date due_date1 = new java.sql.Date(l2);
//		
//		System.out.println( ISSUEDATE + " " + DUEDATE);
//		System.out.println( l1 + " " + l2);
//		System.out.println( issue_date1 + " " + due_date1);

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "insert into issue_book_details (book_id, book_name, student_id, student_name, issue_date, due_date, status) "
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setInt(1, book_id);
			pst.setString(2, book_name);
			pst.setInt(3, student_id);
			pst.setString(4, student_name);
			pst.setString(5, issue_date);
			pst.setString(6, due_date);
			pst.setString(7, "pending");

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				isIssued = true;
			} else {
				isIssued = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isIssued;
	}

	public void updateBookCount() {
		int book_id = Integer.parseInt(txt_bookId.getText());

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "update book_details set quantity = quantity -1 where book_id = ? ";
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

	public boolean isAlreadyIssued() {
		boolean isAlready = false;
		int book_id = Integer.parseInt(txt_bookId.getText());
		int student_id = Integer.parseInt(txt_studentId.getText());
		System.out.println(book_id);

		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ? ";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, book_id);
			pst.setInt(2, student_id);
			pst.setString(3, "pending");

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				isAlready = true;
			} else {
				isAlready = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAlready;

	}
}
