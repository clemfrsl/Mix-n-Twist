package ingredient;
import global.Contrainte;

import java.util.ArrayList;
import java.util.List;

public class Alcool implements Ingredient{

    private String nom;
    private int id;
    private List<Contrainte> contraintes;

    /** Constructeur obligant d'avoir la contrainte ALCOOLISE et erreur si SANS_ALCOOL **/

    public Alcool(int id, String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.id = id;
        this.contraintes = contraintes;
        if (!this.contraintes.contains(Contrainte.ALCOOLISE)){
            this.contraintes.add(Contrainte.ALCOOLISE);
        }
        if (this.contraintes.contains(Contrainte.SANS_ALCOOL)) {
            throw new IllegalStateException("Un alcool ne peut pas être sans alcool.");
        }
    }

    public Alcool(int id, String nom){
        this.id = id;
        this.nom = nom;
        this.contraintes = new ArrayList<>();
        this.contraintes.add(Contrainte.ALCOOLISE);
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public List<Contrainte> getContraintes() {
        return contraintes;
    }

    public String toString(){
        return nom;
    }

    @Override
    public String getClasseNom(){
        return "Alcool";
    }

}
