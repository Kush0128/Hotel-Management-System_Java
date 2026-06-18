package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddRoom extends JFrame implements ActionListener {
	
	JTextField tfroomno , tfprice;
	JComboBox availablecombo, cleancombo, bedtypecombo;
	JButton addroom, cancel;
	
	public AddRoom() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("ADD ROOM");
		setBounds(230, 200, 940,470);
		
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 20, 200, 20);
		add(heading);
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblroomno.setBounds(60, 80, 120, 30);
		add(lblroomno);
		
		tfroomno = new JTextField();
		tfroomno.setBounds(200, 80, 150, 30);
		add(tfroomno);
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblavailable.setBounds(60, 130, 120, 30);
		add(lblavailable);
		
		String availableOption[] = { "Available", "Ocupied"};
		
		availablecombo = new JComboBox(availableOption);
		availablecombo.setBackground(Color.WHITE);
		availablecombo.setBounds(200, 130, 150, 30);
		add(availablecombo);
		
		
		JLabel lblclean = new JLabel("Cleaning Status");
		lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblclean.setBounds(60, 180, 120, 30);
		add(lblclean);
		
		String cleanOption[] = { "Cleaned", "Dirty"};
		
		cleancombo = new JComboBox(cleanOption);
		cleancombo.setBackground(Color.WHITE);
		cleancombo.setBounds(200, 180, 150, 30);
		add(cleancombo);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblprice.setBounds(60, 230, 120, 30);
		add(lblprice);
		
		tfprice = new JTextField();
		tfprice.setBounds(200, 230, 150, 30);
		add(tfprice);
		
		JLabel lblbedtype = new JLabel("Bed Type");
		lblbedtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblbedtype.setBounds(60, 280, 120, 30);
		add(lblbedtype);
		
		String bedtypeOption[] = { "Single Bed", "Double Bed"};
		
		bedtypecombo = new JComboBox(bedtypeOption);
		bedtypecombo.setBackground(Color.WHITE);
		bedtypecombo.setBounds(200, 280, 150, 30);
		add(bedtypecombo);
		
		addroom = new JButton("Add Room");
		addroom.setForeground(Color.WHITE);
		addroom.setBackground(Color.BLACK);
		addroom.setBounds(60, 350, 130, 30);
		add(addroom);
		addroom.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(220, 350, 130, 30);
		add(cancel);
		cancel.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\twelve.jpg");
		JLabel image = new JLabel(i1);
		image.setBounds(400, 30, 500, 300);
		add(image);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddRoom();
	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		// TODO Auto-generated method stub
		if(e.getSource()==addroom) {
			String roomno = tfroomno.getText();
			String availability = (String) availablecombo.getSelectedItem();
			String clean_status = (String) cleancombo.getSelectedItem();
			String price = tfprice.getText();
			String bedtype = (String) bedtypecombo.getSelectedItem();
			
			try {
				Connect con = new Connect();
				String str = "insert into room values('" + roomno + "', '" + availability + "', '" + clean_status + "', '" + price + "', '" + bedtype + "')";
				con.st.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "New Room added Sucessfully");
				setVisible(false);
			}
			catch(SQLIntegrityConstraintViolationException e2) {
				JOptionPane.showMessageDialog(null, "Room number alredy exist");
				return;
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource()== cancel) {
			setVisible(false);
		}
	}

}
