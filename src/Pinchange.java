import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Pinchange extends FirstGui{

	private JFrame frame;
	private JPasswordField password2;

	public static String temp;
	public static int password;
	/**
	 * Launch the application.
	 */
	public void change1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp = FirstGui.total_pan;
					System.out.println(temp);
					Pinchange window = new Pinchange();
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
	public Pinchange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER THE NEW PIN");
		lblNewLabel.setForeground(UIManager.getColor("EditorPane.foreground"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(103, 11, 222, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setBackground(UIManager.getColor("ProgressBar.selectionBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondGUI sec = new SecondGUI();
				sec.Func2();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(319, 208, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NEXT");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBackground(UIManager.getColor("Table.dropLineShortColor"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//@SuppressWarnings("deprecation")
					password = Integer.parseInt(password2.getText());
					JOptionPane.showMessageDialog(null, password);
					//String passs = password2.getText().toString();
					//calling the new object class
					Pinchange2 next = new Pinchange2();
					next.change2();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBounds(319, 145, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		password2 = new JPasswordField();
		password2.setBackground(new Color(255, 255, 255));
		password2.setEchoChar('$');
		password2.setBounds(118, 60, 159, 28);
		frame.getContentPane().add(password2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anon\\Desktop\\deepen\\6th sem\\bb.webp"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
