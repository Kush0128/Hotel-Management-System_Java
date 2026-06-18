package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class AddCustomer extends JFrame implements ActionListener {
	
	JComboBox idcombo;
	JTextField tfnumber, tfname, tfcountry, tfdeposit;
	JRadioButton rbtnmale, rbtnfemale;
	Choice croom;
	JButton addCustomer, back;
	JLabel checkintime;
	public AddCustomer() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("ADD CUSTOMER");
		setBounds(350, 200, 800, 560);
		
		JLabel heading = new JLabel("NEW CUSTOMER FORM");
		heading.setFont(new Font("Raleway", Font.BOLD, 18));
		heading.setBounds(100, 20, 300, 30);
		add(heading);
		
		
		
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblid.setBounds(35, 80, 100, 30);
		add(lblid);
		
		String idoption[] = {"Aadhar Card", "Passport", "Driving Licence", "Voter-Id Card"};
		
		idcombo = new JComboBox(idoption);
		idcombo.setBounds(220, 80, 150, 30);
		idcombo.setBackground(Color.WHITE);
		add(idcombo);
		
		JLabel lblnumber = new JLabel("NUMBER");
		lblnumber.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblnumber.setBounds(35, 130, 100, 30);
		add(lblnumber);
		
		tfnumber = new JTextField();
		tfnumber.setBounds(220, 130, 150, 30);
		add(tfnumber);
		
		
		JLabel lblname = new JLabel("NAME");
		lblname.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblname.setBounds(35, 180, 100, 30);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(220, 180, 150, 30);
		add(tfname);
		
		JLabel lblgender = new JLabel("GENDER");
		lblgender.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblgender.setBounds(35, 230, 100, 30);
		add(lblgender);
		
		rbtnmale = new JRadioButton("Male");
		rbtnmale.setBounds(220, 230, 75, 30);
		rbtnmale.setBackground(Color.WHITE);
		add(rbtnmale);
		
		rbtnfemale = new JRadioButton("Female");
		rbtnfemale.setBounds(300, 230, 75, 30);
		rbtnfemale.setBackground(Color.WHITE);
		add(rbtnfemale);
		
		ButtonGroup Gender = new ButtonGroup();
		Gender.add(rbtnmale);
		Gender.add(rbtnfemale);
		
		JLabel lblcountry = new JLabel("COUNTRY");
		lblcountry.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblcountry.setBounds(35, 280, 100, 30);
		add(lblcountry);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(220, 280, 150, 30);
		add(tfcountry);
		
		JLabel lblalroomno = new JLabel("Allocated Room No.");
		lblalroomno.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblalroomno.setBounds(35, 330, 170, 16);
		add(lblalroomno);
		
		croom = new Choice();
		croom.setBounds(220, 330, 150, 30);
		add(croom);
		
		try {
			Connect con = new Connect();
			String query = "select * from room where availability = 'Available'";
			ResultSet rs = con.st.executeQuery(query);
			while(rs.next()) {
				croom.add(rs.getString("roomnumber"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblchqintime = new JLabel("Check-In-Time");
		lblchqintime.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblchqintime.setBounds(35, 380, 170, 16);
		add(lblchqintime);
		
		Date date = new Date();
		checkintime = new JLabel(" " + date);
		checkintime.setBounds(200, 380, 175, 16);
		add(checkintime);
		
		
		
		JLabel lbldeposit = new JLabel("DEPOSIT");
		lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 18));
		lbldeposit.setBounds(35, 430, 100, 30);
		add(lbldeposit);
		
		tfdeposit = new JTextField();
		tfdeposit.setBounds(220, 430, 150, 30);
		add(tfdeposit);
		
		addCustomer = new JButton("Add Customer");
		addCustomer.setBackground(Color.BLACK);
		addCustomer.setForeground(Color.WHITE);
		addCustomer.setBounds(35, 480, 150, 30);
		add(addCustomer);
		addCustomer.addActionListener(this);
		
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(220, 480, 150, 30);
		add(back);
		back.addActionListener(this);
		
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\fifth.png");
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 50, 300, 400);
		add(image);
		setVisible(true);
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddCustomer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== addCustomer) {
			String idtype = (String) idcombo.getSelectedItem();
			String idnumber = tfnumber.getText();
			String name = tfname.getText();
			String gender = null;
			if(rbtnmale.isSelected()) {
				gender = "Male";
			}else if(rbtnfemale.isSelected()) {
				gender = "Female";
			}
			
			String country = tfcountry.getText();
			String roomno = croom.getSelectedItem();
			String checktime = checkintime.getText();
			String deposit = tfdeposit.getText();
			
			try {
				Connect  con = new Connect();
				String query = "insert into customer values('" + idtype + " ', '" + idnumber + "', '" + name + "', '" + gender + "', '" + country + "', '" + roomno + "', '" + checktime + "', '" + deposit + "')";
				String query2 = "update room set availability = 'Ocupied' where roomnumber = '" + roomno + "' ";
				con.st.executeUpdate(query);
				con.st.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
				setVisible(false);
				new HotelManagementApplication();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource()== back) {
			setVisible(false);
			new Reception();
		}
	}

}
