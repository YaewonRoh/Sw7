import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

//import Dao_user;
//import Dto;
//import Table_model;

import java.awt.Font;
import javax.swing.JTable;

public class Main_User extends JFrame {
	private JTable m_table;// 유저 보유 재료 리스트
	private JTable expire_table; // 보유재료 중 유효기간 임박 리스트
	String select_item;
	int row;
	int cou;
	Object ss;
	public Main_User() {
		

		PreparedStatement pstmt;
		ResultSet rset;
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
			Statement stmt = null;
		
			setBounds(100, 100, 1284, 744);

			// 추가버튼********************************************************************
			JButton Btn_Add = new JButton("추가");
			Btn_Add.setBounds(407, 68, 155, 60);
			Btn_Add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Add_UMaterial fa = new Add_UMaterial();
					fa.setBounds(100, 100, 365, 320);
					fa.setVisible(true);
				}
			});
			getContentPane().setLayout(null);
			getContentPane().add(Btn_Add);
			// 추가버튼
			// 끝*****************************************************************
			// 삭제버튼*******************************************************************
			JButton Btn_Del = new JButton("삭제");
			Btn_Del.setBounds(407, 157, 155, 60);
			Btn_Del.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Del_UMaterial fd = new Del_UMaterial();
					fd.setBounds(100, 100, 305, 215);
					fd.setVisible(true);
				}
			});
			getContentPane().add(Btn_Del);
			// 삭제버튼
			// 끝****************************************************************
			// 요리보기 버튼*********************************************************
			JButton Btn_view = new JButton("메뉴보기");
			Btn_view.setBounds(407, 233, 155, 60);
			Btn_view.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					View_Recipe view = new View_Recipe(ss);
					view.setBounds(100,100,800,500);
					view.setVisible(true);
					setVisible(false);
				}
			});
			getContentPane().add(Btn_view);
			// 요리보기 버튼 끝*********************************************************
			// 뒤로가기 버튼***********************************************************
			JButton Btn_Back = new JButton("뒤로가기");
			Btn_Back.setBounds(1150, 636, 90, 30);
			Btn_Back.setFont(new Font("굴림", Font.PLAIN, 12));
			Btn_Back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Main_Login ML = new Main_Login();
					ML.setBounds(500, 100, 800, 500);
					ML.setVisible(true);
					setVisible(false);
				}
			});
			getContentPane().add(Btn_Back);
			
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(25, 34, 303, 632);
			getContentPane().add(scrollPane);
			
			m_table = new JTable();
			
			m_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			m_table.setModel(new DefaultTableModel(
	                new Object[][] {
	                       {" ", " ", " "},
	                },
	                new String[] {
	                       "이름", "개수", "유효기간"
	                }
	        ) {
	                boolean[] columnEditables = new boolean[] {
	                       false, false, false
	                };
	                public boolean isCellEditable(int row, int column) {
	                       return columnEditables[column];
	                }
	        });
			
			searchT_list();// db불러오고 총 리스트에 넣는 함수
			
			scrollPane.setViewportView(m_table);
			
			
			m_table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					row=m_table.getSelectedRow();
					cou=m_table.getSelectedColumn();
					ss =m_table.getValueAt(row, cou);
					//System.out.print(ss);
					
				}
			});
			
			System.out.print(select_item);
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(611, 68, 607, 225);
			getContentPane().add(scrollPane_1);
			
			expire_table = new JTable();
			scrollPane_1.setViewportView(expire_table);
			
			expire_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			expire_table.setModel(new DefaultTableModel(
	                new Object[][] {
	                       {" ", " ", " "},
	                },
	                new String[] {
	                       "이름", "개수", "유효기간"
	                }
	        ) {
	                boolean[] columnEditables = new boolean[] {
	                       false, false, false
	                };
	                public boolean isCellEditable(int row, int column) {
	                       return columnEditables[column];
	                }
	        });
			
			searchT_list(5);//db불러오고 총 리스트에 넣는 함수
			
			scrollPane.setViewportView(m_table);
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
public void searchT_list(){
	    
        Dao_user controller = new Dao_user();
        
        controller.connection();   
        
        ArrayList<Dto> addressList = controller.searchStorage();
        if(addressList.isEmpty())
        	 System.out.println("null");
        Object[][] arrAdd = new Object[addressList.size()][3];
        for(int i = 0 ; i < addressList.size() ; i++){
        		Dto t_code = addressList.get(i);
                arrAdd[i][0] = t_code.getName();
                arrAdd[i][1] = t_code.getNum();
                arrAdd[i][2] = t_code.getExpire();
                m_table.setModel(new Table_model(arrAdd));        
        }             
        controller.disconnection();
}

public void selectT_list(){
	Dao_user controller = new Dao_user();
	controller.connection();
	
	 ArrayList<Dto> addressList = controller.searchStorage();
     if(addressList.isEmpty())
     	 System.out.println("null");
     Object[][] arrAdd = new Object[addressList.size()][3];
     for(int i = 0 ; i < addressList.size() ; i++){
 		Dto t_code = addressList.get(i);
         arrAdd[i][0] = t_code.getName();
         arrAdd[i][1] = t_code.getNum();
         arrAdd[i][2] = t_code.getExpire();
         m_table.setModel(new Table_model(arrAdd));        
 }             
     controller.disconnection();
}

//저장소별 리스트 
public void searchT_list(String storage){
	    
        Dao_user controller = new Dao_user();
        
        controller.connection();   
        
        ArrayList<Dto> addressList = controller.searchStorage(storage);
        if(addressList.isEmpty())
        	 System.out.println("null");
        Object[][] arrAdd = new Object[addressList.size()][3];
     
        for(int i = 0 ; i < addressList.size() ; i++){
        	 Dto t_code = addressList.get(i);
             arrAdd[i][0] = t_code.getName();
             arrAdd[i][1] = t_code.getNum();
             arrAdd[i][2] = t_code.getExpire();
               
             m_table.setModel(new Table_model(arrAdd));        
        }             
        controller.disconnection();
    }
	
	public void searchT_list(int expire){
	    
        Dao_user controller = new Dao_user();
        controller.connection();   
        ArrayList<Dto> addressList = controller.searchStorage(expire);

        if(addressList.isEmpty())
        	 System.out.println("null");
        
        Object[][] arrAdd = new Object[addressList.size()][3];
        for(int i = 0 ; i < addressList.size() ; i++){
        		Dto t_code = addressList.get(i);
                arrAdd[i][0] = t_code.getName();
                arrAdd[i][1] = t_code.getNum();
                arrAdd[i][2] = t_code.getExpire();
                expire_table.setModel(new Table_model(arrAdd));        
        }             
        controller.disconnection();
    }
		
}


