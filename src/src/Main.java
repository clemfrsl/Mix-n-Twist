import global.Contrainte;
import global.Filtre;
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

        Recette r3 = new Recette("Gin Power", new ArrayList<Ingredient>(List.of(fraise, lait, gin)));
        r3.ajouteEtape("Mettre Fraise et 10cl de lait");
        r3.ajouteEtape("Mélanger");
        r3.ajouteEtape("Mettre 10cl de gin");

        List<Contrainte> allContraintes = new ArrayList<>(List.of(Contrainte.ALCOOLISE, Contrainte.LACTOSE, Contrainte.SUCREE, Contrainte.SUCREE, Contrainte.FRUIT_COQUE));

        // Créer un objet Scanner pour lire depuis la console
        Scanner scanner = new Scanner(System.in);

        // TODO - Debut de la demande de la console
        boolean quitter = false;
        while (!quitter) {

            List<Recette> recettes = new ArrayList<>(List.of(r1, r2, r3));

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
                if(choix_filtre == "0"){
                    continue;
                }
                else{
                    Filtre filtre = new Filtre(new ArrayList<Contrainte>(List.of(allContraintes.get(Integer.parseInt(choix_filtre)-1))));
                    recettes = filtre.filtrer(recettes);
                }
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
                    quitter = true;
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
            }
        }

        // Fermer le Scanner pour éviter les fuites de ressources
        scanner.close();

    }

}
