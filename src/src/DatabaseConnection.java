import java.sql.*;

public class DatabaseConnection {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Supprimez la ligne de chargement du pilote
        // Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/mix-n-twist";
        String user = "M1";
        String password = "mixntwist";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select nom from Ingredient where id_ingredient = 1;";
        try (Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            // execute query
            try (ResultSet rs = stmt.executeQuery(sql)) {
                // position result to first
                rs.first();
                System.out.println(rs.getString(1)); // result is "Hello World!"
            }
        }
    }
}
