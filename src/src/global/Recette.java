package global;

import ingredient.Ingredient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Recette {

    private int id;
    private String nom;
    private List<Ingredient> ingredients;
    private LinkedList<String> etapes;

    public Recette(int id, String nom, List<Ingredient> ingredients, LinkedList<String> etapes){
        this.id = id;
        this.nom = nom;
        this.ingredients = ingredients;
        this.etapes = etapes;
    }

    public Recette(int id, String nom, List<Ingredient> ingredients){
        this.id = id;
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
        if (!contraintes.contains(Contrainte.ALCOOLISE)){
            contraintes.add(Contrainte.SANS_ALCOOL);
        }
        return contraintes;
    }

    /** Ajout des étapes, selon si il ya une position précise ou non **/

    public void ajouteEtape(String etape){
        this.etapes.add(etape);
    }

    public void ajouteEtape(String etape, int pos){
        this.etapes.add(pos-1, etape);
    }

    public String montrerEtapes(){
        String result = "";
        int count = 1;
        for (String etape : etapes) {
            result += "Etape "+ count + " : " + etape + "\n";
            count++;
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public String getNom(){
        return nom;
    }

    public String toString(){
        return nom + "\n" + ingredients + "\n" + getContraintes() + "\n" + montrerEtapes();
    }

}


