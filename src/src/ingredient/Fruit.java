package ingredient;

import global.Contrainte;

import java.util.List;

public class Fruit implements Ingredient{

    private String nom;
    private int id;
    private List<Contrainte> contraintes;

    public Fruit(int id, String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.id = id;
        this.contraintes = contraintes;
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
