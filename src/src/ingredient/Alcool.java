package ingredient;

import global.Contrainte;

import java.util.ArrayList;
import java.util.List;

public class Alcool implements Liquide{

    private String nom;
    private List<Contrainte> contraintes;

    public Alcool(String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.contraintes = contraintes;
        if (!this.contraintes.contains(Contrainte.ALCOOLISE)){
            this.contraintes.add(Contrainte.ALCOOLISE);
        }
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public List<Contrainte> getContraintes() {
        return contraintes;
    }

}
