/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package grp17.jeudupendu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vdufo
 */
public class JeuDuPendu {
    // A N I M A U X
    private String motSecret;
    // ["A", "X"]
    private ArrayList<String> lettresProp;
    // " _ _ _ _  A _ X"
    private String motCourant;
    private int nbErreurs;
    
    private int etatPartie;
    
    
    
    public void JeuDuPendu() {
    }
    
    public static String proposerLettre(Scanner scanner){
        // on demande une lettre au joueur
        String input;
        
        while (true) {
            try {
            System.out.print("Entrez une lettre : ");
            input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                throw new IllegalArgumentException("L'entrée ne peut pas être vide.");
            }
            
            if (input.length() != 1) {
                throw new IllegalArgumentException("Vous devez entrer exactement une lettre.");
            }
            
            char lettreTest = input.charAt(0);
            
            if (!Character.isLetter(lettreTest)) {
                throw new IllegalArgumentException("Ce n'est pas une lettre.");
            }
            
            return input;
            
            } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
            
        }
        
        
        
    }
    
    public void majEtat(String lettreProp){
        // on regarde si cette lettre est déjà dans la liste des lettres proposees et n'est pas dans le mot secret
        if (!lettresProp.contains(lettreProp) && !motSecret.contains(lettreProp)){
            nbErreurs+=1;
            //on rajoute la lettre proposée
            lettresProp.add(lettreProp);
        }
        //le fait de donner une lettre déjà proposée ne compte pas comme une erreur en plus
        
        else if (motSecret.contains(lettreProp)){
            //maj du mot courant, on revele les lettres egales à la lettre proposee
            for (char c : motSecret.toCharArray()) {
                if (lettresProp.contains(c)) {
                    
                } else {
                    
                }
            }
        }
        
        
        //on vérifie si motCourant est égale au mot Secret
        
        
        
        
        
    }
    
    
    
    
}
