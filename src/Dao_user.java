
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_user {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    Statement stmt = null;
   
    // db ����
    public void connection() {
    	try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:Usertable.db");
			conn.setAutoCommit(false);//����
			System.out.println("�����׷��ϼ�");
		}catch(ClassNotFoundException e){
			
		}catch(SQLException e){
			
		}
		System.out.println("Records created successfully");
    }
   
    // db ����
    public void disconnection() {
    	try 
    	{
    		if(pstmt != null) pstmt.close();
                      
    		if(rs != null) rs.close();
                      
    		if(conn != null) conn.close();
             
    	} catch (SQLException e) {
    		
    	}
    }

    public void InsertStorage(String x,String y,String z,String o){
    	try{
    		
    		if(z.equals(""))
    		{
    			Dao dao = new Dao();
    			dao.connection();
    			z=String.valueOf(dao.searchItem(x));	
    		}
    		stmt = conn.createStatement();
			String sql = "INSERT INTO Usertable (name,num,expire,storage) VALUES('"+x+"','"+y+"','"+z+"','"+o+"');";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.commit();
			
    	}catch(Exception e){
    		System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
    	}
    }
 
    // ī�װ���  �˻�
    public ArrayList<Dto> searchStorage(String storage) {
             ArrayList<Dto> type_list = new ArrayList<Dto>();
             try {
            
            	 String query = "select name,num,expire from Usertable where storage = \'" + storage + "\'";
                 pstmt = conn.prepareStatement(query);
                 rs = pstmt.executeQuery();
                     
                 while(rs.next()){
                              Dto t_code = new Dto();
                              t_code.setName(rs.getString("name"));
                              t_code.setNum(rs.getInt("num"));
                              t_code.setExpire(rs.getInt("expire"));
                              type_list.add(t_code);
                              
                      }
             } catch (SQLException e) {
             }

             return type_list;
    }
   
    //�� �ƾ��� ����Ʈ ��̿� ��� �Լ�
    public ArrayList<Dto> searchStorage() {
        ArrayList<Dto> type_list = new ArrayList<Dto>();
        try {
       	 System.out.println("g");
       	 String query = "select name,num,expire from Usertable";
       	 System.out.println("h");
                 pstmt = conn.prepareStatement(query);
                 
                 rs = pstmt.executeQuery();
               
                 
                 while(rs.next()){
               	  
                      Dto t_code = new Dto();
                      t_code.setName(rs.getString("name"));
                      t_code.setNum(rs.getInt("num"));
                      t_code.setExpire(rs.getInt("expire"));
                      type_list.add(t_code);   
                 }
        } catch (SQLException e) {
        }

        return type_list;
}
    // ��ȿ�Ⱓ �ӹ��ϴ� ����Ʈ ��̿� �ֱ�
   public ArrayList<Dto> searchStorage(int expire) {
        ArrayList<Dto> type_list = new ArrayList<Dto>();
        try {
       	 
        	String query = "select name,num,expire from Usertable where expire <= \'" + expire + "\'";
       	
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
                 
            while(rs.next()){
               	  
                         Dto t_code = new Dto();
                         t_code.setName(rs.getString("name"));
                         t_code.setNum(rs.getInt("num"));
                         t_code.setExpire(rs.getInt("expire"));
                         type_list.add(t_code);
                         
                 }
        } catch (SQLException e) {
        }

        return type_list;
   	}
   
}
