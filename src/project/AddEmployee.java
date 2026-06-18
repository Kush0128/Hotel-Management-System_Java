package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {
	
	JTextField tfename, tfeage, tfesalary, tfephone, tfeEmail, tfeaadhar;
	JRadioButton rbtnmale, rbtnfemale;
	JComboBox cbjob;
	JButton submit, cancel;
	
	public AddEmployee(){
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("ADD EMPLOYEE");
		setBounds(230, 180, 850,540);
		
		JLabel ename = new JLabel("NAME");
		ename.setBounds(60, 30, 120, 30);
		ename.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(ename);
		
		tfename = new JTextField();
		tfename.setBounds(200, 30, 150, 30);
		add(tfename);
		
		JLabel eage = new JLabel("AGE");
		eage.setBounds(60, 80, 120, 30);
		eage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(eage);
		
		tfeage = new JTextField();
		tfeage.setBounds(200, 80, 150, 30);
		add(tfeage);
		
		JLabel egender = new JLabel("GENDER");
		egender.setBounds(60, 130, 120, 30);
		egender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(egender);
		
		rbtnmale = new JRadioButton("Male");
		rbtnmale.setBounds(200, 130, 75, 30);
		rbtnmale.setBackground(Color.WHITE);
		add(rbtnmale);
		
		rbtnfemale = new JRadioButton("Female");
		rbtnfemale.setBounds(300, 130, 75, 30);
		rbtnfemale.setBackground(Color.WHITE);
		add(rbtnfemale);
		
		ButtonGroup gender = new ButtonGroup();
		gender.add(rbtnmale);
		gender.add(rbtnfemale);
		
		JLabel ejob = new JLabel("JOB");
		ejob.setBounds(60, 180, 120, 30);
		ejob.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(ejob);
		
		String[] str = {"Front Desk Clerk", "Portes", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter", "Mainager", "Accountant" };
		cbjob = new JComboBox(str);
		cbjob.setBounds(200, 180, 150, 30);
		add(cbjob);
		
		JLabel esalary = new JLabel("SALARY");
		esalary.setBounds(60, 230, 120, 30);
		esalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(esalary);
		
		tfesalary = new JTextField();
		tfesalary.setBounds(200, 230, 150, 30);
		add(tfesalary);
		
		JLabel ephone = new JLabel("PHONE");
		ephone.setBounds(60, 280, 120, 30);
		ephone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(ephone);
		
		tfephone = new JTextField();
		tfephone.setBounds(200, 280, 150, 30);
		add(tfephone);
		
		JLabel eEmail = new JLabel("EMAIL");
		eEmail.setBounds(60, 330, 120, 30);
		eEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(eEmail);
		
		tfeEmail = new JTextField();
		tfeEmail.setBounds(200, 330, 150, 30);
		add(tfeEmail);
		
		JLabel eaadhar = new JLabel("AADHAR");
		eaadhar.setBounds(60, 380, 120, 30);
		eaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(eaadhar);
		
		tfeaadhar = new JTextField();
		tfeaadhar.setBounds(200, 380, 150, 30);
		add(tfeaadhar);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(60, 430, 150, 30);
		add(submit);
		submit.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(230, 430, 150, 30);
		add(cancel);
		cancel.addActionListener(this);
		
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\tenth.jpg");
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380, 60, 450,370);
		add(image);
		
		
		
		
		
		
		setVisible(true);
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddEmployee();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== submit) {
			String empname = tfename.getText();
			String empage = tfeage.getText();
			String empsalary = tfesalary.getText();
			String empphone = tfephone.getText();
			String empemail = tfeEmail.getText();
			String empaadhar = tfeaadhar.getText();
			
			String empgender = null;
			if(rbtnmale.isSelected()) {
				empgender = "Male";
			}else if(rbtnfemale.isSelected()) {
				empgender = "Female";
			}
			
			String empjob = (String) cbjob.getSelectedItem();
			
			try {
				Connect con = new Connect();
				String query = " insert into employee values('"+ empname +"', '"+ empage +"', '"+ empgender +"', '"+ empjob +"', '"+ empsalary +"', '"+ empphone +"', '"+ empemail +"', '"+ empaadhar +"')";
				con.st.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Employe added Sucessfully");
				setVisible(false);
			
			}catch(Exception e1) {
			e1.printStackTrace();
			}
		}else if(e.getSource()== cancel) {
			setVisible(false);
			new Dashboard();
		}

}
}
