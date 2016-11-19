import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Add_UMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JLabel lblNewLabel_3;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JComboBox<Object> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_UMaterial frame = new Add_UMaterial();
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
	public Add_UMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1284, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("재료추가");
		label.setBounds(107, 96, 72, 39);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(27, 177, 107, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("갯수");
		lblNewLabel_1.setBounds(27, 269, 107, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("유효기간");
		lblNewLabel_2.setBounds(27, 333, 107, 51);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 269, 116, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 346, 116, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("저장소 위치");
		lblNewLabel_3.setBounds(27, 462, 86, 44);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("냉동");
		rdbtnNewRadioButton.setBounds(140, 462, 139, 27);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("냉장");
		rdbtnNewRadioButton_1.setBounds(140, 514, 139, 27);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("상온");
		rdbtnNewRadioButton_2.setBounds(140, 571, 139, 27);
		contentPane.add(rdbtnNewRadioButton_2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.setBounds(345, 345, 116, 73);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("완료");
		btnNewButton_1.setBounds(345, 471, 116, 73);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(501, 72, 334, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(505, 269, 330, 153);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(507, 467, 328, 158);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		comboBox = new JComboBox();
		
		searchT_list();
		
		comboBox.setBounds(148, 177, 116, 48);
		contentPane.add(comboBox);
		
	}
	
	public void searchT_list(){
	    
		Dao controller = new Dao();
		controller.connection();
		
        
		ArrayList<Dto> addressList = controller.searchName();
        if(addressList.isEmpty())
        	 System.out.println("비워져잇어");
        
        Object[] arrAdd = new Object[addressList.size()];
        for(int i = 0 ; i < addressList.size() ; i++){
        		Dto t_code = addressList.get(i);
                arrAdd[i] = t_code.getName();
                //m_table.setModel(new Table_model(arrAdd));
                comboBox.addItem(arrAdd[i]);
        } 
		
		
}
}
