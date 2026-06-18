package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener {
	JButton Logout;
	public Dashboard() {
		setTitle("Hotel DASHBOARD");
		setLayout(null);
		setBounds(0,0,1366,768);
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\img2.jpg");
		Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bgimg = new JLabel(i3);
		bgimg.setBounds(0, 0, 1366, 768);
		add(bgimg);
		
		JMenuBar menubar = new JMenuBar();

		menubar.setBorder(null);
		menubar.setBounds(0,0,1366, 60);
		bgimg.add(menubar);
		
		
		JMenu hotelmgmt	= new JMenu("Hotel Management");
		hotelmgmt.setForeground(Color.RED);
		hotelmgmt.setFont(new Font("Arial", Font.BOLD, 25));
		menubar.add(hotelmgmt);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.setForeground(Color.BLUE);
		reception.setFont(new Font("Arial", Font.BOLD, 25));
		hotelmgmt.add(reception);
		reception.addActionListener(this);
		
//		JMenu addHotel = new JMenu("ADD HOTEL");
//		addHotel.setForeground(Color.RED);
//		addHotel.setFont(new Font("Arial", Font.BOLD, 25));
//		menubar.add(addHotel);
		
//		JMenu room = new JMenu("ROOM");
//		room.setForeground(Color.RED);
//		room.setFont(new Font("Arial", Font.BOLD, 25));
//		menubar.add(room);
//		
//		JMenuItem addRoom = new JMenuItem("ADD ROOM");
//		addRoom.setForeground(Color.BLUE);
//		addRoom.setFont(new Font("Arial", Font.BOLD, 25));
//		room.add(addRoom);
//		addRoom.addActionListener(this);
		
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.RED);
		admin.setFont(new Font("Arial", Font.BOLD, 25));
		menubar.add(admin);
		
		JMenuItem addRoom = new JMenuItem("ADD ROOM");
		addRoom.setForeground(Color.BLUE);
		addRoom.setFont(new Font("Arial", Font.BOLD, 25));
		admin.add(addRoom);
		addRoom.addActionListener(this);
		
		JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		addemployee.setForeground(Color.BLUE);
		addemployee.setFont(new Font("Arial", Font.BOLD, 25));
		admin.add(addemployee);
		addemployee.addActionListener(this);
		
		JMenuItem addDriver = new JMenuItem("ADD DRIVER");
		addDriver.setForeground(Color.BLUE);
		addDriver.setFont(new Font("Arial", Font.BOLD, 25));
		admin.add(addDriver);
		addDriver.addActionListener(this);
		
		JLabel greeting = new JLabel("Greetings from Sharma's Starlight Hotel.");
		greeting.setForeground(new Color(255, 255, 255));
		greeting.setFont(new Font("Arial", Font.BOLD, 57));
		greeting.setBounds(120, 80, 1150, 90);
		bgimg.add(greeting);
		
		Logout = new JButton("Logout");
		Logout.setBackground(Color.GRAY);
		Logout.setForeground(Color.RED);
		Logout.setBounds(950, 650, 400, 50);
		Logout.setFont(new Font("Arial", Font.BOLD, 40));
		add(Logout);
		Logout.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dashboard dashbrd = new Dashboard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee();
		}else if(e.getActionCommand().equals("ADD ROOM")) {
			new AddRoom();
		}else if(e.getActionCommand().equals("ADD DRIVER")) {
			new AddDriver();
		}else if(e.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}if(e.getSource()== Logout) {
			setVisible(false);
			new LoginScreen();
		}
		
	}

}
