import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {

        // Step 2: Create connection with the database
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/jdbc_b349", "b349_user", "Password!");
        if (connection != null){
            System.out.println("Connected successfully!");
        }else {
            System.out.println("Not connected!");
        }
        // Step 3: Create Statement
        Statement statement = connection.createStatement();

        // Step 4: Execute the query
        System.out.println("============== Task 1 ==========");
        // Display the names of the students and their grades if their grades are higher than the pass grade of their department
        // SELECT name , grade FROM students s INNER JOIN departments d ON s.department = d.department WHERE s.grade > d.pass_grade;
        String query1 = "SELECT name , grade FROM students s INNER JOIN departments d ON s.department = d.department WHERE s.grade > d.pass_grade;";

        ResultSet rs1 = statement.executeQuery(query1);

        while (rs1.next()){
            // System.out.println(rs1.getString("name") +" - " +rs1.getInt("grade"));
            System.out.println(rs1.getString(1) +" - " +rs1.getInt(2)); // we can use the index of the column as well instead of the name of the column
        }


        // Task 2:  HW
        // Print department name and grade of department which has the second-highest pass_grade





        // Step 5: Close the connection
        if (connection != null){
            statement.close();
            connection.close();
            System.out.println("Disconnected successfully!");
        }else {
            System.out.println("Still connected!");
        }










    }
}