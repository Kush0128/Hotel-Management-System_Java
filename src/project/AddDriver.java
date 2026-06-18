package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener {
	
	JTextField tfdname , tfdage, tfcarcomp, tfcarmodel, tflocation;
	JComboBox  gendercombo, availablecombo;
	JButton addDriver, cancel;
	
	public AddDriver() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("ADD DRIVER");
		setBounds(230, 200, 940,500);
		
		JLabel heading = new JLabel("Add Driver");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 20, 200, 20);
		add(heading);
		
		JLabel lbldname = new JLabel("NAME");
		lbldname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldname.setBounds(60, 80, 120, 30);
		add(lbldname);
		
		tfdname = new JTextField();
		tfdname.setBounds(200, 80, 150, 30);
		add(tfdname);
		
		JLabel lbldage = new JLabel("AGE");
		lbldage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldage.setBounds(60, 130, 120, 30);
		add(lbldage);
		
		
		
		tfdage = new JTextField();
		tfdage.setBounds(200, 130, 150, 30);
		add(tfdage);
		
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(60, 180, 120, 30);
		add(lblGender);
		
		String genderOption[] = { "Male", "Female"};
		
		gendercombo = new JComboBox(genderOption);
		gendercombo.setBackground(Color.WHITE);
		gendercombo.setBounds(200, 180, 150, 30);
		add(gendercombo);
		
		JLabel lblcarcomp = new JLabel("Car Company");
		lblcarcomp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcarcomp.setBounds(60, 230, 120, 30);
		add(lblcarcomp);
		
		tfcarcomp = new JTextField();
		tfcarcomp.setBounds(200, 230, 150, 30);
		add(tfcarcomp);
		
		JLabel lblcarmodel = new JLabel("Car Model");
		lblcarmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcarmodel.setBounds(60, 280, 120, 30);
		add(lblcarmodel);
		
		tfcarmodel = new JTextField();
		tfcarmodel.setBounds(200, 280, 150, 30);
		add(tfcarmodel);
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblavailable.setBounds(60, 330, 120, 30);
		add(lblavailable);
		
		String availableOption[] = { "Available", "Busy"};
		
		availablecombo = new JComboBox(availableOption);
		availablecombo.setBackground(Color.WHITE);
		availablecombo.setBounds(200, 330, 150, 30);
		add(availablecombo);
		
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLocation.setBounds(60, 380, 120, 30);
		add(lblLocation);
		
		tflocation = new JTextField();
		tflocation.setBackground(Color.WHITE);
		tflocation.setBounds(200, 380, 150, 30);
		add(tflocation);
		
		addDriver = new JButton("Add Driver");
		addDriver.setForeground(Color.WHITE);
		addDriver.setBackground(Color.BLACK);
		addDriver.setBounds(60, 430, 130, 30);
		add(addDriver);
		addDriver.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(220, 430, 130, 30);
		add(cancel);
		cancel.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\eleven.jpg");
		Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 30, 500, 400);
		add(image);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddDriver();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==addDriver) {
			String name = tfdname.getText();
			String age = tfdage.getText();
			String gender = (String) gendercombo.getSelectedItem();
			String car_company = tfcarcomp.getText();
			String car_model = tfcarmodel.getText();
			String availability = (String) availablecombo.getSelectedItem();
			String location = tflocation.getText();
			
			
			try {
				Connect con = new Connect();
				String str = "insert into driver values('" + name + "', '" + age + "', '" + gender + "', '" + car_company + "', '" + car_model + "', '" + availability + "', '" + location + "')";
				con.st.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Driver added Sucessfully");
				setVisible(false);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()== cancel) {
			setVisible(false);
		}
	}

}
