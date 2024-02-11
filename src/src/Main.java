import global.Contrainte;
import global.Recette;
import ingredient.Alcool;
import ingredient.Ingredient;
import ingredient.Soft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ingredient soft = new Soft("Jus d'Orange", new ArrayList<>(List.of(Contrainte.SUCREE)));
        Ingredient gin = new Alcool("Gin");

        Recette r = new Recette("Gin + Orange", new ArrayList<Ingredient>(List.of(soft, gin)));
        r.ajouteEtape("Mettre 4cl de Gin");
        r.ajouteEtape("Mélanger");
        r.ajouteEtape("Mettre 30cl de Jus d'orange", 2);

        System.out.println(r);

    }
}
