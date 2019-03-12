package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Database {
    private final String username="Monolith";
    private final String password="str";
    private final String url = "jdbc:mysql://localhost:3306/db1";

    private Connection getConnection(){
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Done");
            connection = DriverManager.getConnection(url,username,password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertNewPerson(Person person){
        Connection conn=getConnection();
        try {
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO person(fname,lname,dob,pin) values(?,?,?,?)");
            stmt.setString(1,person.getFname());
            stmt.setString(2,person.getLname());
            stmt.setDate(3,new Date(person.getDob().getTime()));
            stmt.setString(4,person.getPin());
            int result=stmt.executeUpdate();

            closeConnection(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person selectPersonByLastName(String lname){
        Connection conn=getConnection();
        try {
            PreparedStatement stmt=conn.prepareStatement("SELECT * FROM person WHERE lname LIKE ?");
            stmt.setString(1,lname);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                String lastname=rs.getString("lname");
                String fname=rs.getString("fname");
                String pin=rs.getString("pin");
                Date dob=rs.getDate("dob");

                Person p=new Person(lastname,fname,pin,dob);
                closeConnection(conn);
                return p;
            }
            else
            {
                closeConnection(conn);
                return null;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection conn){
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Person> getAllMens(){
        Connection conn=getConnection();
        String query="SELECT * FROM person WHERE pin LIKE '__0%' OR pin LIKE '__1%'";
        List<Person> persons = new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement stmt=conn.prepareStatement(query);
            rs=stmt.executeQuery();
            while(rs.next()){
                String lastname=rs.getString("lname");
                String fname=rs.getString("fname");
                String pin=rs.getString("pin");
                Date dob=rs.getDate("dob");
                Person p=new Person(lastname,fname,pin,dob);
                persons.add(p);
            }
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }
}