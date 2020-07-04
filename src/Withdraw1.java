import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Withdraw1 extends FirstGui {

	private JFrame frame;
	private JTextField textField1;

	public static String temp;

	//defined for connecting to the database
	Connection conn= null;

	/**
	 * Launch the application.
	 */
	public void draw1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp = FirstGui.total_pan;
					System.out.println("draw1 "+temp);
					Withdraw1 window = new Withdraw1();
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
	public Withdraw1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER THE AMOUNT IN THE MULTIPLE OF X100 OR X1000.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(37, 11, 344, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textField1 = new JTextField();
		textField1.setBackground(new Color(240, 248, 255));
		textField1.setBounds(93, 51, 223, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		JButton btnNewButton = new JButton("WITH DRAW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");
					Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
					Statement stmt = conn.createStatement();

					//String query = "Select * from ATM WHERE PAN =? " + "OR application = ?";
					String query = "select * from balance where PAN = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					//serching for the particular account in database
		            pst.setString(1, temp);
		            ResultSet rs = pst.executeQuery();
					
					//System.out.println(rs.getString(1)+" "+rs.getString(2));
		            int balance1 = rs.getInt(1);
		            conn.close();

					int amount = Integer.parseInt(textField1.getText());
					//JOptionPane.showConfirmDialog(null, "are you sure?");
					
					if(amount>=balance1-500) {
						JOptionPane.showMessageDialog(null, "you donot have the sufficient balance");
					}
					else if(amount >=100 && amount<=40_000) {
							
						if(amount % 100 == 0 || amount% 1_000 ==0) {
							calculate(balance1-amount);
							JOptionPane.showMessageDialog(null, "you have withdrawn " + amount + " of money");
							final_gui with2 = new final_gui();
							with2.final_fun();;
						}
						else {
							JOptionPane.showMessageDialog(null, "Please enter the multiple of X100 or X1000.");
							
						}
					}
					else if(amount<100) {
						JOptionPane.showMessageDialog(null, "You cannot withdraw money less than 100.");
					}
					else {
						JOptionPane.showMessageDialog(null, "You cannot withdraw money more than 40,000 at a time.");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT TO BE WITHDRAWN");
				}
				
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnNewButton.setBounds(308, 103, 116, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setForeground(new Color(0, 100, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnNewButton_1.setBounds(308, 163, 116, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anon\\Downloads\\20160320020630023.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_1);
	}
	public void calculate(int amount) {
		try {
			int amount1 = amount;
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
			Statement stmt = conn.createStatement();
			
			String sql = "UPDATE balance SET amount= "+amount1+" WHERE PAN = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
            //pst.setInt(1,amount_remaining);
            pst.setString(1, temp);
            pst.executeUpdate();
			
			conn.close();
			System.out.println("no error");
			JOptionPane.showMessageDialog(null, "withdrawn successful..");			
			} 
		catch (Exception e1) {
			System.out.println(e1);
		}

	}

}
