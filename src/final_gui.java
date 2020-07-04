import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class final_gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void final_fun() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final_gui window = new final_gui();
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
	public final_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THANKS FOR VISITING US");
		lblNewLabel.setBounds(99, 11, 212, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CONTINUE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondGUI s1 = new SecondGUI();
				s1.Func2();
			}
		});
		btnNewButton.setBounds(31, 142, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("END");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//disposing the frame
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(315, 142, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
