import global.Recette;
import ingredient.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
}
