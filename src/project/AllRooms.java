package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;

public class AllRooms extends JFrame implements ActionListener{
	JButton back;
	public AllRooms() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("ALL ROOMS");
		setBounds(100, 100, 1130, 650);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\eight.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500, 0, 600,600);
		add(image);
		
		JLabel lb1 = new JLabel("roomnumber");
		lb1.setBounds(10,10,80,20);
		add(lb1);
		
		JLabel lb2 = new JLabel(" availability");
		lb2.setBounds(100,10,100,20);
		add(lb2);
		
		JLabel lb3 = new JLabel("cleaning_status");
		lb3.setBounds(200,10,100,20);
		add(lb3);
		
		JLabel lb4 = new JLabel("price");
		lb4.setBounds(300,10,100,20);
		add(lb4);
		
		JLabel lb5 = new JLabel("bedtype");
		lb5.setBounds(400,10,100,20);
		add(lb5);
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(100, 550, 300, 30);
		add(back);
		back.addActionListener(this);
		
		
		JTable table;
		
		
		try {
			Connect con = new Connect();
			String query = "select * from room";
			ResultSet rs = con.st.executeQuery(query);
			
			
			table = new JTable();
			table.setBounds(0,40,500,500);
			add(table);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AllRooms();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new HotelManagementApplication();
	}

}
