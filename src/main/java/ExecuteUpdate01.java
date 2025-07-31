mport java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate01 {
    public static <CREATE> void main(String[] args) throws SQLException {
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




        CREATE TABLE; students("id int,name varchar(50),city varchar(50),grade int,department varchar(20)");

        statement.executeUpdate("INSERT INTO students VALUES(100, 'Ahmet Umit', 'İstanbul', 546, 'Comp.Eng.');
                statement.executeUpdate("INSERT INTO students VALUES(101, 'R.Nuri Tekin', 'Antalya', 486, 'Management')");
        statement.executeUpdate("INSERT INTO students VALUES(102, 'S.Faik Faruk', 'Bursa', 554, 'Comp.Eng.')");
        statement.executeUpdate("INSERT INTO students VALUES(103, 'Yasar Kemal', 'İstanbul', 501, 'Mathematics')");
        statement.executeUpdate("INSERT INTO students VALUES(104, 'Halide E. Adivar', 'İzmir', 473, 'Psychology')");
        statement.executeUpdate("INSERT INTO students VALUES(105, 'Nazan Bekir', 'İzmir', 432, 'Literature')");
        statement.executeUpdate( "INSERT INTO students VALUES(106, 'Peyami Safa', 'Antalya', 535, 'Comp.Eng.')");
        statement.executeUpdate("INSERT INTO students VALUES(107, 'Sabahattin Ali', 'İstanbul', 492, 'Mathematics')");
        statement.executeUpdate("INSERT INTO students VALUES(108, 'John Smith', 'Texas', 432, 'Comp.Eng.')");
        statement.executeUpdate( "INSERT INTO students VALUES(109, 'Jane Smith', 'Washington DC', 340, 'Literature'");
        statement.executeUpdate( "INSERT INTO students VALUES(110, 'Asye Ahmet', 'Istanbul', 410, 'Psychology')");

===========================================================
        CREATE TABLE departments(
                dept_id int,
        department varchar(20),
                pass_grade int,
        campus varchar(20)
              );

        INSERT INTO departments VALUES(5001, 'Comp.Eng.', 521,'North');
        INSERT INTO departments VALUES(5002, 'Mathematics', 455,'South');
        INSERT INTO departments VALUES(5003, 'Psychology', 440,'Hisar');
        INSERT INTO departments VALUES(5004, 'Management', 465,'Hisar');
        INSERT INTO departments VALUES(5005, 'Literature', 420,'North');




        // taske update the student who is grade is 110 to 450



        UPDATE student SET grade = 450 where id = 110;
















        // Step 5: Close the connection
        if (connection != null){
            statement.close();
            connection.close();
            System.out.println("Disconnected successfully!");
        }else {
            System.out.println("Still connected!");
        }
    }

    private static void students(String s) {
    }
}