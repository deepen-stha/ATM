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
import java.awt.SystemColor;

public class funds1 extends FirstGui{

	private JFrame frame;
	private JTextField accountno;
	private JTextField amountpay;

	public static String temp;
	public int amount,amount_pay;
	
	//to connect to databse
	Connection conn = null;
	/**
	 * Launch the application.
	 */
	public void transfer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp = FirstGui.total_pan;
					funds1 window = new funds1();
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
	public funds1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
			//Statement stmt = conn.createStatement();

			String query = "select * from balance where PAN = ?";
			PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, temp);
            ResultSet rs = pst.executeQuery();
			
			//System.out.println(rs.getString(1)+" "+rs.getString(2));
            amount = rs.getInt(1);
            System.out.println(amount);
            conn.close();

		}
		catch(Exception e) {}

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FUNDS TRANSFER");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(142, 11, 159, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ACCOUNT NO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(28, 74, 89, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		accountno = new JTextField();
		accountno.setBounds(145, 73, 185, 20);
		frame.getContentPane().add(accountno);
		accountno.setColumns(10);
		
		amountpay = new JTextField();
		amountpay.setBounds(145, 115, 185, 20);
		frame.getContentPane().add(amountpay);
		amountpay.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("AMOUNT");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(28, 117, 71, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("TRANSFER\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount_pay= Integer.parseInt(amountpay.getText().toString());
				//int temp_amount = amount_pay;
				if(amount_pay>=(amount-500)) {
					JOptionPane.showMessageDialog(null, "your account balance is not sufficient");
				}
				else {
					int amount_remaining = amount-amount_pay;
					calculate(amount_remaining);
					final_gui f1 = new final_gui();
					f1.final_fun();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(297, 207, 108, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SecondGUI().Func2();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBounds(28, 207, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anon\\Desktop\\deepen\\6th sem\\online-money-transfer-services-500x500.jpg"));
		lblNewLabel_3.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_3);
	}
	
	public void calculate(int amo) {
		int amount1 = amount;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn1 = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
			//Statement stmt = conn1.createStatement();
			
			String sql = "UPDATE balance SET amount= "+amount1+" WHERE PAN = ?";
			PreparedStatement pst = conn1.prepareStatement(sql);
			
            //pst.setInt(1,amount_remaining);
            pst.setString(1, temp);
            pst.executeUpdate();
			System.out.println("succesful for sender");
            
//            //checking receiver balance with the help of their accno
//            String query = "select * from balance where accno = ?";
//			PreparedStatement pst1 = conn.prepareStatement(query);
//            pst1.setString(1,"9087667281");
//            ResultSet rs = pst1.executeQuery();
//			
//			int amount_availabe = rs.getInt(1);
//            System.out.println(amount_availabe);
//            
//            //receiver account no
//            int total_amount = amount_availabe+amount_pay;
//            String sql1 = "UPDATE balance SET amount= "+total_amount+" WHERE accno = ?";
//			PreparedStatement pst2 = conn.prepareStatement(sql1);
//			String acc ="9087667281";
//            pst2.setString(1,acc);
//            pst2.executeUpdate();
//			
			conn.close();
			System.out.println("no error");
			JOptionPane.showMessageDialog(null, "payment successful..");						
			} 
		catch (Exception e1) {
			System.out.println("catch an exception");
		}
	}
}
