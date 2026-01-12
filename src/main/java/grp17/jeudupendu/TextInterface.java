/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grp17.jeudupendu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe qui gère les différents affichages dans la console
 * @author vdufo
 */
public class TextInterface {
    
    /**
     * Méthode qui gère l'affichage des différents tours de jeu
     * @param jeu la partie en cours
     */
    public void lancerPartie(JeuDuPendu jeu){
        while(jeu.getEtatPartie()==0){
            // Afficher l'état courant du mot 
            afficherEtat(jeu);
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
    
    /**
     * Méthode qui affiche l'état courant du mot, exemple : "_A__E"
     * @param jeu la partie en cours
     */
    public void afficherEtat(JeuDuPendu jeu){
        String etat = jeu.getEtatCourant();
        System.out.println("Mot à deviner : "+etat);
    }
    
    /**
     * Méthode qui permet d'afficher les différentes lettres
     * @param jeu la partie en cours
     */
    public void afficherLettresProposees(JeuDuPendu jeu){
        ArrayList<char> lettresProp = jeu.getLettresProp();
        String aAfficher = "Lettres déjà proposées : ";
        for (char lettre:lettresProp){
            aAfficher += "lettre, ";
        }
        System.out.println(aAfficher);
    }
    
    /**
     * Méthode qui demande au joueur quel lettre il souhaite essayé dans le mot
     * @return la lettre rentré dans la console par le joueur
     */
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
    
    /**
     * Méthode qui permet d'afficher le message de fin de partie, selon la victoire ou la défaite
     * @param jeu la partie qui vient de se terminer
     */
    public void afficherFin(JeuDuPendu jeu){
        int etat = jeu.getEtatPartie();
        if (etat==1){
            System.out.println("Félicitations ! Vous avez trouvé le mot : "+jeu.getMotSecret());
        }
        if (etat==2){
            System.out.println("Vous avez perdu, le mot était : "+jeu.getMotSecret());
            
        }
    }
    
    /**
     * Méthode qui permet de choisir le mot à deviner
     * Si la partie se joue à un joueur, on le tire aléatoirement d'un dictionnaire,
     * si la partie se joue à 2 joueurs, c'est un des deux joueurs qui choisit le mot
     * @param mode 1 si le joueur joue tout seul, 2 si la partie se fait à 2
     * @param dico le dictionnaire des mots
     * @return le mot choisi 
     */
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


