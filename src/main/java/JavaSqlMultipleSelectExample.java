//STEP 1. Import required packages
import java.sql.*;

public class JavaSqlMultipleSelectExample {
   // JDBC driver name and database URL
   //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	//Integration
    //static final String DB_URL = "jdbc:mysql://faa-uas-integration-db.c0n2kqivhowb.us-west-2.rds.amazonaws.com:3306/uasdb";
	//Test
    //static final String DB_URL = "jdbc:mysql://fr8afi7u05re73.cqppzhwxfkzh.us-west-2.rds.amazonaws.com:3306/uasdb";
    //Stage
    static final String DB_URL = "jdbc:mysql://fr1j89uhd9nva2v.ci4csxede9i5.us-west-2.rds.amazonaws.com:3306/uasdb";

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
      String sql2 = "select pea.username, pi.first_name, pi.middle_initial, pi.last_name, pi.name_suffix, pi.title, pi.changed_on_dttm, pe.changed_on_dttm from party_enrollment pe "
      		+ "join party_enrollment_account pea using (party_enroll_acct_id) "
      		+ "join person_info pi using (person_info_id) "
      		+ "where pe.party_enroll_status_cd = 'ACTIVE'  "
      		+ "and pe.changed_by_username like 'my%faadrone%' "
      		+ "and pe.party_enroll_type_cd in ('ORGANIZATION') "
      		+ "order by pi.changed_on_dttm asc limit 10";
      
      ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
          String username   = rs.getString("changed_by_username");
          String status     = rs.getString("party_enroll_status_cd");
          String contact_id = rs.getString("contact_info_id");
          System.out.format("%s, %s, %s\n", username, status, contact_id);
       }
      ResultSet rs2 = stmt.executeQuery(sql2);
     
      //STEP 5: Extract data from result set
  	  System.out.println("****************************************");

      while(rs2.next()){
         String username   	  	= rs2.getString("pea.username");
         String firstname     	= rs2.getString("pi.first_name");
         String middleInitial 	= rs2.getString("pi.middle_initial");
         String lastName 		= rs2.getString("pi.last_name");
         String suffix 			= rs2.getString("pi.name_suffix");
         String title 			= rs2.getString("pi.title");
         String person_dtg 		= rs2.getString("pi.changed_on_dttm");
         String enroll_dtg 		= rs2.getString("pe.changed_on_dttm");

         System.out.format("%s, %s,%s, %s, %s,%s, %s, %s\n", username, firstname, middleInitial,lastName,suffix,title, person_dtg, enroll_dtg );
//        	System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
         
      }
      rs.close();
      rs2.close();
      
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