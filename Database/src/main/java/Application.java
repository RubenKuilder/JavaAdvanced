import java.sql.*;

public class Application {
    static final String DB_URL = "jdbc:mysql://localhost:8889/JavaDatabase";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO Table1 VALUES (101, 'Koen', 108.3)");
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Table1");


            while (resultSet.next()) {
                System.out.println(resultSet.getInt("a"));
                System.out.println(resultSet.getString("b"));
                System.out.println(resultSet.getFloat("c"));
            }

            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
