package demoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner (System.in);
			
		System.out.println("Program Execution Started");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc6315", "root", "1234");
		System.out.println("Driver connection is built.");
		System.out.println("---------------------------------------");
		
		System.out.println("Enter Student id to update");
		int id = sc.nextInt();
		System.out.println("Enter Student Name");
		sc.nextLine();
		String name = sc.nextLine();
		
		String query = "update student set name = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,name);
		preparedStatement.setInt(2,id);
		
	   int i = preparedStatement.executeUpdate();
	   if(i==1)
		   System.out.println("Query Executed!");
	   else
		   System.out.println("Query is not executed");
		
		
		System.out.println("Program Executed!");
	}
}
