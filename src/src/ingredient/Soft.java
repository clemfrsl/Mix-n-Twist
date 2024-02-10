package ingredient;

import global.Contrainte;

import java.util.List;

public class Soft implements Liquide{

    private String nom;
    private List<Contrainte> contraintes;

    public Soft(String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.contraintes = contraintes;
        if (this.contraintes.contains(Contrainte.ALCOOLISE)) {
            throw new IllegalStateException("La contrainte ALCOOLISE ne peut pas être un Soft.");
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
