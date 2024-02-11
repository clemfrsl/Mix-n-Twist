package ingredient;
import global.Contrainte;
import java.util.List;

public class Soft implements Ingredient{

    private String nom;
    private List<Contrainte> contraintes;

    public Soft(String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.contraintes = contraintes;
        if (this.contraintes.contains(Contrainte.ALCOOLISE)) {
            throw new IllegalStateException("Un soft ne peut pas être alcoolisé.");
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
