import global.Recette;
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

        System.out.println(bd.recupererContraintes());
        HashMap<String, List<Ingredient>> ingredients = Utilisation.creationIngredients(bd);
        for(List<Ingredient> list: ingredients.values()){
            for(Ingredient i: list){
                System.out.println(i);
            }
        }

        List<Recette> recettes = Utilisation.creationRecettes(bd, ingredients);
        //recettes = Utilisation.rechercheParNom(bd, recettes, "di");
        for(Recette r: recettes){
            System.out.println(r);
        }



    }

}
