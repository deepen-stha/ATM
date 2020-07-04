import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Verificaion extends FirstGui {

	private JFrame frame;
	private JTextField txtPleaseCooperateIts;
	private JTextField txtChooseTheCorrect;
	String verif,rand1,rand2;
	public int temp;
	public static String temp1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public void verify() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//temp1 = str;
					
					System.out.println("verification "+temp1);
					Verificaion window = new Verificaion();
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
	public Verificaion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		//System.out.println(verif1);
		temp1 = FirstGui.total_pan;
		System.out.println(temp1);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtPleaseCooperateIts = new JTextField();
		txtPleaseCooperateIts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtPleaseCooperateIts.setText("PLEASE CO-OPERATE ITS TWO WAY VERIFICATION");
		txtPleaseCooperateIts.setEnabled(false);
		txtPleaseCooperateIts.setEditable(false);
		txtPleaseCooperateIts.setBounds(55, 11, 327, 29);
		frame.getContentPane().add(txtPleaseCooperateIts);
		txtPleaseCooperateIts.setColumns(10);
		
		JButton verification1 = new JButton("");
		verification1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the clicked pin is correct
				if(temp==0) {
					new JavaSpeak().Speak("login successful");
				
					SecondGUI sec = new SecondGUI();
					sec.Func2();
				}
				else {
					JavaSMS sms1 = new JavaSMS();
					try {
						new JavaSpeak().Speak("someone is interfering your account.");
					
						sms1.SMS("someone is interfering your account.");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//destroying the frame
					frame.dispose();
				}
			}
		});
		
		verification1.setBounds(31, 128, 89, 23);
		
		//getting the random no and setting it to button
		verif = getRandom();
		verification1.setText(verif);
		
		
		frame.getContentPane().add(verification1);
		
		JButton verification2 = new JButton("");
		
		
		verification2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temp==1) {
					new JavaSpeak().Speak("login successful");
				
					SecondGUI sec = new SecondGUI();
					sec.Func2();
				}
				else {
					JavaSMS sms1 = new JavaSMS();
					try {
						new JavaSpeak().Speak("someone is interfering your account.");
					
						sms1.SMS("someone is interfering your account.");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//destroying the frame
					frame.dispose();
				}
			}
		});
		

		verification2.setBounds(161, 128, 89, 23);
		
		//getting the random no and setting it to button
		rand1 = getRandom();
		verification2.setText(rand1);
				
		frame.getContentPane().add(verification2);
		
		JButton verification3 = new JButton("");
		
		verification3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temp==2) {
					new JavaSpeak().Speak("login successful");
				
					SecondGUI sec = new SecondGUI();
					sec.Func2();
				}
				else {
					JavaSMS sms1 = new JavaSMS();
					try {
						new JavaSpeak().Speak("someone is interfering your account.");
						
						sms1.SMS("someone is interfering your account.");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//destroying the frame
					frame.dispose();
				}
			}
		});
		

		verification3.setBounds(305, 128, 89, 23);
		
		
		//getting the random no and setting it to button
		rand2 = getRandom();
		verification3.setText(rand2);
				
		frame.getContentPane().add(verification3);
		
		txtChooseTheCorrect = new JTextField();
		txtChooseTheCorrect.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtChooseTheCorrect.setText("CHOOSE THE CORRECT VERIFICATION ID");
		txtChooseTheCorrect.setEditable(false);
		txtChooseTheCorrect.setEnabled(false);
		txtChooseTheCorrect.setBounds(77, 39, 287, 23);
		frame.getContentPane().add(txtChooseTheCorrect);
		txtChooseTheCorrect.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anon\\Desktop\\deepen\\6th sem\\universities-verify-bank-statement-balance.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
		
		//choosing the random verificaiton id among the three
		Random rand = new Random(); 
		temp = rand.nextInt(3);
		System.out.println("temp variable is "+temp);
		
		//applying switch case to know which is going to ececute
		JavaSpeak speak1 = new JavaSpeak();
		switch(temp) {
		
		case 0: 
			//creating an object of javasms
			JavaSMS j1 = new JavaSMS();
			try {
				
				speak1.Speak("The verification id is send to your mobile number.");
				System.out.println("verification number is:"+verif);
			
				j1.SMS(verif);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			JavaSMS j2 = new JavaSMS();
			try {
				speak1.Speak("the verification no is sent successfully");
				System.out.println("verification number is:"+verif);
				
				j2.SMS(rand1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			JavaSMS j3 = new JavaSMS();
			try {
				speak1.Speak("the verification no is send successfully");
				System.out.println("verification number is:"+verif);
				
				j3.SMS(verif);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
			
	}
	
	
	//function to generate the random verificaiton id
	private static String getRandom() {
		
		Random rand = new Random(); 
		String str = "";
		  
        // Generate random integers in range 0 to 9999
		for(int i=0;i<4;i++) {
			int rand_int = rand.nextInt(9);
			str= str+rand_int;
		}
		return str;
		
	}
}
