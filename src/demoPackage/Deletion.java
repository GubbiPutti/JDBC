package demoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Deletion 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Program execution is started!");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc6315", "root", "1234");
		System.out.println("Connected to Mysql server.");
		System.out.println("-----------------------------------");
		System.out.println("Enter Student id to delete record from table.");
		int id =sc.nextInt();
		
		String query = "delete from Student where id = ('"+id+"')";
		PreparedStatement ps = connection.prepareStatement(query);
		
		
      	int update= ps.executeUpdate();
      	if(update == 1)
      		System.out.println("Query is Executed.");
      	else 
      		System.out.println("Query is not Executed.");
	}
}
