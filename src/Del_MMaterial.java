import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Del_MMaterial extends JFrame {
	private JTextField Txt_Name;
	Pop A = new Pop();
	
	public Del_MMaterial() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("식료품 삭제");
		lblNewLabel.setBounds(14, 12, 84, 18);
		getContentPane().add(lblNewLabel);

		JLabel Label_Name = new JLabel("재료 이름");
		Label_Name.setBounds(25, 89, 66, 18);
		getContentPane().add(Label_Name);

		Txt_Name = new JTextField();
		Txt_Name.setBounds(97, 87, 133, 24);
		getContentPane().add(Txt_Name);
		Txt_Name.setColumns(10);

		JButton Btn_Cancel = new JButton("취소");
		Btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Btn_Cancel.setBounds(150, 147, 66, 48);
		getContentPane().add(Btn_Cancel);

		JButton Btn_Finish = new JButton("완료");
		Btn_Finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DB_DelMM Query = new DB_DelMM(Txt_Name);
				A.Message("삭제 되었습니다.");
			}
		});
		Btn_Finish.setBounds(62, 147, 66, 48);
		getContentPane().add(Btn_Finish);
	}

}

class DB_DelMM {
	public DB_DelMM(JTextField text_A) {
		Connection c = null;
		Statement stmt = null;
		
		try {
			String x = text_A.getText();
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "DELETE FROM Manager WHERE Name='"+x+"';";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e1) {
			System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
			System.exit(0);
		}
	}
}