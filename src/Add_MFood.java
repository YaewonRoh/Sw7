import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_MFood extends JFrame{
	private JTextField Text_;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Add_MFood() {
		getContentPane().setLayout(null);
		
		JLabel Label_AddFood = new JLabel("�丮 �߰�");
		Label_AddFood.setBounds(51, 35, 57, 15);
		getContentPane().add(Label_AddFood);
		
		JLabel Label_MainMaterial = new JLabel("�����");
		Label_MainMaterial.setBounds(51, 63, 57, 15);
		getContentPane().add(Label_MainMaterial);
		
		JLabel Label_SubMaterial = new JLabel("�����");
		Label_SubMaterial.setBounds(51, 88, 57, 15);
		getContentPane().add(Label_SubMaterial);
		
		JLabel Label_Recipe = new JLabel("������");
		Label_Recipe.setBounds(51, 113, 57, 15);
		getContentPane().add(Label_Recipe);
		
		JLabel Label_Image = new JLabel("�̹���");
		Label_Image.setBounds(51, 138, 57, 15);
		getContentPane().add(Label_Image);
		
		Text_ = new JTextField();
		Text_.setBounds(120, 32, 116, 21);
		getContentPane().add(Text_);
		Text_.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 60, 116, 21);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 85, 116, 21);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(120, 110, 116, 21);
		getContentPane().add(textField_3);
		
		JButton Btn_Image = new JButton("�̹��� ����");
		Btn_Image.setBounds(120, 134, 116, 23);
		getContentPane().add(Btn_Image);
		
		JButton Btn_Finish = new JButton("�߰�");
		Btn_Finish.setBounds(71, 183, 57, 44);
		getContentPane().add(Btn_Finish);
		
		JButton Btn_Cancel = new JButton("���");
		Btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Btn_Cancel.setBounds(154, 183, 57, 44);
		getContentPane().add(Btn_Cancel);
	}
}