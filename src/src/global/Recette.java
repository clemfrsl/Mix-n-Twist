package global;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Recette {

    private String nom;
    private List<Ingredient> ingredients;
    private LinkedList<String> etapes;

    public Recette(String nom, List<Ingredient> ingredients, LinkedList<String> etapes){
        this.nom = nom;
        this.ingredients = ingredients;
        this.etapes = etapes;
    }

    public Recette(String nom, List<Ingredient> ingredients){
        this.nom = nom;
        this.ingredients = ingredients;
        this.etapes = new LinkedList<>();
    }

    public List<Contrainte> getContraintes(){
        List<Contrainte> contraintes = new ArrayList<>();
        for(Ingredient ingredient : ingredients){
            for (Contrainte c : ingredient.getContraintes()) {
                if (!contraintes.contains(c)) {
                    contraintes.add(c);
                }
            }
        }
        return contraintes;
    }

    // Ajout des étapes, selon si il ya une position précise ou non

    public void ajouteEtape(String etape){
        this.etapes.add(etape);
    }

    public void ajouteEtape(String etape, int pos){
        this.etapes.add(pos, etape);
    }

    public String montrerEtapes(){
        String result = "";
        int count = 1;
        for (String etape : etapes) {
            result += "Etape "+ count + " : \n"
            + etape;
            count++;
        }
        return result;
    }

    public String toString(){
        return nom + "\n" + ingredients + "\n" + getContraintes() + "\n" + montrerEtapes();
    }
}