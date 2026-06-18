package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Reception extends JFrame implements ActionListener{
	JButton newcustomer , rooms, department, allemployees, customerinfo, checkout, updateroomsts, pickupsrv, searchroom, Logout;
	public Reception() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("RECEPTION");
		setBounds(270, 175, 800, 570);
		
		newcustomer = new JButton("New Customer Form");
		newcustomer.setBackground(Color.BLACK);
		newcustomer.setForeground(Color.WHITE);
		newcustomer.setBounds(10, 30, 200, 40);
		add(newcustomer);
		newcustomer.addActionListener(this);
		
		rooms = new JButton("Rooms");
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.WHITE);
		rooms.setBounds(10, 80, 200, 40);
		add(rooms);
		rooms.addActionListener(this);
		
		department = new JButton("Department");
		department.setBackground(Color.BLACK);
		department.setForeground(Color.WHITE);
		department.setBounds(10, 130, 200, 40);
		add(department);
		department.addActionListener(this);
		
		allemployees = new JButton("All Employees");
		allemployees.setBackground(Color.BLACK);
		allemployees.setForeground(Color.WHITE);
		allemployees.setBounds(10, 180, 200, 40);
		add(allemployees);
		allemployees.addActionListener(this);
		
		customerinfo = new JButton("Customer Info");
		customerinfo.setBackground(Color.BLACK);
		customerinfo.setForeground(Color.WHITE);
		customerinfo.setBounds(10, 230, 200, 40);
		add(customerinfo);
		customerinfo.addActionListener(this);
		
		checkout = new JButton("Checkout");
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.setBounds(10, 280, 200, 40);
		add(checkout);
		checkout.addActionListener(this);
		
		updateroomsts = new JButton("Update Room Status");
		updateroomsts.setBackground(Color.BLACK);
		updateroomsts.setForeground(Color.WHITE);
		updateroomsts.setBounds(10, 330, 200, 40);
		add(updateroomsts);
		updateroomsts.addActionListener(this);
		
		pickupsrv = new JButton("Pickup Service");
		pickupsrv.setBackground(Color.BLACK);
		pickupsrv.setForeground(Color.WHITE);
		pickupsrv.setBounds(10, 380, 200, 40);
		add(pickupsrv);
		pickupsrv.addActionListener(this);
		
		searchroom = new JButton("Search Room");
		searchroom.setBackground(Color.BLACK);
		searchroom.setForeground(Color.WHITE);
		searchroom.setBounds(10, 430, 200, 40);
		add(searchroom);
		searchroom.addActionListener(this);
		
		Logout = new JButton("Logout");
		Logout.setBackground(Color.BLACK);
		Logout.setForeground(Color.WHITE);
		Logout.setBounds(10, 480, 200, 40);
		add(Logout);
		Logout.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\fourth.jpg");
		JLabel image = new JLabel(i1);
		image.setBounds(250, 30, 500, 470);
		add(image);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Reception();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== newcustomer) {
			setVisible(false);
			new AddCustomer();
		}else if(e.getSource()== rooms) {
			setVisible(false);
			new AllRooms();
		}else if(e.getSource()== department) {
			setVisible(false);
			new Department();
		}else if(e.getSource()== allemployees) {
			setVisible(false);
			new AllEmployees();
		}else if(e.getSource()== customerinfo) {
			setVisible(false);
			new CustomerInfo();
		}else if(e.getSource()== searchroom) {
			setVisible(false);
			new SearchRoom();
		}else if(e.getSource()== updateroomsts) {
			setVisible(false);
			new UpdateRoomStatus();
		}else if(e.getSource()== checkout ) {
			setVisible(false);
			new UpdateCheck();
		}else if(e.getSource()== pickupsrv) {
			
		}else if(e.getSource()== Logout) {
			setVisible(false);
			new LoginScreen();
		}
	}

}
