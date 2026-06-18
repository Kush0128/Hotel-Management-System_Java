package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

	JButton back, submit;
	JComboBox roomtypecombo;
	JCheckBox dispavailcheck;
	JTable table;
	public SearchRoom() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("SEARCH ROOM");
		setBounds(100, 100, 1130, 650);
		
		JLabel lblheading = new JLabel("SEARCH FOR ROOM");
		lblheading.setBounds(400,10,400,50);
		lblheading.setFont(new Font("Arial", Font.BOLD,30));
		add(lblheading);
		
		JLabel lblroomtype = new JLabel("Room Bed Type");
		lblroomtype.setBounds(200,100,100,30);
		add(lblroomtype);
		String[] roomtypeoption = {"Single Bed", "Double Bed"};
		
		
		roomtypecombo = new JComboBox(roomtypeoption);
		roomtypecombo.setBackground(Color.WHITE);
		roomtypecombo.setBounds(310,100,150,30);
		add(roomtypecombo);
		
		
		dispavailcheck = new JCheckBox("Only Display Available");
		dispavailcheck.setBackground(Color.WHITE);
		dispavailcheck.setFont(new Font("Arial", Font.BOLD, 16));
		dispavailcheck.setBounds(600,100,200,30);
		add(dispavailcheck);
		
		
		
		
		
		
		JLabel lb1 = new JLabel("roomnumber");
		lb1.setBounds(10,150,80,20);
		add(lb1);
		
		JLabel lb2 = new JLabel(" availability");
		lb2.setBounds(230,150,100,20);
		add(lb2);
		
		JLabel lb3 = new JLabel("cleaning_status");
		lb3.setBounds(450,150,100,20);
		add(lb3);
		
		JLabel lb4 = new JLabel("price");
		lb4.setBounds(670,150,100,20);
		add(lb4);
		
		JLabel lb5 = new JLabel("bedtype");
		lb5.setBounds(890,150,100,20);
		add(lb5);
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(275, 550, 600, 30);
		add(back);
		back.addActionListener(this);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(275, 500, 600, 30);
		add(submit);
		submit.addActionListener(this);
		
		
		
		table = new JTable();
		table.setBounds(5,180,1050,500);
		add(table);
		
		
		try {
			Connect con = new Connect();
			String query = "select * from room";
			ResultSet rs = con.st.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchRoom();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== submit) {
			try {
				
				Connect con = new Connect();
				String bedtypeselect = (String) roomtypecombo.getSelectedItem();
				String query = "select * from room where bedtype = '" + bedtypeselect + "' ";
				
				String query2 = "select * from room where availability = 'Available' AND bedtype = '" + bedtypeselect + "' ";
				
				ResultSet rs = null;
				
				if(dispavailcheck.isSelected()) {
					rs = con.st.executeQuery(query2);
				}else {
					rs = con.st.executeQuery(query);
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource()== back) {
			setVisible(false);
			new Reception();
		}
	}

}
