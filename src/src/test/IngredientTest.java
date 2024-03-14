package test;

// les imports

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import global.Contrainte;
import ingredient.Alcool;
import ingredient.Ingredient;
import ingredient.Nourriture;
import ingredient.Soft;
import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.ArrayList;

/**
public class IngredientTest {
    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        ingredients = new ArrayList<>();
        ingredients.add(new Alcool("Rhum", id, List.of(Contrainte.ALCOOLISE)));
        ingredients.add(new Nourriture("Sucre", List.of(Contrainte.SUCREE)));
        ingredients.add(new Soft("Jus Orange", List.of(Contrainte.SANS_ALCOOL)));
    }



    //Test recup nom
    @Test
    public void testGetNom() {
        Ingredient ingredient = new Alcool("Rhum");
        assertEquals("Rhum", ingredient.getNom());
    }



    //test recup contraintes
    @Test
    public void testGetContraintes() {
        Ingredient ingredient = new Alcool("Rhum", id, List.of(Contrainte.ALCOOLISE));
        assertEquals(List.of(Contrainte.ALCOOLISE), ingredient.getContraintes());
    }



    //Test création d'un nouvel ingrédient
    @Test
    public void TestCreerIngr() {
        Ingredient ingredient = new Nourriture("lala", List.of(Contrainte.SUCREE));
        assertEquals("lala", ingredient.getNom());
        assertEquals(List.of(Contrainte.SUCREE), ingredient.getContraintes());
    }

    //pareil mais sans contrainte pour l'ingrédient
    @Test
    public void TestCreerIngrSansContraintes() {
        Ingredient ingredient = new Soft("Eau");
        assertEquals("Eau", ingredient.getNom());
        assertTrue(ingredient.getContraintes().isEmpty());
    }

}
**/