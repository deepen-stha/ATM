import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Billpayment2 extends FirstGui{

	private JFrame frame;
	private JTextField payhere;
	
	public static String temp;
	public int amount;
	
	//defined for jdbc connection
	Connection conn =null;

	/**
	 * Launch the application.
	 */
	public void pay2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp =FirstGui.total_pan;
					System.out.println(temp);
					Billpayment2 window = new Billpayment2();
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
	public Billpayment2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
			Statement stmt = conn.createStatement();

			String query = "select * from balance where PAN = ?";
			PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, temp);
            ResultSet rs = pst.executeQuery();
			
			//System.out.println(rs.getString(1)+" "+rs.getString(2));
            amount = rs.getInt(1);
            System.out.println(amount);
            conn.close();

		}
		catch(Exception e) {
			System.out.println("select exception");
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER THE AMOUNT TO PAY HERE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(85, 11, 292, 26);
		frame.getContentPane().add(lblNewLabel);
		
		payhere = new JTextField();
		payhere.setBounds(137, 69, 159, 20);
		frame.getContentPane().add(payhere);
		payhere.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("AMOUNT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(64, 71, 63, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("PAY");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getttingn the amount entered
				int temp_amount = Integer.parseInt(payhere.getText().toString());
				if(temp_amount>=(amount-500)) {
					JOptionPane.showMessageDialog(null, "your account balance is not sufficient");
				}
				else {
					int amount_remaining = amount-temp_amount;
					calculate(amount_remaining);
					final_gui f1 = new final_gui();
					f1.final_fun();
					//sqlconn s1 = new sqlconn();
					//s1.main(amount_remaining);
					

				}
			}
		});
		btnNewButton.setBounds(187, 164, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anon\\Downloads\\Pay-Electricity-Bill-Online.jpg"));
		lblNewLabel_2.setBounds(20, 11, 414, 250);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anon\\Desktop\\deepen\\6th sem\\photo-1582058989417-5b48e919ff84.webp"));
		lblNewLabel_3.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_3);
	}
	
	public void calculate(int amount2) {
		try {
			Class.forName("org.sqlite.JDBC");
			int amount =amount2;
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
			PreparedStatement pst;
			Statement stmt = conn.createStatement();
			
			//String sql = "UPDATE balance SET amount= ? WHERE PAN = ?";

			pst = conn.prepareStatement("UPDATE balance SET amount= ? WHERE PAN = ?");
			
            //pst.setInt(1,amount_remaining);
            pst.setInt(1, amount);
            pst.setString(2, temp);
            pst.executeUpdate();
			
			conn.close();
			System.out.println("no error");
			JOptionPane.showMessageDialog(null, "payment successful..");
			} 
		catch (Exception e1) {
			System.out.println(e1);
		}
	
	}
}
