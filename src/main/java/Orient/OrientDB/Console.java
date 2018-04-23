package Orient.OrientDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.orientechnologies.orient.jdbc.OrientJdbcConnection;


public class Console {
	public static String dbName;  
	public static String dbFullPath;
	public static String userName; 
	public static String password; 
	public static String query; 
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter Database name: ");  
		dbName = scanner.next();
		System.out.print("Enter User Name: ");  
		userName = scanner.next();
		System.out.print("Enter Password: ");  
		password = scanner.next();
		dbFullPath = "jdbc:orient:"+dbName;

		Scanner scanner1 = new Scanner (System.in);
		System.out.print("Enter Query: ");  
		query = scanner1.nextLine();
		
		Properties info = new Properties();
		info.put("user", userName);
		info.put("password", password);
		
		try {
			Connection conn = (OrientJdbcConnection) DriverManager.getConnection(dbFullPath, info);
			// "jdbc:orient:remote:localhost/BetterDemo"
			System.out.print("Connection established\n");
			Statement stmt = conn.createStatement();
			
			
			if (query.startsWith("INSERT") || query.startsWith("UPDATE") || query.startsWith("DELETE") || query.startsWith("CREATE") || query.startsWith("DROP") )
			{
				System.out.println("Changing database");
				System.out.println("Successful!");
				ResultSet rs = stmt.executeQuery(query);
				rs.close();				
				
			}
			else {
				
				ResultSet rs = stmt.executeQuery(query);
				//SELECT firsName, lastName FROM Person

				rs.next();
//				rs.getInt("@version");
//				rs.getString("@class");
//				rs.getString("@rid");
				String fname;
				String lname;
				fname = rs.getString("firsName");
				lname = rs.getString("lastName");
				System.out.println(fname);
				System.out.println(lname);
				
				
				rs.close();

				
				
			}

			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
