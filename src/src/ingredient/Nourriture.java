package ingredient;
import global.Contrainte;
import java.util.List;




public class Nourriture implements Ingredient{

    private String nom;
    private int id;
    private List<Contrainte> contraintes;

    public Nourriture(int id, String nom, List<Contrainte> contraintes){
        this.nom = nom;
        this.id = id;
        this.contraintes = contraintes;
        //verification_sucre_sale();
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

    /** Oblige une nourriture a être au moins SUCREE ou SALE **/
    private void verification_sucre_sale(){
        if (!contraintes.contains(Contrainte.SUCREE) && !contraintes.contains(Contrainte.SALE)){
            throw new IllegalStateException("Il faut préciser si la nourriture est sucrée ou salée.");
        }
    }

    @Override
    public String getClasseNom(){
        return "Nourriture";
    }

    public String toString(){
        return nom;
    }
}
