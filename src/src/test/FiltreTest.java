package test;


// les imports

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
//class FiltreTest
public class FiltreTest {


    //DRY (Don't Repeat Yourself) ici on utilise les attributs des classes Filtre et Recette
    private Filtre filtre;
    private List<Recette> recettes;



    @Before

    //Méthode pour l'initialisation
    public void setUp() {

        // Recettes
        recettes = new ArrayList<>();
        // 1
        List<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(new Alcool("Rhum", id, List.of(Contrainte.ALCOOLISE)));
        ingredients1.add(new Nourriture("Sucre", List.of(Contrainte.SUCREE)));
        Recette recette1 = new Recette("Punch", ingredients1, new LinkedList<>());
        recette1.ajouteEtape("Mélanger rhum avec sucre.");
        recettes.add(recette1);
        //2
        List<Ingredient> ingredients2 = new ArrayList<>();
        ingredients2.add(new Soft("Jus d'orange", List.of(Contrainte.SANS_ALCOOL)));
        ingredients2.add(new Soft("Soda", List.of(Contrainte.SANS_ALCOOL)));
        Recette recette2 = new Recette("Orange Soda", ingredients2, new LinkedList<>());
        recette2.ajouteEtape("mélanger jus et le soda.");
        recettes.add(recette2);

        // filtre contraintes
        List<Contrainte> contraintes = new ArrayList<>();
        contraintes.add(Contrainte.ALCOOLISE);
        filtre = new Filtre(contraintes);
    }



    // là c'est la recettes qui devraient passer le filtre
    @Test
    public void TestRecettesOk(){
        List<Recette> recettesFiltrees = filtre.filtrer(recettes);
        //expected : 1 reel : 1 tout est ok sur le filtrage alcool
        assertEquals(1, recettesFiltrees.size());
    }

    // test recette qui ne doit pas passer le filtre
    @Test
    public void TestRecettePasOk() {
        //recette qui respecte pas la contrainte sans alcool
        List<Recette> recettePasOk = new ArrayList<>();
        List<Ingredient> ingredientsPasOk = new ArrayList<>();
        ingredientsPasOk.add(new Soft("Jus", List.of(Contrainte.SANS_ALCOOL)));
        Recette recetteNonFiltree = new Recette("Jus", ingredientsPasOk, new LinkedList<>());
        recettePasOk.add(recetteNonFiltree);

        List<Recette> result = filtre.filtrer(recettePasOk);

        // expected : 0, reel : 0 tout est ok

        assertEquals(0,result.size());

    }



    //test plusieurs contraintes en même temps
    @Test
    public void TestPlusieursContraintes() {
        // contraintes
        List<Contrainte> contraintes = List.of(Contrainte.ALCOOLISE, Contrainte.SUCREE);
        List<Recette> recettesAvecContraintes = new ArrayList<>();

        // Recette plusieurs contraintes
        List<Ingredient> ingredientsRecette = new ArrayList<>();
        ingredientsRecette.add(new Alcool("Vovo", id, List.of(Contrainte.ALCOOLISE)));
        ingredientsRecette.add(new Nourriture("Sucre", List.of(Contrainte.SUCREE)));
        Recette recette1 = new Recette("Vodka Sucre", ingredientsRecette, new LinkedList<>());
        recettesAvecContraintes.add(recette1);


        List<Recette> result = new Filtre(contraintes).filtrer(recettesAvecContraintes);
        // Vérification ok
        for (Recette recette : result) {
            assertTrue(recette.getContraintes().containsAll(contraintes));
        }
    }


    // Peut être voir pour vérif que la contrainte alcool/sans alcool ne sont pas faisable en meme temps
}
 **/
