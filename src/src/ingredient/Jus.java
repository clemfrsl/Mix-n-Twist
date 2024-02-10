package ingredient;

import global.Contrainte;

import java.util.List;

public class Jus implements Liquide{

    private String nom;
    private List<Contrainte> contraintes;

    public Jus(String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.contraintes = contraintes;
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
