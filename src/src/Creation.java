import global.Contrainte;
import global.Recette;
import ingredient.Ingredient;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Creation {

    public static List<Recette> creationRecettes(Database database) throws SQLException {
        List<Recette> recettes = new ArrayList<>();
        ResultSet recettesData = database.recupererRecette();

        while (recettesData.next()) {
            int idRecette = recettesData.getInt("id_recette");
            String nomRecette = recettesData.getString("nom");
            ResultSet ingredientsData = database.recupererRecetteIngredient(idRecette);
            List<Ingredient> ingredients = new ArrayList<>();
            // todo recuperer les ingredients et les etapes
            recettes.add(new Recette(idRecette, nomRecette, ingredients));
        }
        return null;
    }


    public static HashMap<String, List<Ingredient>> creationIngredients(Database database) throws Exception {
        HashMap<String, List<Ingredient>> ingredients = new HashMap<>();
        HashMap<Integer, String> types = new HashMap<>();
        ResultSet ingredientData = database.recupererRecette();
        ResultSet typeIngredient = database.recupererTypeIngredient();
        while (typeIngredient.next()){
            ingredients.put(typeIngredient.getString("nom"), new ArrayList<>());
            types.put(typeIngredient.getInt("id_type"), typeIngredient.getString("nom"));
        }

        while (ingredientData.next()) {
            int idIngredient = ingredientData.getInt("id_ingredient");
            String nomIngredient = ingredientData.getString("nom");
            ResultSet ingredientsData = database.recupererRecetteIngredient(idIngredient);
            String type = types.get(ingredientData.getInt("id_type"));
            // todo recuperer les contraintes

            ingredients.get(type).add((Ingredient) Creation.newIngredient(type, idIngredient, nomIngredient, new ArrayList<Contrainte>()));

        }
        return null;
    }


    public static Object newIngredient(String classeNom, int id, String nom, List<Contrainte> contraintes) throws Exception {
        Class<?> clazz = Class.forName("global." + classeNom);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        return constructor.newInstance(id, nom, contraintes);
    }
}
