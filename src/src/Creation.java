import global.Contrainte;
import global.Recette;
import ingredient.Alcool;
import ingredient.Ingredient;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Creation {

    /** Crée toutes les recettes de la BD **/

    public static List<Recette> creationRecettes(Database database, HashMap<String, List<Ingredient>> ingredients) throws SQLException {
        List<Recette> recettes = new ArrayList<>();
        ResultSet recettesData = database.recupererRecette();

        while (recettesData.next()) {
            int idRecette = recettesData.getInt("id_recette");
            String nomRecette = recettesData.getString("nom_recette");
            ResultSet ingredientsData = database.recupererRecetteIngredient(idRecette);
            List<Ingredient> ingredientsRecette = new ArrayList<>();
            while (ingredientsData.next()){
                for(List<Ingredient> listIngredient: ingredients.values()){
                    for(Ingredient i : listIngredient){
                        if(i.getID() == ingredientsData.getInt("id_ingredient")){
                            ingredientsRecette.add(i);
                            break;
                        }
                    }

                }
            }

            LinkedList etapesRecette = database.recupererEtapeRecette(idRecette);
            recettes.add(new Recette(idRecette, nomRecette, ingredientsRecette, etapesRecette));
        }
        return recettes;
    }

    /** Crée tous les ingredients de la BD **/

    public static HashMap<String, List<Ingredient>> creationIngredients(Database database) throws Exception {
        HashMap<String, List<Ingredient>> ingredients = new HashMap<>();
        HashMap<Integer, String> types = database.recupererTypeIngredient();
        ResultSet ingredientData = database.recupererIngredients();
        for(String type : types.values()){
            ingredients.put(type, new ArrayList<>());
        }

        while (ingredientData.next()) {
            int idIngredient = ingredientData.getInt("id_ingredient");
            String nomIngredient = ingredientData.getString("nom_ingredient");
            String type = types.get(ingredientData.getInt("type_ingredient"));
            List<Contrainte> contrainteIngredient = database.recupererContrainteIngredient(ingredientData.getInt("id_ingredient"));
            ingredients.get(type).add((Ingredient) Creation.newIngredient(type, idIngredient, nomIngredient, contrainteIngredient));
        }
        ingredientData.close();
        return ingredients;
    }

    /** Crée un ingredient suivant son type **/

    public static Object newIngredient(String classeNom, int id, String nom, List<Contrainte> contraintes) throws Exception {
        Class<?> clazz = Class.forName("ingredient." + classeNom);
        Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, String.class, List.class);
        return constructor.newInstance(id, nom, contraintes);
    }
}
