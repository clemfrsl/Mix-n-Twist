import global.Contrainte;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

public class Database {

    private String user, password, url;
    private Connection connection;

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

    public ResultSet rechercheParNom(String nom) {
        String request = "SELECT * FROM Recette WHERE nom LIKE '%" + nom + "%';";
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt.executeQuery(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /*public void ajouterContraintes(){
        String request = "SELECT * FROM Contrainte;";
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet contraintes = stmt.executeQuery(request);
            while (contraintes.next()) {
                String nomContrainte = contraintes.getString("nom_contrainte");

                try {
                    Contrainte contrainteEnum = Contrainte.valueOf(nomContrainte.toUpperCase());
                    // Vous pouvez maintenant utiliser contrainteEnum comme une constante de l'énumération
                    // ...
                } catch (IllegalArgumentException e) {
                    // Gérer le cas où le nom de contrainte n'existe pas dans l'énumération
                    System.out.println("Contrainte inconnue : " + nomContrainte);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for(Contrainte c : Contrainte.values()){
            System.out.println(c);
        }
    }*/

    public ResultSet recupererRecette(){
        String request = "SELECT * FROM Recette;";
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt.executeQuery(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet recupererRecetteIngredient(int idRecette){
        String request = "SELECT * FROM ingredientRecette WHERE id_recette = " + idRecette + ";";
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt.executeQuery(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Connection getConnection(){
        return connection;
    }

}
