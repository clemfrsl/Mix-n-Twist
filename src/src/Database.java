import global.Contrainte;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Database {

    private String user, password, url;
    private Connection connection;

    public Database() throws SQLException {
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

    /** Permet d'effectuer une recherche par nom dans les recettes **/
    //todo : à poffiner
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

    /** Permet de récuperer toutes les recettes **/

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

    /** Permet de récuperer toutes les recettes **/

    public ResultSet recupererIngredients(){
        String request = "SELECT * FROM Ingredient;";
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt.executeQuery(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /** Permet de récuperer tous les ingredients d'une recette donnée **/

    public ResultSet recupererRecetteIngredient(int idRecette){
        String request = "SELECT * FROM recetteIngredient WHERE id_recette = " + idRecette + ";";
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt.executeQuery(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /** Permet de récuperer tous les types d'ingredients **/

    public HashMap<Integer, String> recupererTypeIngredient(){
        String request = "SELECT * FROM TypeIngredient;";
        HashMap<Integer, String> types = new HashMap<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet typeIngredient =  stmt.executeQuery(request);
            while (typeIngredient.next()){
                types.put(typeIngredient.getInt("id_typeIngredient"), typeIngredient.getString("typeIngredient"));
            }
            typeIngredient.close();
            return types;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /** Permet de récuperer les étapes d'une recette données en LinkedList **/

    public LinkedList<String> recupererEtapeRecette (int idRecette){
        String request = "SELECT * FROM recetteEtapes WHERE id_recette = "+ idRecette+";";
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stmt.executeQuery(request);
            resultSet.last();
            int longueur = resultSet.getRow();
            resultSet.beforeFirst();
            String[] etapes = new String[longueur];
            while (resultSet.next()){
                etapes[resultSet.getInt("numero_etape")-1] = resultSet.getString("instruction_etape");
            }
            LinkedList<String> etapesList = new LinkedList<>();
            for (int index=0; index<longueur; index++){
                etapesList.add(etapes[index]);
            }
            resultSet.close();
            return etapesList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /** Permet de récuperer les contraintes d'un ingredient sous format List **/

    public List<Contrainte> recupererContrainteIngredient(int idIngredient){
        String request = "SELECT * FROM IngredientContraintes WHERE id_ingredient = "+ idIngredient+";";
        List<Contrainte> contraintesIngredient = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            HashMap<Integer, Contrainte> contraintes = recupererContraintes();
            ResultSet resultSet = stmt.executeQuery(request);
            while(resultSet.next()){
                contraintesIngredient.add(contraintes.get(resultSet.getInt("id_contraintes")));
            }

            resultSet.close();
            return contraintesIngredient;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contraintesIngredient;
    }

    /** Permet de récuperer toutes les contraintes sous forme de HashMap avec leurs id en clé **/

    public HashMap<Integer, Contrainte> recupererContraintes(){
        String request = "SELECT * FROM Contraintes;";
        HashMap<Integer, Contrainte> contraintes = new HashMap<>();
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stmt.executeQuery(request);
            while (resultSet.next()){
                for (Contrainte c : Contrainte.values()){
                    if (c.name() == resultSet.getString("contrainte")){
                        contraintes.put(resultSet.getInt("id_contraintes"), c);
                        break;
                    }
                }
            }
            resultSet.close();
            return contraintes;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Connection getConnection(){
        return connection;
    }

}
