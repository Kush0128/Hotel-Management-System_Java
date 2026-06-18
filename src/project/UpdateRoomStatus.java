package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class UpdateRoomStatus extends JFrame implements ActionListener {
	Choice ccustomer;
	JTextField tfroomno, tfavailablity,tfcleaningsts;
	JButton btncheck, btnupdate, back;
	JComboBox availablecombo, cleancombo;
	
	public UpdateRoomStatus() {
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("UPDATE ROOM STATUS");
		setBounds(230, 200, 940,470);
		
		JLabel heading = new JLabel("UPDATE ROOM STATUS");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(100, 20, 250, 20);
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
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblroomno.setBounds(60, 130, 120, 30);
		add(lblroomno);
		
		tfroomno = new JTextField();
		tfroomno.setBounds(200, 130, 150, 30);
		add(tfroomno);
		
		JLabel lblavailablity = new JLabel("Availability");
		lblavailablity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblavailablity.setBounds(60, 180, 120, 30);
		add(lblavailablity);
		
		String availableOption[] = { "Available", "Ocupied"};
		
		availablecombo = new JComboBox(availableOption);
		availablecombo.setBackground(Color.WHITE);
		availablecombo.setBounds(200, 180, 150, 30);
		add(availablecombo);
		
		JLabel lblcleaningsts = new JLabel("Cleaning Status");
		lblcleaningsts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcleaningsts.setBounds(60, 230, 120, 30);
		add(lblcleaningsts);
		
		String cleanOption[] = { "Cleaned", "Dirty"};
		
		cleancombo = new JComboBox(cleanOption);
		cleancombo.setBackground(Color.WHITE);
		cleancombo.setBounds(200, 230, 150, 30);
		add(cleancombo);
		

		
		
		btncheck = new JButton("Check");
		btncheck.setForeground(Color.WHITE);
		btncheck.setBackground(Color.BLACK);
		btncheck.setBounds(60, 300, 90, 30);
		add(btncheck);
		btncheck.addActionListener(this);
		
		btnupdate = new JButton("Update");
		btnupdate.setForeground(Color.WHITE);
		btnupdate.setBackground(Color.BLACK);
		btnupdate.setBounds(160, 300, 90, 30);
		add(btnupdate);
		btnupdate.addActionListener(this);
		
		back = new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(260, 300, 90, 30);
		add(back);
		back.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\seventh.jpg");
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 30, 500, 300);
		add(image);
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateRoomStatus();
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
					
					tfroomno.setText(rs.getString("roomno"));
					
				}
				
				ResultSet rs2 = con.st.executeQuery("select * from room where roomnumber = '" + tfroomno.getText() +"'  ");
				
				while(rs2.next()) {
					
					availablecombo.setSelectedItem(rs2.getString("availability"));
					cleancombo.setSelectedItem(rs2.getString("cleaning_status"));
				}
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()== btnupdate) {
			
			String idnumber = ccustomer.getSelectedItem();
			
			String roomnumber = tfroomno.getText();
			String availability = (String) availablecombo.getSelectedItem();

			String cleaning_status = (String) cleancombo.getSelectedItem();
			
			try {
				Connect con = new Connect();
//				String query = "update room set roomnumber = '" + roomnumber + "', availability = '" + availability + "', cleaning_status = '" + cleaning_status + "'  ";

				String query = "update room set  availability = '" + availability + "', cleaning_status = '" + cleaning_status + "'  ";
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
