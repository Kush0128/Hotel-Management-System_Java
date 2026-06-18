package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class LoginScreen extends JFrame implements ActionListener {
	
	JTextField username;
	JPasswordField password;
	
	JButton login, cancel;
	public LoginScreen() {

		setTitle("Login");
		setLayout(null);
		setBounds(500, 200, 600, 300);
		setVisible(true);
		
		JLabel user = new JLabel("User");
		user.setBounds(40, 20, 100, 30);
		add(user);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 70, 100, 30);
		add(pass);
		
		username = new JTextField();
		username.setBounds(150, 20, 150, 30);
		add(username);
		
		
		
		password = new JPasswordField();
		password.setBounds(150, 70, 150, 30);
		add(password);
		
		login = new JButton("Login");
		login.setBounds(40, 150, 120, 30);
		add(login);
		login.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 150, 120, 30);
		add(cancel);
		cancel.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\second.jpg");
		JLabel loginImg = new JLabel(i1);
		loginImg.setBounds(350, 10, 200, 200);
		add(loginImg);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginScreen loginscreen = new LoginScreen();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login) {
			String user = username.getText();
			String pass = password.getText();
			
			
			try{
				Connect c = new Connect();
				String query = "select * from login where username =  '" + user + "' and password = '" + pass + "' ";
				ResultSet rs = c.st.executeQuery(query);
				Boolean b = rs.next();
				
				if(b) {
					setVisible(false);
					Dashboard db = new Dashboard();
					db.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");

				}
				
			}catch(Exception e1) {
				e1.printStackTrace();
				
			}
			
			
		}else if(e.getSource() == cancel) {
			setVisible(false);
			new HotelMg();
		}
	}

}
