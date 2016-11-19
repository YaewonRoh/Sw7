import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main_Login extends JFrame {

	public Main_Login() {

		getContentPane().setLayout(null);

		JButton Btn_Manager = new JButton("관리");
		Btn_Manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Manager MM = new Main_Manager();
				MM.setBounds(100, 100, 1284, 744);
				MM.setVisible(true);
				setVisible(false);
			}
		});
		Btn_Manager.setBounds(454, 385, 120, 40);
		getContentPane().add(Btn_Manager);

		JButton Btn_User = new JButton("내 냉장고 보기");
		Btn_User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_User MU = new Main_User();
				MU.setBounds(100, 100, 1284, 744);
				MU.setVisible(true);
				setVisible(false);
			}
		});
		Btn_User.setBounds(454, 280, 120, 40);
		getContentPane().add(Btn_User);
		
		JButton button = new JButton("나가기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setBounds(454, 481, 120, 40);
		getContentPane().add(button);
		
		JLabel label = new JLabel("\uB0C9\uC7A5\uACE0\uB97C \uBD80\uD0C1\uD574");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.PLAIN, 40));
		label.setBounds(327, 118, 352, 61);
		getContentPane().add(label);
	}
}