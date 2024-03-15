package ingredient;
import global.Contrainte;
import java.util.List;

public class Jus implements Ingredient{

    private String nom;
    private int id;
    private List<Contrainte> contraintes;

    public Jus(int id, String nom, List<Contrainte> contraintes){
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

    @Override
    public String getClasseNom(){
        return "Jus";
    }

    public String toString(){
        return nom;
    }
}
