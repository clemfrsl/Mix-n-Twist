package ingredient;

import global.Contrainte;

import java.util.List;

public interface Ingredient {
    String getNom();
    int getID();
    List<Contrainte> getContraintes();



}
