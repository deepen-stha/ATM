import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Pinchange2 extends Pinchange {

	private JFrame frame;
	private static JPasswordField password1;
	
	public static int password;
	public static String temp;

	Connection conn =null;
	/**
	 * Launch the application.
	 */
	public void change2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					password = Pinchange.password;
					temp = Pinchange.temp;
					Pinchange2 window = new Pinchange2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pinchange2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RE-ENTER THE PIN TO CONFIRM");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(110, 11, 207, 30);
		frame.getContentPane().add(lblNewLabel);
		
		password1 = new JPasswordField();
		password1.setEchoChar('$');
		password1.setBounds(110, 41, 200, 20);
		frame.getContentPane().add(password1);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setForeground(new Color(0, 128, 128));
		
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					int pass = Integer.parseInt(password1.getText());
					//if current password entered is empty
					if(Integer.toString(pass).equals("")) {
						JOptionPane.showMessageDialog(null, "please enter the password field");
					}
					else if(pass==password){
						operate();
						JOptionPane.showMessageDialog(null, "password has been changed successfully");
						final_gui change = new final_gui();
						change.final_fun();
					}
				}
				catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "enter password in the field");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(302, 131, 106, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = 
				new JButton("CANCEL");
		btnNewButton_1.setForeground(new Color(72, 61, 139));
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondGUI sec = new SecondGUI();
				sec.Func2();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBounds(302, 189, 106, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anon\\Desktop\\deepen\\6th sem\\photo-1582058989417-5b48e919ff84.webp"));
		lblNewLabel_1.setBounds(-48, 0, 482, 261);
		frame.getContentPane().add(lblNewLabel_1);
	}
	public static void operate() {
		int pin = Integer.parseInt(password1.getText().toString());
		System.out.println(pin);
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
			Statement stmt = conn.createStatement();
			
			String sql = "UPDATE ATM SET PIN= "+pin+" WHERE PAN = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
            //pst.setInt(1,amount_remaining);
            pst.setString(1, temp);
            pst.executeUpdate();
			
			conn.close();
			System.out.println("no error");
			JOptionPane.showMessageDialog(null, "payment successful..");
			} 
		catch (Exception e1) {
			System.out.println("catch an exception");
		}

	}

}
