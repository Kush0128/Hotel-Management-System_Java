package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
	
	JButton back;
	public Department() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("DEPARTMENT & BUDGET");
		setBounds(100, 100, 1130, 650);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\eight.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500, 0, 600,600);
		add(image);
		
		JLabel department = new JLabel("Department");
		department.setBounds(10,10,80,20);
		add(department);
		
		JLabel budget = new JLabel(" Budget");
		budget.setBounds(300,10,100,20);
		add(budget);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(100, 550, 300, 30);
		add(back);
		back.addActionListener(this);
		
JTable table;
		
		
		try {
			Connect con = new Connect();
			String query = "select * from department";
			ResultSet rs = con.st.executeQuery(query);
			
			
			table = new JTable();
			table.setBounds(5,40,500,500);
			add(table);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Department();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Reception();
	}

}
