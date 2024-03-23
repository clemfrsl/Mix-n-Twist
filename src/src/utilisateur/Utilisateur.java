package utilisateur;

import ingredient.Ingredient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

    private String nom, prenom, numero, email;
    private int date_naissance, id;
    private List<Ingredient> frigo;
    private ListeCourse liste_course;

    public Utilisateur(int id, String nom, String prenom, String numero, String email, int date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.numero = numero;
        this.email = email;
        this.date_naissance = date_naissance;
        this.frigo = new ArrayList<>();
        liste_course = new ListeCourse();
    }

    public int getAge(){
        return LocalDate.now().getYear() - date_naissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public List<Ingredient> getFrigo() {
        return frigo;
    }

    public ListeCourse getListe_course() {
        return liste_course;
    }
}

