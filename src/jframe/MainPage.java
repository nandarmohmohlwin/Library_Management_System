package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.ChartPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTable tbl_studentDetails;
	private JTable tbl_bookDetails;
	DefaultTableModel model;
	JLabel lbl_noOfBooks, lbl_noOfStudents, lbl_noOfIssueBooks, lbl_noOfDefaulterList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		initPage();
		showPieChart();
	}

	public void initPage() {
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1313, 756);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.CYAN);
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 1366, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome, Admin");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/male_user_50px.png")));
		lblNewLabel.setBounds(963, 0, 187, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_menu_48px_1.png")));
		lblNewLabel_1.setBounds(76, 11, 35, 31);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Library Management System");
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(152, 15, 286, 24);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(121, 11, 1, 28);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 49, 238, 662);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 0, 0));
		panel_3.setBounds(0, 45, 268, 45);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel(" Home Page");
		lblNewLabel_2.setBounds(46, 11, 183, 24);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Home_26px_2.png")));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 14));

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(0, 0, 0));
		panel_3_1.setBounds(0, 91, 268, 45);
		panel_2.add(panel_3_1);

		JLabel lblNewLabel_2_1 = new JLabel(" LMS Dashboard");
		lblNewLabel_2_1
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Library_26px_1.png")));
		lblNewLabel_2_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(46, 11, 181, 24);
		panel_3_1.add(lblNewLabel_2_1);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(Color.BLACK);
		panel_3_1_1.setBounds(0, 137, 268, 45);
		panel_2.add(panel_3_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Features");
		lblNewLabel_2_1_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(46, 11, 140, 24);
		panel_3_1_1.add(lblNewLabel_2_1_1);

		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setLayout(null);
		panel_3_1_2.setBackground(Color.BLACK);
		panel_3_1_2.setBounds(0, 182, 268, 45);
		panel_2.add(panel_3_1_2);

		JLabel lblNewLabel_2_1_2 = new JLabel(" Manage Books");
		lblNewLabel_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageBooks book = new ManageBooks();
				book.setExtendedState(JFrame.MAXIMIZED_BOTH);
				book.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1_2.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Book_26px.png")));
		lblNewLabel_2_1_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_2.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(46, 11, 140, 24);
		panel_3_1_2.add(lblNewLabel_2_1_2);

		JPanel panel_3_1_3 = new JPanel();
		panel_3_1_3.setLayout(null);
		panel_3_1_3.setBackground(Color.BLACK);
		panel_3_1_3.setBounds(0, 225, 268, 45);
		panel_2.add(panel_3_1_3);

		JLabel lblNewLabel_2_1_3 = new JLabel(" Manage Students");
		lblNewLabel_2_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageStudents frame = new ManageStudents();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1_3
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Read_Online_26px.png")));
		lblNewLabel_2_1_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_3.setBounds(46, 11, 189, 24);
		panel_3_1_3.add(lblNewLabel_2_1_3);

		JPanel panel_3_1_4 = new JPanel();
		panel_3_1_4.setLayout(null);
		panel_3_1_4.setBackground(Color.BLACK);
		panel_3_1_4.setBounds(0, 270, 268, 45);
		panel_2.add(panel_3_1_4);

		JLabel lblNewLabel_2_1_4 = new JLabel(" Issue Book");
		lblNewLabel_2_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IssueBook frame = new IssueBook();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1_4.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Sell_26px.png")));
		lblNewLabel_2_1_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_4.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_4.setBounds(46, 11, 140, 24);
		panel_3_1_4.add(lblNewLabel_2_1_4);

		JPanel panel_3_1_5 = new JPanel();
		panel_3_1_5.setLayout(null);
		panel_3_1_5.setBackground(Color.BLACK);
		panel_3_1_5.setBounds(0, 315, 268, 45);
		panel_2.add(panel_3_1_5);

		JLabel lblNewLabel_2_1_5 = new JLabel(" Return Book");
		lblNewLabel_2_1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReturnBook frame = new ReturnBook();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1_5.setIcon(
				new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Return_Purchase_26px.png")));
		lblNewLabel_2_1_5.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_5.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5.setBounds(46, 11, 140, 24);
		panel_3_1_5.add(lblNewLabel_2_1_5);

		JPanel panel_3_1_5_1 = new JPanel();
		panel_3_1_5_1.setBounds(0, 46, 268, 45);
		panel_3_1_5.add(panel_3_1_5_1);
		panel_3_1_5_1.setLayout(null);
		panel_3_1_5_1.setBackground(Color.BLACK);

		JLabel lblNewLabel_2_1_5_1 = new JLabel("Welcome, Admin");
		lblNewLabel_2_1_5_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_5_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_1.setBounds(46, 11, 140, 24);
		panel_3_1_5_1.add(lblNewLabel_2_1_5_1);

		JPanel panel_3_1_5_2 = new JPanel();
		panel_3_1_5_2.setLayout(null);
		panel_3_1_5_2.setBackground(Color.BLACK);
		panel_3_1_5_2.setBounds(0, 358, 268, 45);
		panel_2.add(panel_3_1_5_2);

		JLabel lblNewLabel_2_1_5_2 = new JLabel(" View Records");
		lblNewLabel_2_1_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAllRecords frame = new ViewAllRecords();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1_5_2
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_View_Details_26px.png")));
		lblNewLabel_2_1_5_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_5_2.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_2.setBounds(46, 11, 140, 24);
		panel_3_1_5_2.add(lblNewLabel_2_1_5_2);

		JPanel panel_3_1_5_1_1 = new JPanel();
		panel_3_1_5_1_1.setLayout(null);
		panel_3_1_5_1_1.setBackground(Color.BLACK);
		panel_3_1_5_1_1.setBounds(0, 46, 268, 45);
		panel_3_1_5_2.add(panel_3_1_5_1_1);

		JLabel lblNewLabel_2_1_5_1_1 = new JLabel("Welcome, Admin");
		lblNewLabel_2_1_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_5_1_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_1_1.setBounds(46, 11, 140, 24);
		panel_3_1_5_1_1.add(lblNewLabel_2_1_5_1_1);

		JPanel panel_3_1_5_3 = new JPanel();
		panel_3_1_5_3.setLayout(null);
		panel_3_1_5_3.setBackground(Color.BLACK);
		panel_3_1_5_3.setBounds(0, 403, 268, 45);
		panel_2.add(panel_3_1_5_3);

		JLabel lblNewLabel_2_1_5_3 = new JLabel(" View Issued Books");
		lblNewLabel_2_1_5_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IssueBookDetails frame = new IssueBookDetails();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1_5_3
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Books_26px.png")));
		lblNewLabel_2_1_5_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_5_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_3.setBounds(46, 11, 192, 24);
		panel_3_1_5_3.add(lblNewLabel_2_1_5_3);

		JPanel panel_3_1_5_1_2 = new JPanel();
		panel_3_1_5_1_2.setLayout(null);
		panel_3_1_5_1_2.setBackground(Color.BLACK);
		panel_3_1_5_1_2.setBounds(0, 46, 268, 45);
		panel_3_1_5_3.add(panel_3_1_5_1_2);

		JLabel lblNewLabel_2_1_5_1_2 = new JLabel("Welcome, Admin");
		lblNewLabel_2_1_5_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_5_1_2.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_1_2.setBounds(46, 11, 140, 24);
		panel_3_1_5_1_2.add(lblNewLabel_2_1_5_1_2);

		JPanel panel_3_1_5_4 = new JPanel();
		panel_3_1_5_4.setLayout(null);
		panel_3_1_5_4.setBackground(Color.BLACK);
		panel_3_1_5_4.setBounds(0, 447, 268, 45);
		panel_2.add(panel_3_1_5_4);

		JLabel lblNewLabel_2_1_5_4 = new JLabel(" Defaulter List");
		lblNewLabel_2_1_5_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaulterList frame = new DefaulterList();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1_5_4
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Conference_26px.png")));
		lblNewLabel_2_1_5_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_5_4.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_4.setBounds(46, 11, 175, 24);
		panel_3_1_5_4.add(lblNewLabel_2_1_5_4);

		JPanel panel_3_1_5_1_3 = new JPanel();
		panel_3_1_5_1_3.setLayout(null);
		panel_3_1_5_1_3.setBackground(Color.BLACK);
		panel_3_1_5_1_3.setBounds(0, 46, 268, 45);
		panel_3_1_5_4.add(panel_3_1_5_1_3);

		JLabel lblNewLabel_2_1_5_1_3 = new JLabel("Welcome, Admin");
		lblNewLabel_2_1_5_1_3.setForeground(Color.WHITE);
		lblNewLabel_2_1_5_1_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_1_3.setBounds(46, 11, 140, 24);
		panel_3_1_5_1_3.add(lblNewLabel_2_1_5_1_3);

		JPanel panel_3_1_5_5 = new JPanel();
		panel_3_1_5_5.setLayout(null);
		panel_3_1_5_5.setBackground(new Color(0, 0, 255));
		panel_3_1_5_5.setBounds(0, 493, 268, 45);
		panel_2.add(panel_3_1_5_5);

		JLabel lblNewLabel_2_1_5_5 = new JLabel(" Logout");
		lblNewLabel_2_1_5_5
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Exit_26px.png")));
		lblNewLabel_2_1_5_5.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_5_5.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_5.setBounds(46, 11, 140, 24);
		panel_3_1_5_5.add(lblNewLabel_2_1_5_5);

		JPanel panel_3_1_5_1_4 = new JPanel();
		panel_3_1_5_1_4.setLayout(null);
		panel_3_1_5_1_4.setBackground(Color.BLACK);
		panel_3_1_5_1_4.setBounds(0, 46, 268, 45);
		panel_3_1_5_5.add(panel_3_1_5_1_4);

		JLabel lblNewLabel_2_1_5_1_4 = new JLabel("Welcome, Admin");
		lblNewLabel_2_1_5_1_4.setForeground(Color.WHITE);
		lblNewLabel_2_1_5_1_4.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2_1_5_1_4.setBounds(46, 11, 140, 24);
		panel_3_1_5_1_4.add(lblNewLabel_2_1_5_1_4);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(267, 49, 977, 151);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(50, 47, 157, 77);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 0, 0));
		panel_7.setBounds(0, 0, 157, 16);
		panel_6.add(panel_7);

		lbl_noOfBooks = new JLabel(" 10");
		lbl_noOfBooks
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Book_Shelf_50px.png")));
		lbl_noOfBooks.setFont(new Font("Courier New", Font.BOLD, 24));
		lbl_noOfBooks.setBounds(26, 27, 106, 39);
		panel_6.add(lbl_noOfBooks);

		JLabel lblNewLabel_4 = new JLabel("No of Books");
		lblNewLabel_4.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_4.setBounds(48, 22, 159, 14);
		panel_4.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("No of Students");
		lblNewLabel_4_1.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(283, 22, 159, 14);
		panel_4.add(lblNewLabel_4_1);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBounds(285, 47, 157, 77);
		panel_4.add(panel_6_1);

		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBackground(Color.RED);
		panel_7_1.setBounds(0, 0, 157, 16);
		panel_6_1.add(panel_7_1);

		lbl_noOfStudents = new JLabel(" 10");
		lbl_noOfStudents
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_People_50px.png")));
		lbl_noOfStudents.setFont(new Font("Courier New", Font.BOLD, 24));
		lbl_noOfStudents.setBounds(26, 27, 106, 39);
		panel_6_1.add(lbl_noOfStudents);

		JLabel lblNewLabel_4_2 = new JLabel("Issued Books");
		lblNewLabel_4_2.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_4_2.setBounds(518, 22, 159, 14);
		panel_4.add(lblNewLabel_4_2);

		JPanel panel_6_2 = new JPanel();
		panel_6_2.setLayout(null);
		panel_6_2.setBounds(520, 47, 157, 77);
		panel_4.add(panel_6_2);

		JPanel panel_7_2 = new JPanel();
		panel_7_2.setBackground(Color.RED);
		panel_7_2.setBounds(0, 0, 157, 16);
		panel_6_2.add(panel_7_2);

		lbl_noOfIssueBooks = new JLabel(" 10");
		lbl_noOfIssueBooks
				.setIcon(new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_Sell_50px.png")));
		lbl_noOfIssueBooks.setFont(new Font("Courier New", Font.BOLD, 24));
		lbl_noOfIssueBooks.setBounds(26, 21, 106, 45);
		panel_6_2.add(lbl_noOfIssueBooks);

		JLabel lblNewLabel_4_3 = new JLabel("Defaulter List");
		lblNewLabel_4_3.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_4_3.setBounds(735, 22, 159, 14);
		panel_4.add(lblNewLabel_4_3);

		JPanel panel_6_3 = new JPanel();
		panel_6_3.setLayout(null);
		panel_6_3.setBounds(737, 47, 157, 77);
		panel_4.add(panel_6_3);

		JPanel panel_7_3 = new JPanel();
		panel_7_3.setBackground(Color.RED);
		panel_7_3.setBounds(0, 0, 157, 16);
		panel_6_3.add(panel_7_3);

		lbl_noOfDefaulterList = new JLabel(" 10");
		lbl_noOfDefaulterList.setIcon(
				new ImageIcon(MainPage.class.getResource("/images/adminIcons/icons8_List_of_Thumbnails_50px.png")));
		lbl_noOfDefaulterList.setFont(new Font("Courier New", Font.BOLD, 24));
		lbl_noOfDefaulterList.setBounds(25, 21, 122, 45);
		panel_6_3.add(lbl_noOfDefaulterList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 275, 458, 184);
		scrollPane.setFont(new Font("Courier New", Font.PLAIN, 14));
		contentPane.add(scrollPane);

		tbl_studentDetails = new JTable();
		tbl_studentDetails.setFont(new Font("Courier New", Font.PLAIN, 14));
		scrollPane.setViewportView(tbl_studentDetails);
		tbl_studentDetails.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Student ID", "Student Name", "Course", "Batch" }));

		JLabel lblNewLabel_4_4 = new JLabel("Student Details");
		lblNewLabel_4_4.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_4_4.setBounds(274, 246, 159, 14);
		contentPane.add(lblNewLabel_4_4);

		JLabel lblNewLabel_4_4_1 = new JLabel("Book Details");
		lblNewLabel_4_4_1.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_4_4_1.setBounds(276, 470, 159, 14);
		contentPane.add(lblNewLabel_4_4_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(267, 514, 465, 175);
		contentPane.add(scrollPane_1);

		tbl_bookDetails = new JTable();
		tbl_bookDetails.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Book ID", "Book Name", "Author Name", "Quantity" }));
		tbl_bookDetails.getColumnModel().getColumn(3).setResizable(false);
		scrollPane_1.setViewportView(tbl_bookDetails);
		tbl_bookDetails.setFont(new Font("Courier New", Font.PLAIN, 14));

		setBookDetailsToTabble();
		setStudentDetailsToTabble();
		isnertDataToCards();
	}

	@SuppressWarnings("removal")
	public void showPieChart() {
		DefaultPieDataset barDataset = new DefaultPieDataset();
		barDataset.setValue("IPhone 5s", new Double(20));
		barDataset.setValue("SamSung Grand", new Double(20));
		barDataset.setValue("MotoG", new Double(40));
		barDataset.setValue("Nokia Lumia", new Double(10));

		// create chart
		JFreeChart piechart = ChartFactory.createPieChart("mobile sales", barDataset, false, true, false);// explain

		PiePlot piePlot = (PiePlot) piechart.getPlot();

		// changing pie chart blocks colors
		piePlot.setSectionPaint("IPhone 5s", new Color(255, 255, 102));
		piePlot.setSectionPaint("SamSung Grand", new Color(102, 255, 102));
		piePlot.setSectionPaint("MotoG", new Color(255, 102, 153));
		piePlot.setSectionPaint("Nokia Lumia", new Color(0, 204, 204));

		piePlot.setBackgroundPaint(Color.white);

		// Declare and initialize the panelPieChart
		JPanel panelPieChart = new JPanel();
		panelPieChart.setBounds(740, 246, 547, 460);

		// create chartPanel to display chart(graph)
		ChartPanel barChartPanel = new ChartPanel(piechart);
		panelPieChart.removeAll();
		panelPieChart.add(barChartPanel, BorderLayout.CENTER);
		barChartPanel.setLayout(new BorderLayout(0, 0));
		panelPieChart.validate();
		contentPane.add(panelPieChart);
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

				Object[] obj = { book_id, book_name, author, quantity };

				model = (DefaultTableModel) tbl_bookDetails.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setStudentDetailsToTabble() {
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from student_details";
			PreparedStatement pst = connection.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int student_id = rs.getInt("student_id");
				String student_name = rs.getString("student_name");
				String course = rs.getString("course");
				String branch = rs.getString("branch");

				Object[] obj = { student_id, student_name, course, branch };

				model = (DefaultTableModel) tbl_studentDetails.getModel();
				model.addRow(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void isnertDataToCards() {
		Statement st = null;
		ResultSet rs = null;

		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String todayDate = today.format(formatter);

		try {
			Connection connection = DBConnection.getConnection();
//			String sql = "select * from book_details";
//			PreparedStatement pst = connection.prepareStatement(sql);
//			ResultSet rs = pst.executeQuery();
//			rs.last();
//			lbl_noOfBooks.setText(Integer.toString(rs.getRow()));
//			System.out.println(rs.getRow());

			st = connection.createStatement();
			rs = st.executeQuery("select count(*) from book_details");
			if (rs.next()) {
				int rowCount = rs.getInt(1);
				lbl_noOfBooks.setText(Integer.toString(rowCount));
			}

			rs = st.executeQuery("select count(*) from student_details");
			if (rs.next()) {
				int rowCount = rs.getInt(1);
				lbl_noOfStudents.setText(Integer.toString(rowCount));
			}

			rs = st.executeQuery("select count(*) from issue_book_details where status = '" + "pending" + "'");
			if (rs.next()) {
				int rowCount = rs.getInt(1);
				lbl_noOfIssueBooks.setText(Integer.toString(rowCount));
			}

			rs = st.executeQuery("select count(*) from issue_book_details where due_date < '" + todayDate
					+ "'  and status = '" + "pending" + "'");
			if (rs.next()) {
				int rowCount = rs.getInt(1);
				lbl_noOfDefaulterList.setText(Integer.toString(rowCount));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
