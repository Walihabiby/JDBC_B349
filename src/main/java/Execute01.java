import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

          /*
        NOTES:

        pgAdmin4 is used for
        1. Creating database, tabular structure, adding or deleting values etc.
        2. Manual Testing of DB by Devs as well as Testers

        pgAdmin4 is GUI (Graphic User Interface) for Postgres SQL Database.

        JDBC Driver is used for AUTOMATION of Database.

        To create connection with DB, we need to follow these steps:
        Step 1: Register with Driver class (OPTIONAL) because it's not needed anymore (since JAVA 7)
        Step 2: Create connection with the database
        Step 3: Create statement
        Step 4: Execute the query
        Step 5: Close the connection


         */

        //        Step 1: Register with Driver class (OPTIONAL) because it's not needed anymore (since JAVA 7)
        Class.forName("org.postgresql.Driver");  // OPTIONAL
        //        Step 2: Create connection with the database
        //        Please check the port number if you get an error => port: 5432 OR 5433
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_b349", "b349_user", "Password!");

        if(connection != null){
            System.out.println("Connection is successful!");
        }else {
            System.out.println("Connection is not successful!");
        }


        //        Step 3: Create statement
        Statement statement = connection.createStatement();

        //        Step 4: Execute the query
        boolean query1 = statement.execute("CREATE TABLE IF NOT EXISTS employees(employee_id INT, employee_name VARCHAR (30), salary INT);");
        System.out.println("query1 = " + query1); // false because execute() method is working with a DDL query here and there is NO resultSet, hence execute() returns false

        // Add a column employee_address
        // ALTER TABLE employees ADD COLUMN IF NOT EXISTS employee_address VARCHAR (40);
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

        // Drop the table
        // DROP TABLE employees;
        boolean query6 = statement.execute("DROP TABLE employees");
        System.out.println("query6 = " + query6); // false => DDL query


        //   Step 5: Close the connection
        if (connection != null){
            statement.close();
            connection.close();
            System.out.println("Statement and connection closed successfully!");
        }else {
            System.out.println("Connection is not closed!");
        }


    }
}