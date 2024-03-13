import global.Contrainte;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        Database db = new Database("user", "password");
        ResultSet resultSet = db.rechercheParNom("it");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("nom"));
        }
        db.ajouterContraintes();

        resultSet.close();
    }

}
