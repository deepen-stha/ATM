import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class fastcash1 extends FirstGui{

	private JFrame frame;
	
	public static String temp;
	public static int amount;

	/**
	 * Launch the application.
	 */
	public void cash1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp = FirstGui.total_pan;
					System.out.println(temp);
					fastcash1 window = new fastcash1();
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
	public fastcash1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//try catch block to read database
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
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
		catch(Exception e) {}
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLEASE SELECT AMOUNT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(116, 11, 189, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("RS 100/-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//minimum balance should be 500
				if((amount-500)>=100) {
					new JavaSpeak().Speak("cash successfully withdrawn");
					calculate(amount-100);
					fastcash2 f1 =new fastcash2();
					f1.cash2((amount-100));
				}
				else {
					JOptionPane.showMessageDialog(null, "amount is not sufficient");
					new JavaSpeak().Speak("amount is not sufficient");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(10, 59, 102, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RS 2000/-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//minimum balance should be 500
				if((amount-500)>=2000) {
					new JavaSpeak().Speak("cash successfully withdrawn");
					calculate(amount-2000);
					fastcash2 f1 =new fastcash2();
					f1.cash2((amount-2000));
					
				}
				else {
					JOptionPane.showMessageDialog(null, "amount is not sufficient");
					new JavaSpeak().Speak("amount is not sufficient");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBounds(307, 59, 117, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RS 200/-");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//minimum balance should be 500
				if((amount-500)>=200) {
					new JavaSpeak().Speak("cash successfully withdrawn");
					calculate(amount-200);
					fastcash2 f1 =new fastcash2();
					f1.cash2((amount-200));
				}
				else {
					JOptionPane.showMessageDialog(null, "amount is not sufficient");
					new JavaSpeak().Speak("amount is not sufficient");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_2.setBounds(10, 93, 102, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("RS 3000/-");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//minimum balance should be 500
				if((amount-500)>=3_000) {
					new JavaSpeak().Speak("cash successfully withdrawn");
					calculate(amount-3000);
					fastcash2 f1 =new fastcash2();
					f1.cash2((amount-3000));
					
				}
				else {
					JOptionPane.showMessageDialog(null, "amount is not sufficient");
					new JavaSpeak().Speak("amount is not sufficient");
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_3.setBounds(307, 93, 117, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("RS 500/-");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//minimum balance should be 500
				if((amount-500)>=500) {
					new JavaSpeak().Speak("cash successfully withdrawn");
					calculate(amount-500);
					fastcash2 f1 =new fastcash2();
					f1.cash2((amount-500));
				}
				else {
					JOptionPane.showMessageDialog(null, "amount is not sufficient");
					new JavaSpeak().Speak("amount is not sufficient");
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_4.setBounds(10, 131, 102, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("RS 1000/-");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//minimum balance should be 500
				if((amount-500)>=1000) {
					new JavaSpeak().Speak("cash successfully withdrawn");
					fastcash2 f1 =new fastcash2();
					f1.cash2((amount-1000));
				}
				else {
					JOptionPane.showMessageDialog(null, "amount is not sufficient");
					new JavaSpeak().Speak("amount is not sufficient");
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_5.setBounds(10, 171, 102, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("RS 5000/-");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//minimum balance should be 500
				if((amount-500)>=5_000) {
					new JavaSpeak().Speak("cash successfully withdrawn");
					calculate(amount-5000);
					fastcash2 f1 =new fastcash2();
					f1.cash2((amount-5000));
				}
				else {
					JOptionPane.showMessageDialog(null, "amount is not sufficient");
					new JavaSpeak().Speak("amount is not sufficient");
				}
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_6.setBounds(307, 131, 117, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("RS 10000/-");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//minimum balance should be 500
				if((amount-500)>=10_000) {
					new JavaSpeak().Speak("cash successfully withdrawn");
					calculate(amount-10000);
					fastcash2 f1 =new fastcash2();
					f1.cash2((amount-10000));
					
				}
				else {
					JOptionPane.showMessageDialog(null, "amount is not sufficient");
					new JavaSpeak().Speak("amount is not sufficient");
				}
			}
		});
		btnNewButton_7.setBounds(307, 171, 117, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("BACK");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SecondGUI().Func2();
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_8.setBounds(176, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_8);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anon\\Downloads\\fast-cash-transfer-500x500.jpg"));
		lblNewLabel_1.setBounds(-58, 0, 492, 261);
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
			JOptionPane.showMessageDialog(null, "payment successful..");			
			} 
		catch (Exception e1) {
			System.out.println(e1);
		}


		
	}

}
