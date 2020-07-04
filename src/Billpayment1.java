import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Billpayment1 extends SecondGUI {

	private JFrame frame;
	
	public static String temp;

	/**
	 * Launch the application.
	 */
	public void pay1(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp = SecondGUI.temp;
					Billpayment1 window = new Billpayment1();
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
	public Billpayment1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 485, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton electricity = new JButton("ELECTRICITY BILL");
		electricity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Billpayment2 b1  =new Billpayment2();
				b1.pay2();
			}
		});
		electricity.setBounds(152, 56, 147, 23);
		frame.getContentPane().add(electricity);
		
		JButton RENT = new JButton("HOUSE RENT");
		RENT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Billpayment2 b1  =new Billpayment2();
				b1.pay2();
			}
		});
		RENT.setBounds(152, 163, 147, 23);
		frame.getContentPane().add(RENT);
		
		JButton water_bill = new JButton("WATER BILL");
		water_bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Billpayment2 b1  =new Billpayment2();
				b1.pay2();
			}
		});
		water_bill.setBounds(155, 115, 147, 23);
		frame.getContentPane().add(water_bill);
		
		JLabel lblNewLabel = new JLabel("CHOOSE ONE OF THE OPTION TO PAY");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(63, 11, 284, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SecondGUI().Func2();
			}
		});
		btnNewButton.setBounds(183, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anon\\Downloads\\online-bill-payment-service-500x500.png"));
		lblNewLabel_1.setBounds(0, 0, 469, 289);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
