import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fastcash2 {

	private JFrame frame;
	private JTextField textField;

	public static int temp;
	/**
	 * Launch the application.
	 */
	public void cash2(int str) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp =str;
					fastcash2 window = new fastcash2();
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
	public fastcash2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YOUR TRANSACTION IS SUCCESSFUL");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(72, 11, 276, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AVAILABLE BALANCE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 60, 129, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setBounds(215, 69, 86, 20);
		textField.setText(Integer.toString(temp));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton cancel = new JButton("EXIT");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final_gui f1= new final_gui();
				f1.final_fun();
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		cancel.setBounds(25, 188, 89, 23);
		frame.getContentPane().add(cancel);
		
		JButton btnNewButton = new JButton("SEE YOUR EXPENSES HERE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart_AWT p= new PieChart_AWT(null);
				p.main(null);
				
			}
		});
		btnNewButton.setBounds(271, 189, 163, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
