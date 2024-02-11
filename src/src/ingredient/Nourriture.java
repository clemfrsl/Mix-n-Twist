package ingredient;
import global.Contrainte;
import java.util.List;

public class Nourriture implements Ingredient{

    private String nom;
    private List<Contrainte> contraintes;

    public Nourriture(String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.contraintes = contraintes;
        verification_sucre_sale();
    }

    @Override
    public String getNom() {
        return null;
    }

    @Override
    public List<Contrainte> getContraintes() {
        return null;
    }

    private void verification_sucre_sale(){
        if (!contraintes.contains(Contrainte.SUCREE) && !contraintes.contains(Contrainte.SALE)){
            throw new IllegalStateException("Il faut préciser si la nourriture est sucrée ou salée.");
        }
    }

    public String toString(){
        return nom;
    }
}
