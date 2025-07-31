import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class ExecuteQuery01 {
    public static <connection> void main(String[] args) throws SQLException {

        // Step 1: Register with PostGreSQL JDBC Driver (OPTIONAL since JAVA 7)
        // Step 2: Create connection with the database
        // Step 3: Create Statement
        // Step 4: Execute the query
        // Step 5: Close the connection

        // Step 1: Register with PostGreSQL JDBC Driver (OPTIONAL since JAVA 7)-
        // Before Java 7: You needed to load the JDBC driver manually using Class.forName(...).


        // Step 2: Create connection with the database

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_b349", "b349_user", "Password!");

        // Step 3: Create Statement


        if (connection != null){
          System.out.println("Sucessfully connected to the database!");
      }else {
            System.out.println("Failed to connect to the database!");
        }

       /* try {
            Statement statement = connection.createStatement();
            connection = DriverManager.getConnection("jdbc:postresql://localhost:5432/db_HB", "db_Hb", "Password!");

            System.out.println("Successfully connected to the database!");


        } catch (SQLException e) {
            System.out.println("Failed to connect to the database!" + e. getMessage());
        }
         //  Step 3:  Create Statement
        /*  ==> Creating a Statement means instantiating an object in Java that allows
        SQL commands to be sent to the database through an active JDBC connection */

        Statement statement = connection . createStatement();

        // Step 4: Execute the query

        boolean query1 = statement.execute("CREATE TABLE IF NOT EXISTS employees(employee_id INT, employee_name varchar(30), salary INT);");
        System.out.println("query1 = " + query1);
        // Task 1: Read the data from the table employees

        // Add a column employee_address
        // ALTER TABLE employees ADD COLUMN IF NOT EXIST employee_address VARCHAR (40)

        boolean query2 = statement.execute("ALTER TABLE employees ADD COLUMN IF NOT EXISTS employee_address VARCHAR (40)");
        System.out.println("query2 = " + query2); // false => still working with DDL query

        // Add a record (data) to employees table
        boolean query3 = statement.execute("INSERT INTO employees VALUES (01, 'John Doe', 1000, 'Texas, USA')");
        System.out.println("query3 = " + query3); // false => DML => Data is being manipulated


        // To see the table on the console
        // SELECT * FROM  employees;
        boolean query4 = statement.execute("SELECT * FROM employees");
        System.out.println("query4 = " + query4); // true => because execute() method is working with DQL query which returns a ResultSet

        // NOTE: But we don't get toe see the table printed on the console as a result of query4.
        // statement.execute("SELECT * FROM employees") returns true to indicate that yes, there's a resultSet
        // In automation, we have to do one more step to see the resultSet (which we will do in the next class)

        // Find the record where employee_id is 1
        // SELECT * FROM employee WHERE employee_id = 1;
        boolean query5 =  statement.execute("SELECT * FROM employees WHERE employee_id = 1");
        System.out.println("query5 = " + query5); // true => DQL QUERY

        Statement statement1 = connection.createStatement();

        boolean query6 = statement.execute("INSERT INTO  employees VALUES (02, 'jame Doe', 1500, 'Madrid, Spain')");

        // Drop the table
        // DROP TABLE employees;
        boolean query7 = statement.execute("DROP TABLE employees");
        System.out.println("query6 = " + query6); // false => DDL query



//        Step 5: Close the connection
        if (connection != null){
            statement.close();
            connection.close();
            System.out.println("Statement and connection closed successfully!");
        }else {
            System.out.println("Connection is not closed!");
        }







    }
}







