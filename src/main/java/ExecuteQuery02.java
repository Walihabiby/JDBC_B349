
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;


public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {

        // Step 2: Create connection

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_b349", "b349_user", "Password!");


        // Step 3: Create Statement

        if (connection != null){
            System.out.println("Sucessfully connected to the database!");
        }else {
            System.out.println("Failed to connect to the database!");
        }


        Statement statement = connection.createStatement();

        statement.execute(
                "CREATE TABLE IF NOT EXISTS products (" +
                        "product_id INT PRIMARY KEY, " +
                        "product_name VARCHAR(50) NOT NULL, " +
                        "price INT NOT NULL)"
        );

        statement.execute("ALTER TABLE products ADD stock_quantity INT");

        statement.executeUpdate("INSERT INTO products VALUES (101, 'Laptop', 1500, 10)");
        statement.executeUpdate("INSERT INTO products VALUES (102, 'Smartphone', 900, 25)");
        statement.executeUpdate("INSERT INTO products VALUES (103, 'Keyboard', 40, 100)");


        statement.executeUpdate("UPDATE products SET price = 45 WHERE product_name = 'Keyboard'");


        statement.executeUpdate("DELETE FROM products WHERE product_id = 102");


        if (connection != null){
            statement.close();
            connection.close();
            System.out.println("Statement and connection closed successfully!");
        }else {
            System.out.println("Connection is not closed!");
        }








    }
}
