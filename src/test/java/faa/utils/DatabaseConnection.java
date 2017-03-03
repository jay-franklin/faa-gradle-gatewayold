/**
 * 
 */
package faa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * @author jfranklin
 *
 */
public class DatabaseConnection 
{

	protected Connection conn;
	protected Statement statement;
	protected ResultSet resultSet;
	protected String databaseURL;
	protected String databaseUsername;
	protected String databasePassword;

//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
//    static final String DB_URL = "jdbc:mysql://faa-uas-integration-db.c0n2kqivhowb.us-west-2.rds.amazonaws.com:3306/uasdb";



	public DatabaseConnection(String environment)
	{

		if(environment.equalsIgnoreCase("integration")) {
			System.out.println("***This is the INTEGRATION Environment***");
			this.databaseURL = "jdbc:mysql://faa-uas-integration-db.c0n2kqivhowb.us-west-2.rds.amazonaws.com:3306/uasdb";
			this.databaseUsername = "FaaUasTestRW";
			this.databasePassword = "Welcome1!";
		} 
		if(environment.equalsIgnoreCase("test"))	{
			System.out.println("***This is the TEST Environment***");
			this.databaseURL = "jdbc:mysql://fr8afi7u05re73.cqppzhwxfkzh.us-west-2.rds.amazonaws.com:3306/uasdb";
			this.databaseUsername = "FaaUasTestRW";
			this.databasePassword = "Welcome1!";
		} 
		if(environment.equalsIgnoreCase("stage")) {
			System.out.println("***This is the STAGE Environment***");
			this.databaseURL = "jdbc:mysql://fr1j89uhd9nva2v.ci4csxede9i5.us-west-2.rds.amazonaws.com:3306/uasdb";
			this.databaseUsername = "FaaUasTestRW";
			this.databasePassword = "Welcome1!";
		}

		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
	      Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
			this.conn.setAutoCommit(false);
			this.statement = this.conn.createStatement();
		}
		catch (Exception e)
		{
			System.out.println("ERROR: connection to database not established!!");
			e.printStackTrace();
			System.err.println("Exception1: "+e.getMessage());
		}
		finally{


		}

	}

	public void closeConnection()
	{
		try{
			this.resultSet.close();
			this.statement.close();
			this.conn.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void executeStatement(String selectStatement)
	{
		try {
			this.resultSet = statement.executeQuery(selectStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getNextRowArray()
	{
		try {
			if(resultSet.next())
			{
				ArrayList<String> returnArray = new ArrayList<String>(); 
				ResultSetMetaData rsmd = this.resultSet.getMetaData();
				int numCols = rsmd.getColumnCount();

				for(int i = 1 ;i <= numCols;i++)
				{
					returnArray.add(this.resultSet.getNString(i));
				}

				return returnArray;
			}
			else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
