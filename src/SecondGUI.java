import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SecondGUI extends FirstGui{

	private JFrame frame;
	public static String temp;

	/**
	 * Launch the application.
	 */
	public void Func2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//System.out.println("sec string get"+str);
					temp = FirstGui.total_pan;
					//System.out.println("sec gui"+temp);
					SecondGUI window = new SecondGUI();
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
	public SecondGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.shadow"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton BALANCE = new JButton("BALANCE");
		BALANCE.setForeground(new Color(0, 128, 128));
		BALANCE.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		BALANCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JavaSpeak().Speak("YOU HAVE choosene the Balance option");
				Balance balance = new Balance();
				balance.balance1();
			}
		});
		BALANCE.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		BALANCE.setBounds(23, 28, 148, 23);
		frame.getContentPane().add(BALANCE);
		
		JButton FAST_CASH = new JButton("FAST CASH");
		FAST_CASH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fastcash1 f1 = new fastcash1();
				f1.cash1();
			}
		});
		FAST_CASH.setForeground(new Color(102, 0, 51));
		FAST_CASH.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		FAST_CASH.setBounds(242, 28, 148, 23);
		frame.getContentPane().add(FAST_CASH);
		
		JButton CASH_WITHDRAW = new JButton("CASH WITHDRAWL");
		CASH_WITHDRAW.setForeground(new Color(0, 128, 0));
		CASH_WITHDRAW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new JavaSpeak().Speak("YOU HAVE choose the cash withdrawl option");
				
				Withdrawl with = new Withdrawl();
				with.draw2();
			}
		});
		CASH_WITHDRAW.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		CASH_WITHDRAW.setBounds(23, 86, 148, 23);
		frame.getContentPane().add(CASH_WITHDRAW);
		
		JButton PIN_CHANGE = new JButton("PIN CHANGE");
		PIN_CHANGE.setForeground(new Color(255, 0, 0));
		PIN_CHANGE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calling the pinchange class here
				new JavaSpeak().Speak("YOU HAVE choose the pin change option");
				
				Pinchange pin = new Pinchange();
				pin.change1();
			}
		});
		PIN_CHANGE.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		PIN_CHANGE.setBounds(242, 86, 148, 23);
		frame.getContentPane().add(PIN_CHANGE);
		
		JButton BILL_PAYMENT = new JButton("BILL PAYMENTS");
		BILL_PAYMENT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Billpayment1 b1 = new Billpayment1();
				b1.pay1();
			}
		});
		BILL_PAYMENT.setForeground(new Color(255, 0, 255));
		BILL_PAYMENT.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		BILL_PAYMENT.setBounds(23, 152, 148, 23);
		frame.getContentPane().add(BILL_PAYMENT);
		
		JButton FUNDS_TRANSFER = new JButton("FUNDS TRANSFER");
		FUNDS_TRANSFER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funds1 f1 = new funds1();
				f1.transfer();
			}
		});
		FUNDS_TRANSFER.setForeground(new Color(0, 0, 0));
		FUNDS_TRANSFER.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		FUNDS_TRANSFER.setBounds(242, 152, 148, 23);
		frame.getContentPane().add(FUNDS_TRANSFER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anon\\Downloads\\pattern.png"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
	}

}
