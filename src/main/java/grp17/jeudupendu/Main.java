/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grp17.jeudupendu;

import java.util.Scanner;

/**
 *
 * @author rapha
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TextInterface ui = new TextInterface();

        System.out.println("JEU DU PENDU");

        // Choix du mode de Jeu
        int mode = ui.demanderMode();

        // Si le mode ==1, on charge le dictionnaire
        Dictionnaire dico = null;
        if (mode == 1) {
            try {
                dico = new Dictionnaire("mots.txt");
            } catch (Dictionnaire.DictionnaireException e) {
                System.out.println("Erreur lors du chargement du dictionnaire : " + e.getMessage());
                scanner.close();
                return;
            }
        }

        // Dans tous les cas on demande le mot secret
        String motSecret = ui.choisirMot(mode, dico);

        // 4️⃣ Paramétrage du nombre maximal d'erreurs
        int nbErreurs = 0;
        while (nbErreurs <= 0) {
            System.out.print("Nombre maximal d'erreurs autorisées : ");
            String input = scanner.nextLine().trim();
            try {
                nbErreurs = Integer.parseInt(input);
                if (nbErreurs <= 0) {
                    System.out.println("Le nombre doit être strictement positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un entier valide.");
            }
        }

        // Création du jeu (et donc de la partie)
        JeuDuPendu jeu = new JeuDuPendu(motSecret, nbErreurs);

        // Lancement de l'interface de la partie
        ui.lancerPartie(jeu);

        scanner.close();
    } 
}
