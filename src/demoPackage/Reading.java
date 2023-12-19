package demoPackage;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//Reading data from database
public class Reading 
{
	int id;
	String name;
	static Connection connection;
	
	public void createTable(String tableName) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = "create table "+tableName+"(id int,"+"name varchar(30))";
		 int status = st.executeUpdate(sql);
		 // executeUpdate() -> return the number(int) of rows are in effect.
		if(status==0)
		 System.out.println("Table is created in the database jdbc6315");
		else 
		  System.out.println("Table is not created.");
	}
	
	public void readData() throws SQLException
	{
		Statement st = connection.createStatement();
		String sql ="Select * from Student";
		ResultSet rs = st.executeQuery(sql); //returns result in set
		while(rs.next())	//id , name 
			{
			   //getters
				id   = rs.getInt(1);//to get integer value
				name = rs.getString(2);//to get String values
				
				System.out.println("Student id is "+id+"\nStudent name is "+name);
			}		
	}
	
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		Reading reading = new Reading();
		
		System.out.println("*****Execution started*****");
		//Driver connection
		Class.forName("com.mysql.cj.jdbc.Driver"); //Driver is a class
		//System.out.println("Driver class loaded");
		String url = "jdbc:mysql://localhost:3306/jdbc6315";
		String username = "root";
	    String password ="1234";
	    connection = DriverManager.getConnection(url, username,password );
		//System.out.println("Database connection built.");
				
		System.out.println("--------------------------------");
		System.out.println("Select your choice.");
		System.out.println("1.Create table\n2.ReadData");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:System.out.println("Enter your table name");
				sc.nextLine();
		       String name = sc.nextLine();
		       reading.createTable(name);
		       break;
		case 2:System.out.println("Selected Data");
	         	reading.readData();
	         	System.out.println("Successfully fetched all data from table. ");
	          break;
		       
		default:
			System.out.println("Thank you :)");
		}
		
		
	}

}


