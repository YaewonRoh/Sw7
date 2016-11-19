import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    Statement stmt = null;
   
    // db 연결
    public void connection() {
    	try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:Material.db");
			conn.setAutoCommit(false);//뭐지
			System.out.println("ghghghghghghghghghgh");
		}catch(ClassNotFoundException e){
			
		}catch(SQLException e){
			
		}
		System.out.println("dao연결");
    }
   
    // db 해제
    public void disconnection() {
    	try 
    	{
    		if(pstmt != null) pstmt.close();
                      
    		if(rs != null) rs.close();
                      
    		if(conn != null) conn.close();
             
    	} catch (SQLException e) {
    		
    	}
    }
    
    public Integer searchItem(String name) {
        //ArrayList<Dto> type_list = new ArrayList<Dto>();
        int expire = 0;
        try {
       	 
        	String query = "select expire from Material where name = \'" + name+ "\'";
        	System.out.println("서치서치");
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
                 
           expire = rs.getInt("expire");
           System.out.println(expire);
           
        } catch (SQLException e) {
        }
        
        System.out.println("유통기한 : " +expire);
        return expire;
   }
    public ArrayList<Dto> search_List(String item) {
        ArrayList<Dto> type_list = new ArrayList<Dto>();
        System.out.println("ok");
        try {
       	 	  String query = "select rname from Recipe where item like  '%" + item+ "%'";
       	 	  System.out.println("ok1");
                 pstmt = conn.prepareStatement(query);
                 System.out.println("ok2");
                 rs = pstmt.executeQuery();
                 System.out.println("ok3");
                 while(rs.next()){
                         Dto t_code = new Dto();
                         t_code.setName(rs.getString("rname"));
                         System.out.println(rs.getString("rname"));
                         type_list.add(t_code);
                 }
        } catch (SQLException e) {
        	System.out.println("이색기");
        }

        return type_list;
}         
    // 저장소  검색
    public ArrayList<Dto> searchType(String type) {
             ArrayList<Dto> type_list = new ArrayList<Dto>();
             try {
            	 	  String query = "select name,num,expire from Material";
                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();
                      while(rs.next()){
                              Dto t_code = new Dto();
                              t_code.setType(rs.getString("type"));
                              type_list.add(t_code);
                      }
             } catch (SQLException e) {
             }

             return type_list;
    } 
  
    public ArrayList<Dto> searchName() {
        ArrayList<Dto> type_list = new ArrayList<Dto>();
        try {
       	 	  String query = "select name from Material";
                 pstmt = conn.prepareStatement(query);
                 rs = pstmt.executeQuery();
                 while(rs.next()){
                         Dto t_code = new Dto();
                         t_code.setName(rs.getString("name"));
                         
                         type_list.add(t_code);
                 }
        } catch (SQLException e) {
        }

        return type_list;
}         
}
