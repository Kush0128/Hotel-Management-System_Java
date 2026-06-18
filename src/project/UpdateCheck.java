package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {

	Choice ccustomer;
	JTextField tfroomno, tfname , tfcheckintime,tfdeposit,tfpending;
	JButton btncheck, btnupdate, back;
	
	public UpdateCheck() {
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("UPDATE CHECK");
		setBounds(230, 200, 940,470);
		
		JLabel heading = new JLabel("UPDATE CHECK");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 20, 200, 20);
		add(heading);
		
		JLabel lblcustid = new JLabel("Customer ID");
		lblcustid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcustid.setBounds(60, 80, 120, 30);
		add(lblcustid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200, 80, 150, 30);
		add(ccustomer);
		
		try {
			Connect con = new Connect();
			String query = "select * from customer";
			ResultSet rs = con.st.executeQuery(query);
			while(rs.next()) {
				ccustomer.add(rs.getString("idnumber"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblname.setBounds(60, 130, 120, 30);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 130, 150, 30);
		add(tfname);
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblroomno.setBounds(60, 180, 120, 30);
		add(lblroomno);
		
		tfroomno = new JTextField();
		tfroomno.setBounds(200, 180, 150, 30);
		add(tfroomno);
		
		JLabel lblcheckintime = new JLabel("Check-in-time");
		lblcheckintime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcheckintime.setBounds(60, 230, 120, 30);
		add(lblcheckintime);
		
		tfcheckintime = new JTextField();
		tfcheckintime.setBounds(200, 230, 150, 30);
		add(tfcheckintime);
		
		JLabel lbldeposit = new JLabel("Deposit");
		lbldeposit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldeposit.setBounds(60, 280, 120, 30);
		add(lbldeposit);
		
		tfdeposit = new JTextField();
		tfdeposit.setBounds(200, 280, 150, 30);
		add(tfdeposit);
		
		JLabel lblpending = new JLabel("Pending");
		lblpending.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpending.setBounds(60, 330, 120, 30);
		add(lblpending);
		
		tfpending = new JTextField();
		tfpending.setBounds(200, 330, 150, 30);
		add(tfpending);
		
		
		
		
		
		btncheck = new JButton("Check");
		btncheck.setForeground(Color.WHITE);
		btncheck.setBackground(Color.BLACK);
		btncheck.setBounds(60, 380, 90, 30);
		add(btncheck);
		btncheck.addActionListener(this);
		
		btnupdate = new JButton("Update");
		btnupdate.setForeground(Color.WHITE);
		btnupdate.setBackground(Color.BLACK);
		btnupdate.setBounds(160, 380, 90, 30);
		add(btnupdate);
		btnupdate.addActionListener(this);
		
		back = new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(260, 380, 90, 30);
		add(back);
		back.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\nine.jpg");
		JLabel image = new JLabel(i1);
		image.setBounds(400, 30, 500, 300);
		add(image);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateCheck();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btncheck) {
			try {
				Connect con = new Connect();
				String idno = ccustomer.getSelectedItem();
				
				String query = "select * from customer where idnumber = '" + idno + "'  ";
				
				ResultSet rs = con.st.executeQuery(query);
				
				while(rs.next()) {
  
					tfname.setText(rs.getString("name"));
					tfroomno.setText(rs.getString("roomno"));
					tfcheckintime.setText(rs.getString("checktime"));
					tfdeposit.setText(rs.getString("deposit"));
				}
				
				ResultSet rs2 = con.st.executeQuery("select * from room where roomnumber = '" + tfroomno.getText() +"'  ");
				
				while(rs2.next()) {
					String price = rs2.getString("price");
					
					int pending = Integer.parseInt(price) - Integer.parseInt(tfdeposit.getText());
					tfpending.setText("" + pending);
				}
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			
		}else if(e.getSource()== btnupdate) {
			
			String idnumber = ccustomer.getSelectedItem();
			
			String name = tfname.getText();
			String roomno = tfroomno.getText();
			String checkintime = tfcheckintime.getText();
			String deposit = tfdeposit.getText();
			
			try {
				Connect con = new Connect();
				
				String query = "update customer set name = '" + name + "', roomno = '" + roomno + "', checktime = '" + checkintime + "', deposit = '" + deposit + "'  ";
				con.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Data Update Successfully");
				setVisible(false);
				new Reception();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(e.getSource()== back) {
			setVisible(false);
			new Reception();
		}
	}

}
