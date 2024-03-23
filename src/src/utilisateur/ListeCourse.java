package utilisateur;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class ListeCourse {

    private List<Ingredient> ingredients;

    public ListeCourse() {
        this.ingredients = new ArrayList<>();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredients(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void deleteIngredients(Ingredient ingredient){
        if (ingredients.contains(ingredient)){
            this.ingredients.remove(ingredient);
        }

    }

}
