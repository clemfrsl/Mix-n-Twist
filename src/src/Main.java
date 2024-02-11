import global.Contrainte;
import global.Recette;
import ingredient.Alcool;
import ingredient.Ingredient;
import ingredient.Nourriture;
import ingredient.Soft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ingredient soft = new Soft("Jus d'Orange", new ArrayList<>(List.of(Contrainte.SUCREE)));
        Ingredient lait = new Soft("Lait", new ArrayList<>(List.of(Contrainte.SUCREE, Contrainte.LACTOSE)));
        Ingredient fraise = new Nourriture("Fraise", new ArrayList<>(List.of(Contrainte.SUCREE)));
        Ingredient noix = new Nourriture("Noix", new ArrayList<>(List.of(Contrainte.SALE, Contrainte.FRUIT_COQUE)));
        Ingredient gin = new Alcool("Gin");
        Ingredient vodka = new Alcool("Vodka");

        Recette r1 = new Recette("Gin + Orange", new ArrayList<Ingredient>(List.of(soft, gin)));
        r1.ajouteEtape("Mettre 4cl de Gin");
        r1.ajouteEtape("Mélanger");
        r1.ajouteEtape("Mettre 30cl de Jus d'orange", 2);

        Recette r2 = new Recette("Recette 2", new ArrayList<Ingredient>(List.of(noix, fraise, vodka)));
        r2.ajouteEtape("Mettre Fraise");
        r2.ajouteEtape("Mélanger");
        r2.ajouteEtape("Mettre 30cl de vodka", 2);

        //System.out.println(r2);

        List<Recette> rs = new ArrayList<>(List.of(r1, r2));

        // Créer un objet Scanner pour lire depuis la console
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur d'entrer son nom
        System.out.print("Choisissez une recette : ");
        int count = 1;
        for(Recette r : rs){
            System.out.println( count + " : " + r.getNom());
            count++;
        }
        System.out.println('\n');

        // Lancer la demande dans le terminal
        String choix = scanner.nextLine();

        try {
            int choixInt = Integer.parseInt(choix);

            if (choixInt < 0 || choixInt >= rs.size()+1) {
                System.out.println("Vous n'avez pas choisi un nombre valide.");
            } else {
                System.out.println(rs.get(choixInt-1));
            }
        } catch (NumberFormatException e) {
            System.out.println("Vous n'avez pas choisi un nombre.");
        }

        // Fermer le Scanner pour éviter les fuites de ressources
        scanner.close();

    }

}
