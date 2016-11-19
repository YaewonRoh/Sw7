import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Del_MFood extends JFrame{
	private JTextField Txt_Name;
	public Del_MFood() {
		getContentPane().setLayout(null);
		
		JLabel Label_Name = new JLabel("음식 이름");
		Label_Name.setBounds(46, 99, 57, 15);
		getContentPane().add(Label_Name);
		
		Txt_Name = new JTextField();
		Txt_Name.setBounds(115, 96, 116, 21);
		getContentPane().add(Txt_Name);
		Txt_Name.setColumns(10);
		
		JButton Btn_Finish = new JButton("완료");
		Btn_Finish.setBounds(62, 145, 65, 59);
		getContentPane().add(Btn_Finish);
		
		JButton Btn_Cancel = new JButton("취소");
		Btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Btn_Cancel.setBounds(139, 145, 65, 59);
		getContentPane().add(Btn_Cancel);
	}

}
