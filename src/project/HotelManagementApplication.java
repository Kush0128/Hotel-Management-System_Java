package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HotelManagementApplication extends JFrame implements ActionListener{
	JButton newcustomer , rooms, customerinfo;
	public HotelManagementApplication() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("RECEPTION");
		setBounds(270, 175, 800, 570);
		
		newcustomer = new JButton("New Customer Form");
		newcustomer.setBackground(Color.BLACK);
		newcustomer.setForeground(Color.WHITE);
		newcustomer.setBounds(10, 130, 200, 40);
		add(newcustomer);
		newcustomer.addActionListener(this);
		
		rooms = new JButton("Rooms");
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.WHITE);
		rooms.setBounds(10, 180, 200, 40);
		add(rooms);
		rooms.addActionListener(this);
		

		
		customerinfo = new JButton("Customer Info");
		customerinfo.setBackground(Color.BLACK);
		customerinfo.setForeground(Color.WHITE);
		customerinfo.setBounds(10, 230, 200, 40);
		add(customerinfo);
		customerinfo.addActionListener(this);
		

		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\fourth.jpg");
		JLabel image = new JLabel(i1);
		image.setBounds(250, 30, 500, 470);
		add(image);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new HotelManagementApplication();
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
		}else if(e.getSource()== customerinfo) {
			setVisible(false);
			new CustomerInfo();
		}
	}

}
