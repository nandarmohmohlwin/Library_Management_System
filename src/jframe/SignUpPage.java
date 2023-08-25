package jframe;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class SignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_email;
	private JTextField txt_contact;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
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
	public SignUpPage() {
		setBackground(new Color(255, 255, 255));
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1245, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(897, 0, 600, 800);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/lms4.png")));
		lblNewLabel.setBounds(23, 56, 776, 450);
		contentPane.add(lblNewLabel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SignUp Page");
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 18));
		lblNewLabel_1.setBounds(92, 21, 121, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(90, 107, 72, 17);
		panel.add(lblNewLabel_3);
		
		txt_username = new JTextField();
		txt_username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
//				if(validateDuplicateUser() == true) {
//					JOptionPane.showMessageDialog(this, "User already exist");
//				}
				validateDuplicateUser();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Create New Account Here");
		lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(65, 53, 184, 17);
		panel.add(lblNewLabel_2);
		txt_username.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_username.setBounds(90, 153, 186, 23);
		panel.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/adminIcons/male_user_50px.png")));
		lblNewLabel_4.setBounds(30, 130, 50, 50);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(90, 200, 64, 17);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Email");
		lblNewLabel_3_2.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(92, 291, 40, 17);
		panel.add(lblNewLabel_3_2);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_email.setColumns(10);
		txt_email.setBounds(90, 331, 186, 23);
		panel.add(txt_email);
		
		JLabel lblNewLabel_3_3 = new JLabel("Contact");
		lblNewLabel_3_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(92, 385, 56, 17);
		panel.add(lblNewLabel_3_3);
		
		txt_contact = new JTextField();
		txt_contact.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_contact.setColumns(10);
		txt_contact.setBounds(92, 433, 184, 23);
		panel.add(txt_contact);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(90, 235, 186, 20);
		panel.add(txt_password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLogin();
			}
		});
		btnLogin.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnLogin.setBounds(190, 506, 121, 39);
		panel.add(btnLogin);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertSignUpDetails();
			}
		});
		btnSignup.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnSignup.setBounds(36, 506, 129, 39);
		panel.add(btnSignup);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/icons/icons8_Forgot_Password_50px_4.png")));
		lblNewLabel_4_1.setBounds(30, 205, 50, 50);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/icons/icons8_Secured_Letter_50px.png")));
		lblNewLabel_4_2.setBounds(30, 304, 50, 50);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("");
		lblNewLabel_4_3.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/icons/icons8_Google_Mobile_50px.png")));
		lblNewLabel_4_3.setBounds(30, 406, 50, 50);
		panel.add(lblNewLabel_4_3);
		
		
	}
	
	public void insertSignUpDetails() {
		String name = txt_username.getText();
		@SuppressWarnings("deprecation")
		String password = txt_password.getText();
		String email = txt_email.getText();
		String contact = txt_contact.getText();
		if(name.equals("") || password.equals("") || email.equals("") || contact.equals("") )
		{
			JOptionPane.showMessageDialog(this, "You should fill all of these data");
		}else {
			try {
				Connection connection = DBConnection.getConnection();
				String sql = "insert into user(name, password, email, contact) values (?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(sql);
				
				pst.setString(1, name);
				pst.setString(2, password);
				pst.setString(3, email);
				pst.setString(4, contact);
				
				int rowsAffected = pst.executeUpdate();
				
				if(rowsAffected > 0) {
					JOptionPane.showMessageDialog(this, "Recorded inserted successfully");
					txt_username.setText("");
					txt_password.setText("");
					txt_email.setText("");
					txt_contact.setText("");
					
					LoginPage login = new LoginPage();
					login.setExtendedState(JFrame.MAXIMIZED_BOTH);
					login.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(this, "Recorded insertion Failure");
				}
					
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//check duplicate User
	//public boolean validateDuplicateUser()
	public void validateDuplicateUser() {
		String name = txt_username.getText();
		//boolean isExist = false;
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from user where name = ?";
			PreparedStatement pst = connection.prepareStatement(sql);	
			
			pst.setString(1, name);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				//isExist = true;
				JOptionPane.showMessageDialog(this, "User already exist");
			}				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
//		return isExist;
	}
	
	public void showLogin() {
		LoginPage login = new LoginPage();
		login.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		login.setVisible(true);
		this.dispose();
	}
}
