package ingredient;
import global.Contrainte;

import java.util.ArrayList;
import java.util.List;

public class Soft implements Ingredient{

    private String nom;
    private int id;
    private List<Contrainte> contraintes;

    public Soft(int id, String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.id = id;
        this.contraintes = contraintes;
        if (this.contraintes.contains(Contrainte.ALCOOLISE)) {
            throw new IllegalStateException("Un soft ne peut pas être alcoolisé.");
        }
    }

    public Soft(String nom){
        this.nom = nom;
        this.contraintes = new ArrayList<>();
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
}
