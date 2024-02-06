package utilisateur;

import java.time.LocalDate;

public class Utilisateur {

    private String nom, prenom, numero, email;
    private int date_naissance;
    private Frigo frigo;
    private Liste_Course liste_course;

    public int getAge(){
        return LocalDate.now().getYear() - date_naissance;
    }

}
