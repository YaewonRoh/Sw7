import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_MMaterial extends JFrame{
	private JTextField Txt_Name;
	private JTextField Txt_Life;
	
	public Add_MMaterial() {
		//setBounds(100,100,300,300);
		getContentPane().setLayout(null);
		
		JLabel Label_Name = new JLabel("재료 이름");
		Label_Name.setBounds(44, 71, 57, 15);
		getContentPane().add(Label_Name);
		
		JLabel Label_Life = new JLabel("유통기한");
		Label_Life.setBounds(44, 122, 57, 15);
		getContentPane().add(Label_Life);
		
		Txt_Name = new JTextField();
		Txt_Name.setBounds(113, 68, 116, 21);
		getContentPane().add(Txt_Name);
		Txt_Name.setColumns(10);
		
		Txt_Life = new JTextField();
		Txt_Life.setColumns(10);
		Txt_Life.setBounds(113, 119, 116, 21);
		getContentPane().add(Txt_Life);
		
		JButton Btn_Finish = new JButton("완료");
		Btn_Finish.setBounds(65, 173, 66, 48);
		getContentPane().add(Btn_Finish);
		
		JButton Btn_Cancel = new JButton("취소");
		Btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Btn_Cancel.setBounds(143, 173, 66, 48);
		getContentPane().add(Btn_Cancel);
	}
}