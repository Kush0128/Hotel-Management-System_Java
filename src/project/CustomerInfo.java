package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
	JButton back;
	public CustomerInfo() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("ALL CUSTOMER");
		setBounds(100, 100, 1130, 650);
		
//		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\eight.jpg");
//		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel image = new JLabel(i3);
//		image.setBounds(500, 0, 600,600);
//		add(image);
		
		JLabel lblidtype = new JLabel("idtype");
		lblidtype.setBounds(10,10,80,20);
		add(lblidtype);
		
		JLabel lblidnumber = new JLabel("idnumber");
		lblidnumber.setBounds(140,10,100,20);
		add(lblidnumber);
		
		JLabel lblname = new JLabel("name");
		lblname.setBounds(270,10,80,20);
		add(lblname);
		
		JLabel lblgender = new JLabel("gender");
		lblgender.setBounds(400,10,100,20);
		add(lblgender);
		
		JLabel lblcountry = new JLabel("country");
		lblcountry.setBounds(530,10,80,20);
		add(lblcountry);
		
		JLabel lblroomno = new JLabel(" roomno");
		lblroomno.setBounds(655,10,100,20);
		add(lblroomno);
		
		JLabel lblchecktime = new JLabel("checktime");
		lblchecktime.setBounds(790,10,150,20);
		add(lblchecktime);
		
		JLabel lbldeposit = new JLabel("deposit");
		lbldeposit.setBounds(925,10,150,20);
		add(lbldeposit);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(275, 550, 600, 30);
		add(back);
		back.addActionListener(this);
		
		JTable table;
		
		
		try {
			Connect con = new Connect();
			String query = "select * from customer";
			ResultSet rs = con.st.executeQuery(query);
			
			
			table = new JTable();
			table.setBounds(5,40,1050,500);
			add(table);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerInfo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new HotelManagementApplication();
	}

}
