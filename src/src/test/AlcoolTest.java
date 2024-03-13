package test;


//Les imports
import static org.junit.Assert.assertEquals;

import global.Contrainte;
import ingredient.Alcool;
import ingredient.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.util.List;




public class AlcoolTest {

    private Ingredient alcool;

    //mise en place
    @Before
    public void setUp() {
        alcool = new Alcool("Rhum", id, List.of(Contrainte.ALCOOLISE));
    }




    //recup nom
    @Test
    public void testGetNom() {
        //(tout ok!)
        assertEquals("Rhum", alcool.getNom());
    }


    //test getContraintes
    @Test
    public void testGetContraintes() {
        //(tout ok !)
        assertEquals(List.of(Contrainte.ALCOOLISE), alcool.getContraintes());
    }



    //verif qu'un alcool sans contrainte est quand meme un alcool
    @Test
    public void AlcoolSansContraintes() {
        Ingredient alcoolSansContraintes = new Alcool("Vodka");
        assertEquals("Vodka", alcoolSansContraintes.getNom());
        assertEquals(List.of(Contrainte.ALCOOLISE), alcoolSansContraintes.getContraintes());
    }
}

