package src;
//WIP

//Query1.java:  Query an mSQL database using JDBC. 

import java.sql.*;

/**
* A JDBC SELECT (JDBC query) example program.
*/
public class Lname {
	 public static void main (String[] args) {
	        try {
	            String url = "jdbc:mysql://localhost:3306/db1";
	            Connection conn = DriverManager.getConnection(url,"","");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT Fname, Lname FROM Customers WHERE Lname like 'Kovac'");
	            while ( rs.next() ) {
	                String lastName = rs.getString("Lname");
	                System.out.println(lastName);
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
	    }

}