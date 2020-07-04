import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Balance extends FirstGui{

	private JFrame frame;
	private JTextField txtYourCurrentBalance;
	
	public static String temp;
	public String amount;

	//Connection for databases
	Connection conn= null;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public void balance1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//System.out.println(" balance get "+str);
					temp = FirstGui.total_pan;
					//System.out.println("balance "+temp);
					Balance window = new Balance();
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
	public Balance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
			Statement stmt = conn.createStatement();

			String query = "select * from balance where PAN = ?";
			PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, temp);
            ResultSet rs = pst.executeQuery();
			
			//System.out.println(rs.getString(1)+" "+rs.getString(2));
            amount = rs.getString(1);
            System.out.println(amount);
		}
		
		catch(Exception e) {}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtYourCurrentBalance = new JTextField();
		txtYourCurrentBalance.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		txtYourCurrentBalance.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		
		//settig the text to the balance 
		txtYourCurrentBalance.setText("Your current balance is Rs "+amount);
		txtYourCurrentBalance.setBounds(77, 26, 288, 38);
		frame.getContentPane().add(txtYourCurrentBalance);
		txtYourCurrentBalance.setColumns(10);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(new Color(0, 139, 139));
		btnNewButton.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SecondGUI sec2 = new SecondGUI();
				sec2.Func2();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(307, 152, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anon\\Desktop\\deepen\\6th sem\\GettyImages-1054017850-0c7ca7d8368c4ab681a3d9c0fd2892e8.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
	}

}
