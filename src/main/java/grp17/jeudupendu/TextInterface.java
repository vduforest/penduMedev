/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grp17.jeudupendu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vdufo
 */
public class TextInterface {
    
    private ConfigJeu config; //pour récupérer le nombre d'erreurs max
    
    public void lancerPartie(JeuDuPendu jeu){
        while(jeu.getEtatPartie()==0){
            // Afficher l'état courant du mot 
            afficherEtat(jeu);
            // Afficher la visualisation
            afficherDessin(jeu.getErreurRest());
            // Afficher les lettres déjà proposées
            afficherLettresProposees(jeu);
            // Demander la lettre à entrer
            char c = demanderLettre();
            // Passe la lettre à la partie
            jeu.proposerlettre(c);
        }
        
        // Afficher la fin du jeu selon victoire ou défaite
        afficherFin(jeu);
    }
    
    public void afficherEtat(JeuDuPendu jeu){
        String etat = jeu.getEtatCourant();
        System.out.println("Mot à deviner : "+etat);
    }
    
    public void afficherDessin(int erreurs){
        
    }
    
    public void afficherLettresProposees(JeuDuPendu jeu){
        ArrayList<char> lettresProp = jeu.getLettresProp();
        String aAfficher = "Lettres déjà proposées : ";
        for (char lettre:lettresProp){
            aAfficher += "lettre, ";
        }
        System.out.println(aAfficher);
    }
    
    public char demanderLettre() {
    while (true) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Proposez une lettre : ");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Entrée invalide. Veuillez entrer une seule lettre.");
            continue;
        }

        return input.charAt(0);
        }
    }
    
    public void afficherFin(JeuDuPendu jeu){
        int etat = jeu.getEtatPartie();
        if (etat==1){
            System.out.println("Félicitations ! Vous avez trouvé le mot : "+jeu.getMotSecret());
        }
        if (etat==2){
            System.out.println("Vous avez perdu, le mot était : "+jeu.getMotSecret());
            
        }
    }
    
    public String choisirMot(int mode, Dictionnaire dico) {
    if (mode == 1) {
        return dico.getMotAleatoire();
    } else {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Joueur 2, regardez ailleurs !");
        System.out.print("Joueur 1, entrez le mot secret : ");
        String mot = scanner.nextLine().trim().toUpperCase();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        return mot;
    }
}

}


