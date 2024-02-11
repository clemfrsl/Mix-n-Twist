package global;

import java.util.ArrayList;
import java.util.List;

public class Filtre {

    private List<Contrainte> contraintes;

    public Filtre(List<Contrainte> contraintes) {
        this.contraintes = contraintes;
    }

    public List<Recette> filtrer(List<Recette> recettes){
        List<Recette> newListRecettes = new ArrayList<>();
        for(Recette recette : recettes){
            int count = -1;
            for(Contrainte contrainte: contraintes){
                if(recette.getContraintes().contains(contrainte)){
                    count++;
                }
            }
            if (count == -1){
                newListRecettes.add(recette);
            }
        }
        return newListRecettes;
    }
}
