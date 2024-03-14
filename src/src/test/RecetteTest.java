package test;

// les imports

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import global.Contrainte;
import global.Recette;
import ingredient.Alcool;
import ingredient.Ingredient;
import ingredient.Nourriture;
import ingredient.Soft;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;




/**

public class RecetteTest {

    private Recette recette;



    //méthode pour l'initialisation
    @Before
    public void setUp() {
        // ingrédients pour la recette
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Alcool("Rhum", id, List.of(Contrainte.ALCOOLISE)));
        ingredients.add(new Nourriture("Sucre", List.of(Contrainte.SUCREE)));
        ingredients.add(new Soft("Jus Orange", List.of(Contrainte.SANS_ALCOOL)));


        recette = new Recette("Test Recette", ingredients, new LinkedList<>());
        recette.ajouteEtape("Mélanger rhum avec sucre et jus.");
    }





    //Vérif getContraintes() pour le renvoie contraintes de la recette
    @Test
    public void TestGetContraintes() {
        // (tout ok !)
        assertEquals(List.of(Contrainte.ALCOOLISE, Contrainte.SUCREE, Contrainte.SANS_ALCOOL), recette.getContraintes());
    }



    //Vérifier que l'étape a été ajoutée
    @Test
    public void TestAjouteEtape() {
        // Ajouter une étape
        recette.ajouteEtape("et glouglouglou.");

        //(tout ok !)
        assertTrue(recette.montrerEtapes().contains("et glouglouglou"));
    }



    // Vérif montrerEtapes()
    @Test
    public void TestMontrerEtapes() {
        String etapesAttendues = "Etape 1 : Mélanger rhum avec sucre et jus.\n";
        //(tout ok !)
        assertEquals(etapesAttendues, recette.montrerEtapes());
    }



    // Vérifier getNom() retourne le nom de la recette
    @Test
    public void testGetNom() {

        assertEquals("Test Recette", recette.getNom());
    }

// a voir mais on peut rajouter des étapes vide, des noms de recette super long ....
}
**/
