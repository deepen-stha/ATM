import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Robot;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class FirstGui {

	private JFrame frame;
	private JPasswordField pass1;
	private JLabel lblNewLabel;
	private JTextField PAN1;
	private JTextField PAN2;
	private JTextField PAN3;
	private JTextField PAN4;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JLabel label_1; 
	
	//VARIABLE FOR DATABASE
	Connection conn= null;
	
	//DECLARATION FOR PRACTICE
	//public int ;
	public static String total_pan;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstGui window = new FirstGui();
					window.frame.setVisible(true);
					//CALLING THE JAVA SPEAK CLASS TO MAKE MY COMPUTER SPEAK
					
					new JavaSpeak().Speak("Welcome to the atomatic trailer banking made by deepen shrestha");
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("CheckBox.shadow"));
		frame.setBounds(100, 100, 472, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Button1 = new JButton("LOGIN");
		Button1.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		Button1.addActionListener(new ActionListener() {
			
			//to supress all the warnings
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					//PAN --->PERMANETNT ACCOUNT NUMBER
					String pan1 = PAN1.getText();
					String pan2 = PAN2.getText();
					String pan3 = PAN3.getText();
					String pan4 = PAN4.getText();
					
					
					//if you didnot enter all the field
					if(pan1 =="" || pan2 =="" || pan3 =="" ||pan4 =="") {
						String msg = "please enter all the permanent account number";
						new JavaSpeak().Speak(msg);
					}
					
					String pin = pass1.getText().toString();
					
					//checking if pin is empty or not
					if(pin.equals("")){
						// TODO: handle exception
						 String msg1 ="PLEASE ENTER THE PIN";
						 
						 new JavaSpeak().Speak(msg1);
								
						 //Speak(msg1);	
						JOptionPane.showMessageDialog(null,msg1);
						}
					
					total_pan = pan1+" "+pan2+" "+pan3+" "+pan4;
					//System.out.println(total_pan);
					
					
					//connecting to the database
					Class.forName("org.sqlite.JDBC");
					Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
					Statement stmt = conn.createStatement();
					
					String query="Select * from ATM WHERE PAN =? "
							+ "AND PIN = ?";
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.setString(1,total_pan);
					 pst.setString(2,pin);
					 
					 ResultSet rs = pst.executeQuery();
					 conn.close();
					 //System.out.println(rs.getString(1)+" "+rs.getString(2));
					 frame.dispose();
					 Verificaion v1 = new Verificaion();
					 v1.verify();						
					
				}
				
				catch(Exception e1) {
					//if you donot enter the correct pan and pin
					String msg ="please enter the correct permanent account number and pin number";
					
					//calling the object java speak to speak
					new JavaSpeak().Speak(msg);
						
					//showing the message pane on the screen
					JOptionPane.showMessageDialog(null, msg);
					
				}		
			}							
		});
		Button1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Button1.setForeground(UIManager.getColor("CheckBox.foreground"));
		Button1.setBounds(167, 204, 89, 23);
		frame.getContentPane().add(Button1);
		
		JLabel label1 = new JLabel("PIN");
		label1.setForeground(new Color(250, 235, 215));
		label1.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 12));
		label1.setBounds(10, 153, 29, 23);
		frame.getContentPane().add(label1);
		
		pass1 = new JPasswordField();
		pass1.setToolTipText("YOUR ACCOUNT PIN");
		pass1.setFont(new Font("Tahoma", Font.BOLD, 13));
		pass1.setEchoChar('*');
		pass1.setBounds(45, 153, 248, 23);
		frame.getContentPane().add(pass1);
		
		lblNewLabel = new JLabel("WELCOME TO ATB");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(255, 255, 224));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(136, 39, 154, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PAN");
		lblNewLabel_1.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setForeground(new Color(250, 235, 215));
		lblNewLabel_1.setBounds(10, 85, 35, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		PAN1 = new JTextField();
		PAN1.setToolTipText("enter your PERMANENT ACCOUNT NO (PAN) IN THE COMING 4 FIELDS");
		PAN1.setBounds(45, 86, 53, 20);
		frame.getContentPane().add(PAN1);
		PAN1.setColumns(10);
		
		PAN2 = new JTextField();
		PAN2.setBounds(136, 86, 66, 20);
		frame.getContentPane().add(PAN2);
		PAN2.setColumns(10);
		
		PAN3 = new JTextField();
		PAN3.setBounds(250, 86, 72, 20);
		frame.getContentPane().add(PAN3);
		PAN3.setColumns(10);
		
		PAN4 = new JTextField();
		PAN4.setBounds(371, 86, 53, 20);
		frame.getContentPane().add(PAN4);
		PAN4.setColumns(10);
		
		lblNewLabel_2 = new JLabel("-----");
		lblNewLabel_2.setBounds(105, 89, 20, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		label = new JLabel("-----");
		label.setBounds(212, 89, 20, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("-----");
		label_1.setBounds(332, 89, 20, 14);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anon\\Downloads\\resize-15874513771534356261SpringTransactionManagement01.jpg"));
		lblNewLabel_3.setBounds(0, 0, 456, 261);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Anon\\Desktop\\deepen\\6th sem\\photo-1518531933037-91b2f5f229cc.webp"));
		lblNewLabel_4.setBounds(-1, 0, 457, 272);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
