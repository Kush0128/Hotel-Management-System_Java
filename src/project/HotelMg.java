package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelMg extends JFrame  implements ActionListener {
	
	public HotelMg() {
		JLabel bgImage = null;
//		JFrame frame = new JFrame("SET BACKGROUND IMAGE	");
		setTitle("Hotel Management");
		setSize(1200,700);
		setLayout(null);	
		setLocation(0,0);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
			ImageIcon img = new ImageIcon("C:\\Users\\kaku\\eclipse-workspace\\Hotel_Management_System\\src\\project\\icons\\img1.jpg");
			Image img1 = img.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
			ImageIcon img2 = new ImageIcon(img1);
			bgImage = new JLabel(img2);
			bgImage.setBounds(0,  0, 1200, 700);
			
			JLabel hotelName = new JLabel("Sharma’s Starlight Hotel");
	        hotelName.setBounds(30, 50, 1000, 100);
	        hotelName.setFont(new Font("serif", Font.BOLD, 90));
	        hotelName.setForeground(Color.WHITE);
	        bgImage.add(hotelName);

			
			JLabel text = new JLabel("Sharma’s Starlight Hotel");
			text.setBounds(30, 500, 1000, 100);
			text.setFont(new Font("serif",Font.PLAIN,90));
			text.setForeground(Color.RED);
			bgImage.add(text);
			
			JLabel description = new JLabel("<html>Sharma’s Starlight Hotel is a luxurious retreat nestled in the heart of a bustling city. This elegant hotel offers a blend of modern amenities and classic charm, ensuring a comfortable and memorable stay for all guests. With spacious rooms, top-notch dining options, and a serene spa, Sharma’s Starlight Hotel is perfect for both business and leisure travelers. Guests can enjoy stunning city views, impeccable service, and a range of facilities designed to cater to every need. Whether you’re here for a short stay or an extended visit, Sharma’s Starlight Hotel promises an unforgettable experience. </html>");
			description.setBounds(30, 200, 1000, 200);
			description.setFont(new Font("serif",Font.PLAIN,20));
			description.setForeground(Color.WHITE);
			bgImage.add(description);
			
			JButton nextBtn = new JButton("Next");
			nextBtn.setBounds(950, 500, 200, 100);
			nextBtn.setFont(new Font("serif", Font.BOLD,50));
			nextBtn.setForeground(Color.WHITE);
			nextBtn.setBackground(Color.BLACK);
			nextBtn.addActionListener(this);
			
			bgImage.add(nextBtn);
			
			add(bgImage);
			setVisible(true);
			
			while(true) {
				text.setVisible(false);
				try {
					Thread.sleep(500);
				}
				catch(Exception e) {
					System.out.print(e);
				}
				
				text.setVisible(true);
				try {
					Thread.sleep(500);
				}
				catch(Exception e) {
					System.out.print(e);
				}
			}

			
			
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		new LoginScreen().setVisible(true);
		this.setVisible(false);
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelMg obj = new HotelMg();

	}

}
