import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Manager extends JFrame{
	public Main_Manager(){
		getContentPane().setLayout(null);
		//��� ��� ��ư*********************************************
		JButton Btn_AddMaterial = new JButton("��� ���");
		Btn_AddMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_MMaterial AM = new Add_MMaterial();
				AM.setBounds(100,100,300,300);
				AM.setVisible(true);
			}
		});
		Btn_AddMaterial.setBounds(289, 134, 100, 100);
		getContentPane().add(Btn_AddMaterial);
		//��� ��� ��ư ��********************************************
		//��� ��� ���� ��ư******************************************
		JButton Btn_DelMaterial = new JButton("��� ��� ����");
		Btn_DelMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Del_MMaterial DM = new Del_MMaterial();
				DM.setBounds(100,100,300,300);
				DM.setVisible(true);
			}
		});
		Btn_DelMaterial.setBounds(289, 299, 100, 100);
		getContentPane().add(Btn_DelMaterial);
		//��� ��� ���� ��ư ��*****************************************
		//���� ��� ��ư*********************************************
		JButton Btn_AddFood = new JButton("�丮 ���");
		Btn_AddFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_MFood AM = new Add_MFood();
				AM.setBounds(100,100,300,300);
				AM.setVisible(true);
			}
		});
		Btn_AddFood.setBounds(477, 134, 100, 100);
		getContentPane().add(Btn_AddFood);
		
		JButton Btn_DellFood = new JButton("��� �丮 ����");
		Btn_DellFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Del_MFood DM = new Del_MFood();
				DM.setBounds(100,100,300,300);
				DM.setVisible(true);
			}
		});
		Btn_DellFood.setBounds(477, 299, 100, 100);
		getContentPane().add(Btn_DellFood);
		
		JButton Btn_Back = new JButton("���ư���");
		Btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Login ML = new Main_Login();
				ML.setBounds(100,100,800,500);
				ML.setVisible(true);
				setVisible(false);
			}
		});
		Btn_Back.setBounds(675, 428, 97, 23);
		getContentPane().add(Btn_Back);
		
	}
}