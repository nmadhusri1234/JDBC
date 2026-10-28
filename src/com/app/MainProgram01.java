package com.app;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.out;

public class MainProgram01 {

public static void main(String[] args) {
	
	var scanner = new Scanner(System.in);
	
	out.print("Enter username :");
	String username = scanner.nextLine(); //next method moves the cursor to the next row
	out.println("Enter password :");
	String password = scanner.next();
	
		
		try(var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","MadhuRaj@143");
				var statement = connection.createStatement()) {
			
		//var sqlQuery = "Select * from credentials where username='%s' and password='%s'";
		//sqlQuery = sqlQuery.format(sqlQuery,username,password);
			
		var sqlQuery = "Select * from credentials where username='"+username+"' and password='"+password+"'";

		//sql injection
		//madhu' -- 
			
		var resultSet = statement.executeQuery(sqlQuery);
		
		if(resultSet.next()) {
			out.println("Valid Access");
		}
		else
		{
			out.println("Invalid Access");
		}
		
		}
		
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
}
