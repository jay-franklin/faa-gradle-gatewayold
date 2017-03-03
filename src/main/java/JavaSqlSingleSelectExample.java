//STEP 1. Import required packages
import java.sql.*;

public class JavaSqlSingleSelectExample {
   // JDBC driver name and database URL
   //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://faa-uas-integration-db.c0n2kqivhowb.us-west-2.rds.amazonaws.com:3306/uasdb";
//DBUrl = "jdbc:oracle:thin:@nass-dev-idb1.cpriodarchzx.us-east-1.rds.amazonaws.com:1525:NASS";

   //  Database credentials
   static final String USER = "FaaUasTestRW";
   static final String PASS = "Welcome1!";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "select changed_by_username, party_enroll_status_cd, contact_info_id from party_enrollment where changed_by_username like 'My%Faadrone%@gmail.com' and party_enroll_type_cd = ('ORGANIZATION') and party_enroll_status_cd = 'ACTIVE' order by changed_on_dttm asc limit 3";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String username   = rs.getString("changed_by_username");
         String status     = rs.getString("party_enroll_status_cd");
         String contact_id = rs.getString("contact_info_id");
         // print the results
         System.out.format("%s, %s, %s\n", username, status, contact_id);
//        	System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
         
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample