package ingredient;
import global.Contrainte;

import java.util.ArrayList;
import java.util.List;

public class Alcool implements Ingredient{

    private String nom;
    private List<Contrainte> contraintes;

    public Alcool(String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.contraintes = contraintes;
        if (!this.contraintes.contains(Contrainte.ALCOOLISE)){
            this.contraintes.add(Contrainte.ALCOOLISE);
        }
    }

    public Alcool(String nom){
        this.nom = nom;
        this.contraintes = new ArrayList<>();
        this.contraintes.add(Contrainte.ALCOOLISE);
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public List<Contrainte> getContraintes() {
        return contraintes;
    }

    public String toString(){
        return nom;
    }

}
