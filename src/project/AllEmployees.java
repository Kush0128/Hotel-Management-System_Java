package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class AllEmployees extends JFrame implements ActionListener {
	JButton back;
	public AllEmployees() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("ALL EMPLOYEES");
		setBounds(100, 100, 1130, 650);
		
		JLabel lblname = new JLabel("name");
		lblname.setBounds(10,10,80,20);
		add(lblname);
		
		JLabel lblage = new JLabel("age");
		lblage.setBounds(140,10,100,20);
		add(lblage);
		
		JLabel lblgender = new JLabel("gender");
		lblgender.setBounds(270,10,80,20);
		add(lblgender);
		
		JLabel lbljob = new JLabel("job");
		lbljob.setBounds(400,10,100,20);
		add(lbljob);
		
		JLabel lblsalary = new JLabel("salary");
		lblsalary.setBounds(530,10,80,20);
		add(lblsalary);
		
		JLabel lblphone = new JLabel(" phone");
		lblphone.setBounds(655,10,100,20);
		add(lblphone);
		
		JLabel lblemail = new JLabel("email");
		lblemail.setBounds(790,10,150,20);
		add(lblemail);
		
		JLabel lblaadhar = new JLabel("aadhar");
		lblaadhar.setBounds(925,10,150,20);
		add(lblaadhar);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(275, 550, 600, 30);
		add(back);
		back.addActionListener(this);
		
		JTable table;
		
		try {
			Connect con = new Connect();
			String query = "select * from employee";
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
		new AllEmployees();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Reception();
	}
}
