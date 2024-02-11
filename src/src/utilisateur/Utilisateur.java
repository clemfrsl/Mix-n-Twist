package utilisateur;

import ingredient.Ingredient;

import java.time.LocalDate;
import java.util.List;

public class Utilisateur {

    private String nom, prenom, numero, email;
    private int date_naissance;
    private List<Ingredient> frigo;
    private Liste_Course liste_course;

    public int getAge(){
        return LocalDate.now().getYear() - date_naissance;
    }

}
