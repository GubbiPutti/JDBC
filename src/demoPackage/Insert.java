package demoPackage;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
////insert data from java app to DBMS
//public class Insert {
//
//	public static void main(String[] args) throws Exception 
//	{
//		int id;
//		String name;
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter student id.");
//		id = sc.nextInt();
//		
//		System.out.println("Enter Student Name.");
//		sc.next();
//		name = sc.nextLine();
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc6315", "root", "1234");
//		
//		System.out.println("Driver connection built.");
//		
////		String query = "insert into Student values('"+id+"','"+name+"')";
//		String query = "insert into Student values(?,?)";
//		PreparedStatement ps = con.prepareStatement(query);
//		//Setters
//		ps.setInt(1,id);
//		ps.setString(2,name);
//		
//		System.out.println("Statement is created.");
//		
//		int i = ps.executeUpdate(); //return int-> 0 = false , 1 =true
//		
//		if(i==0)
//			System.out.println("Query is not executed!");
//		else
//			System.out.println("Query is executed sucessfully!");
//		
//	}
//
//}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) throws Exception {
        int id;
        String name;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id.");
        id = sc.nextInt();

        // Consume the newline character left in the buffer
        sc.nextLine();

        System.out.println("Enter Student Name.");
        name = sc.nextLine();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc6315", "root", "1234");

        System.out.println("Driver connection built.");

        String query = "insert into Student values(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        // Setters
        ps.setInt(1, id);
        ps.setString(2, name);

        System.out.println("Statement is created.");

        //executeUpdate methhod returns 1 if query is executed or else it will return 0.
        int i = ps.executeUpdate();

        if (i == 0)
            System.out.println("Query is not executed!");
        else
            System.out.println("Query is executed successfully!");

        // Close the connection and scanner
        ps.close();
        con.close();
        sc.close();
    }
}

