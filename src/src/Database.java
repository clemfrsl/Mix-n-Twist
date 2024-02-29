import java.sql.*;
import java.util.List;

public class Database {

    String user, password, url;
    Connection connection;

    public Database(String user, String password) throws SQLException {
        this.url = "jdbc:mysql://localhost:3306/mix-n-twist";
        this.user = "M1";
        this.password = "mixntwist";
        connection();
    }

    public void connection() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void close() throws SQLException {
        connection.close();
    }

    // todo : penser à remplacer par recette et surtout voir comment renvoyer la donnée
    public ResultSet rechercheParNom(String nom) {
        String request = "SELECT * FROM Ingredient WHERE nom LIKE '%" + nom + "%';";
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt.executeQuery(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
