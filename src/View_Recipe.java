import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class View_Recipe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Recipe frame = new View_Recipe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View_Recipe(){}
	
	public View_Recipe(Object s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1272, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String text;
		text = s.toString();
		JComboBox comboBox = new JComboBox();
		
		Dao controller = new Dao();
		controller.connection();
		ArrayList<Dto> addressList = controller.search_List(text);
		Object[] arrAdd = new Object[addressList.size()];
		for(int i = 0 ; i < addressList.size() ; i++){
			Dto t_code = addressList.get(i);
            arrAdd[i] = t_code.getName();
            comboBox.addItem(arrAdd[i]);
		}
            
        comboBox.setBounds(14, 323, 386, 45);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 12, 386, 206);
		contentPane.add(panel);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(546, 12, 661, 541);
		contentPane.add(textPane_1);
		
		JButton btnNewButton_1 = new JButton("요리선택");
		btnNewButton_1.setBounds(416, 323, 105, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("요리완료");
		btnNewButton_2.setBounds(1072, 574, 135, 53);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("돌아가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_User user = new Main_User();
				user.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(858, 574, 153, 53);
		contentPane.add(btnNewButton);
	}
}

