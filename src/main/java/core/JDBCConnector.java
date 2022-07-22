package core;

import apiEngine.model.lits.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnector {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/osdb"
            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String[] args) {
        try {
            // STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: Execute a query
            System.out.println("Creating statement...");
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(query);

            // STEP 4.1 Create a list for query results
            List<Users> usersList = new ArrayList<>();

            // STEP 5: Extract data from result set
            while (resultSet.next()) {
                usersList.add(
                        new Users(
                                resultSet.getInt("id"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName")
                        )
                );
            }

            // STEP 5.1
            for (Users user : usersList) {
                System.out.println(user);
            }

            // STEP 6: Clean-up environment
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}
