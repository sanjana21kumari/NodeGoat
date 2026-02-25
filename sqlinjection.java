import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class SQLInjectionExample {

    public static void main(String[] args) {

        String userInput = args.length > 0 ? args[0] : "admin";

        getUserData(userInput);
    }

    public static void getUserData(String username) {

        Connection conn = null;
        Statement stmt = null;

        try {
            // Database connection (example only)
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", 
                "root", 
                "password"
            );

            stmt = conn.createStatement();

            // Vulnerable SQL query (SQL Injection)
            String query = "SELECT * FROM users WHERE username = '" + username + "'";

            System.out.println("Executing query: " + query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
