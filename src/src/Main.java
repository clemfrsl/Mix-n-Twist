import global.Contrainte;
import global.Recette;
import ingredient.Alcool;
import ingredient.Ingredient;
import ingredient.Nourriture;
import ingredient.Soft;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /** Création des objets **/

        Ingredient orange = new Soft(1, "Jus d'Orange", new ArrayList<>(List.of(Contrainte.SUCREE)));
        Ingredient lait = new Soft(2, "Lait", new ArrayList<>(List.of(Contrainte.SUCREE, Contrainte.LACTOSE)));
        Ingredient pomme = new Nourriture(3, "Pomme", new ArrayList<>(List.of(Contrainte.SUCREE, Contrainte.FRUCTOSE)));
        Ingredient noix = new Nourriture(4, "Noix", new ArrayList<>(List.of(Contrainte.SALE, Contrainte.FRUIT_COQUE)));
        Ingredient gin = new Alcool(6, "Gin");
        Ingredient vodka = new Alcool(5, "Vodka");
        Ingredient biere = new Alcool(7, "IPA", new ArrayList<>(List.of(Contrainte.GLUTEN)));

        Recette r1 = new Recette(1, "Gin + Orange", new ArrayList<>(List.of(orange, gin)));
        r1.ajouteEtape("Mettre 4cl de Gin");
        r1.ajouteEtape("Mélanger");
        r1.ajouteEtape("Mettre 30cl de Jus d'orange", 2);

        Recette r2 = new Recette(2, "Classique Vodka", new ArrayList<>(List.of(noix, pomme, vodka)));
        r2.ajouteEtape("Mettre Fraise");
        r2.ajouteEtape("Mélanger");
        r2.ajouteEtape("Mettre 30cl de vodka", 2);

        Recette r3 = new Recette(3, "Gin Power", new ArrayList<>(List.of(pomme, lait, gin)));
        r3.ajouteEtape("Mettre Fraise et 10cl de lait");
        r3.ajouteEtape("Mélanger");
        r3.ajouteEtape("Mettre 10cl de gin");

        Recette r4 = new Recette(4, "IPA revisité", new ArrayList<>(List.of(biere, orange, pomme)));
        r4.ajouteEtape("Ajouter ingrédients");
        r4.ajouteEtape("Mélanger");

        Recette r5 = new Recette(5, "Salé !!", new ArrayList<>(List.of(noix, orange, lait)));
        r5.ajouteEtape("Ajouter ingrédients");
        r5.ajouteEtape("Mélanger");

        Recette r6 = new Recette(6, "RIP !!", new ArrayList<>(List.of(gin, vodka, biere)));
        r5.ajouteEtape("Mettre toutes les alcools selon vos prefs");
        r5.ajouteEtape("Mélanger");
        r5.ajouteEtape("CUL SEC !!!!");


        Contrainte[] allContraintes = Contrainte.values();

        /** Créer un objet Scanner pour lire depuis la console **/
        Scanner scanner = new Scanner(System.in);

        // TODO - Debut de la demande de la console
        boolean quitter = false;
        while (!quitter) {

            List<Recette> recettes = new ArrayList<>(List.of(r1, r2, r3, r4, r5, r6));

            /** Utilisation d'un filtre ? **/

            System.out.print("Voulez-vous utiliser un filtre ? (y/n) (ou tapez 'q' pour quitter) : ");
            String choix_filtre = scanner.nextLine();
            if(Objects.equals(choix_filtre, "y")){
                System.out.print("Lequel ? : \n");
                int count = 1;
                for(Contrainte c : allContraintes){
                    System.out.println(count + " : " + c);
                    count++;
                }
                System.out.println("0 : Quitter\n");

                choix_filtre = scanner.nextLine();
                if(!Objects.equals(choix_filtre, "0")){
                    recettes = Utilisation.filtrer(recettes, List.of(allContraintes[Integer.parseInt(choix_filtre)-1]));
                }
            }
            if(choix_filtre.equals("q")){
                quitter = true;
                break;
            }


            /** Recherche d'un recette **/

            System.out.print("Choisissez une recette (ou tapez 'q' pour quitter) : \n");
            int count = 1;

            for (Recette r : recettes) {
                System.out.println(count + " : " + r.getNom());
                count++;
            }
            System.out.println("0 : Quitter\n");

            // Lancer la demande dans le terminal
            String choix = scanner.nextLine();

            try {
                int choixInt = Integer.parseInt(choix);

                if (choixInt == 0) {
                    continue;
                } else if (choixInt < 1 || choixInt > recettes.size()) {
                    System.out.println("Vous n'avez pas choisi un nombre valide.");
                } else {
                    System.out.println(recettes.get(choixInt - 1));
                }
            } catch (NumberFormatException e) {
                System.out.println("Vous n'avez pas choisi un nombre.");
            }

            /** La logique pour revenir en arrière ou refaire une demande **/

            System.out.print("Voulez-vous revenir en arrière ou refaire une demande ? (y/n) : ");
            String reponse = scanner.nextLine().toLowerCase();

            if (reponse.equals("non") || reponse.equals("n")) {
                quitter = true;
                break;
            }
        }

        /** Fermer le Scanner pour éviter les fuites de ressources **/
        scanner.close();
    }

}
