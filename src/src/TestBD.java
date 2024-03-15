import ingredient.Ingredient;

import java.util.HashMap;
import java.util.List;

public class TestBD {

    public static void main(String[] args) throws Exception {
        Database bd = new Database();
        /*ResultSet resultSet = bd.rechercheParNom("it");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("nom"));
        }

        resultSet.close();*/

        HashMap<String, List<Ingredient>> ingredients = Creation.creationIngredients(bd);
        for(List<Ingredient> list: ingredients.values()){
            for(Ingredient i: list){
                System.out.println(i);
            }
        }

    }

}