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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class ManageStudents extends JFrame {

	private JPanel contentPane;
	private JTextField txt_studentId;
	private JTextField txt_studentName;
	private JTable tbl_studentDetails;
	JComboBox<?> combo_course;
	JComboBox<?> combo_branch;
	
	DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudents frame = new ManageStudents();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ManageStudents() {
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
		lblNewLabel.setIcon(new ImageIcon(ManageStudents.class.getResource("/images/AddNewBookIcons/icons8_Rewind_48px.png")));
		lblNewLabel.setBounds(10, 11, 111, 18);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ManageStudents.class.getResource("/images/AddNewBookIcons/icons8_Contact_26px.png")));
		lblNewLabel_4.setBounds(23, 91, 35, 52);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Student ID");
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(83, 78, 128, 24);
		panel.add(lblNewLabel_3);
		
		txt_studentId = new JTextField();
		txt_studentId.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_studentId.setColumns(10);
		txt_studentId.setBounds(80, 109, 196, 24);
		panel.add(txt_studentId);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(ManageStudents.class.getResource("/images/AddNewBookIcons/icons8_Moleskine_26px.png")));
		lblNewLabel_4_1.setBounds(23, 185, 35, 52);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Student Name");
		lblNewLabel_3_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(83, 172, 128, 24);
		panel.add(lblNewLabel_3_1);
		
		txt_studentName = new JTextField();
		txt_studentName.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_studentName.setColumns(10);
		txt_studentName.setBounds(80, 203, 196, 24);
		panel.add(txt_studentName);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(ManageStudents.class.getResource("/images/AddNewBookIcons/icons8_Collaborator_Male_26px.png")));
		lblNewLabel_4_2.setBounds(23, 282, 35, 52);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Course");
		lblNewLabel_3_2.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(83, 269, 128, 24);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("");
		lblNewLabel_4_3.setIcon(new ImageIcon(ManageStudents.class.getResource("/images/AddNewBookIcons/icons8_Unit_26px.png")));
		lblNewLabel_4_3.setBounds(23, 377, 35, 52);
		panel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Branch");
		lblNewLabel_3_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(83, 364, 128, 24);
		panel.add(lblNewLabel_3_3);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addStudent() == true) {
					JOptionPane.showMessageDialog(null, "Student Added");
					clearTable();
					setStudentDetailsToTabble();
				}else {
					JOptionPane.showMessageDialog(null, "Student Addition Failed");
				}
			}
		});
		btnAdd.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnAdd.setBounds(8, 489, 89, 30);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(updateStudent() == true ) {
					JOptionPane.showMessageDialog(null, "Update Successfully");
					clearTable();
					setStudentDetailsToTabble();
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
				if(deleteStudent() == true ) {
					JOptionPane.showMessageDialog(null, "Delete Successfully");
					clearTable();
					setStudentDetailsToTabble();
				}else {
					JOptionPane.showMessageDialog(null, "Delete Fail");
				}
			}
		});
		btnDelete.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnDelete.setBounds(206, 489, 89, 30);
		panel.add(btnDelete);
		
		combo_course = new JComboBox();
		combo_course.setModel(new DefaultComboBoxModel(new String[] {"BSc", "MSc", "PHD"}));
		combo_course.setBounds(83, 304, 193, 22);
		panel.add(combo_course);
		
		combo_branch = new JComboBox();
		combo_branch.setModel(new DefaultComboBoxModel(new String[] {"IT", "Engineering", "Plain", "Electronic"}));
		combo_branch.setBounds(83, 399, 193, 22);
		panel.add(combo_branch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(301, 0, 854, 405);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4_4_1 = new JLabel(" Manage Students ");
		lblNewLabel_4_4_1.setIcon(new ImageIcon(ManageStudents.class.getResource("/images/AddNewBookIcons/icons8_Student_Male_100px.png")));
		lblNewLabel_4_4_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_4_4_1.setFont(new Font("Courier New", Font.BOLD, 30));
		lblNewLabel_4_4_1.setBounds(130, 11, 410, 96);
		panel_2.add(lblNewLabel_4_4_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(70, 164, 594, 205);
		panel_2.add(scrollPane_1);
		
		tbl_studentDetails = new JTable();
		tbl_studentDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowNo = tbl_studentDetails.getSelectedRow();
				TableModel model = tbl_studentDetails.getModel();
				
				txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
				txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
				combo_course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
				combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
				
			}
		});
		tbl_studentDetails.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Student Name", "Course", "Branch"
			}
		));
		scrollPane_1.setViewportView(tbl_studentDetails);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 0, 0));
		panel_3.setBounds(145, 118, 400, 5);
		panel_2.add(panel_3);
		
		setStudentDetailsToTabble();
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
				
				Object[] obj = {student_id, student_name, course, branch};
				
				model = (DefaultTableModel) tbl_studentDetails.getModel();
				model.addRow(obj);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public boolean addStudent() {
		boolean isAdded = false;
//		int student_id = Integer.parseInt(txt_studentId.getText());
		String student_name = txt_studentName.getText();
		String course = combo_course.getSelectedItem().toString();
		String branch = combo_branch.getSelectedItem().toString();
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "insert into student_details(student_name, course, branch) values (?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, student_name);
			pst.setString(2, course);
			pst.setString(3, branch);
			
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
	
	public boolean updateStudent() {
		boolean isUpdate = false;
    	int student_id = Integer.parseInt(txt_studentId.getText());
		String student_name = txt_studentName.getText();
		String course = combo_course.getSelectedItem().toString();
		String branch = combo_branch.getSelectedItem().toString();
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "update student_details set student_name = ?, course = ?, branch = ? where student_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, student_name);
			pst.setString(2, course);
			pst.setString(3, branch);
			pst.setInt(4, student_id);
			
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
	
	public boolean deleteStudent() {
		boolean isDelete = false;
		int student_id = Integer.parseInt(txt_studentId.getText());
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "delete from student_details where student_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setInt(1, student_id);
			
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
		DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
		model.setRowCount(0);
	}
}
