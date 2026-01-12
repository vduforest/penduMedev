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
    private ArrayList<Character> lettresProp;
    // " _ _ _ _  A _ X"
    private String etatCourant;
    private int nbErreurs;
    
    private int etatPartie;
    
    
    
    public void JeuDuPendu() {
    }
    
    public static char proposerLettre(Scanner scanner){
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
            
            char lettre = input.charAt(0);
            
            if (!Character.isLetter(lettre)) {
                throw new IllegalArgumentException("Ce n'est pas une lettre.");
            }
            
            return lettre;
            
            } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
            
        }
        
        
        
    }
    
    public void majEtat(char lettreProp){
        // on regarde si cette lettre est déjà dans la liste des lettres proposees
        if (!lettresProp.contains(lettreProp)){
            nbErreurs+=1;
            //on rajoute la lettre proposée
            lettresProp.add(lettreProp);
        }
        //le fait de donner une lettre déjà proposée ne compte pas comme une erreur en plus
        
        
        
        
        
        
    }
    
    
    
    
}
