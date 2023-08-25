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
public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setBackground(new Color(255, 255, 255));
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1245, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/images/lms3.png")));
		lblNewLabel.setBounds(85, 97, 521, 450);
		contentPane.add(lblNewLabel);		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(885, 0, 500, 800);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login Page");
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 18));
		lblNewLabel_1.setBounds(119, 34, 110, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome Back");
		lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(129, 61, 96, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(118, 114, 72, 17);
		panel.add(lblNewLabel_3);
		
		txt_username = new JTextField();
		txt_username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		txt_username.setFont(new Font("Courier New", Font.PLAIN, 14));
		txt_username.setBounds(117, 153, 183, 23);
		panel.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LoginPage.class.getResource("/images/icons/icons8_Account_50px.png")));
		lblNewLabel_4.setBounds(57, 126, 50, 50);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(LoginPage.class.getResource("/images/icons/icons8_Forgot_Password_50px_4.png")));
		lblNewLabel_4_1.setBounds(57, 248, 50, 50);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(126, 243, 64, 17);
		panel.add(lblNewLabel_3_1);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(126, 278, 174, 20);
		panel.add(txt_password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateLogin() == true) {
					login();
				}
			}
		});
		btnLogin.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnLogin.setBounds(69, 393, 105, 38);
		panel.add(btnLogin);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSignUp();
			}
		});
		btnSignup.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnSignup.setBounds(201, 393, 117, 38);
		panel.add(btnSignup);
	}
	
	//validation
	public boolean validateLogin() {
		String name = txt_username.getText();
		@SuppressWarnings("deprecation")
		String password = txt_password.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "Plase enter user name");
			return false;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(this, "Plase enter password");
			return false;
		}
		return true;	
	}
	
	public void login() {
		String name = txt_username.getText();
		@SuppressWarnings("deprecation")
		String password = txt_password.getText();
		
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from user where name = ? and password = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(this, "Login Successful");
				MainPage home = new MainPage();
				home.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				home.setVisible(true);
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "Incorrect username and password");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showSignUp() {
		SignUpPage signup = new SignUpPage();
		signup.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		signup.setVisible(true);
		this.dispose();
	}
}
