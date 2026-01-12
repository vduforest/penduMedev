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
    // 0
    private int etatPartie;

    /**
     *
     * @param motSecret
     * @param lettresProp
     * @param motCourant
     * @param nbErreurs
     * @param etatPartie
     */
    public JeuDuPendu(String motSecret, ArrayList<String> lettresProp, String motCourant, int nbErreurs, int etatPartie) {
        this.motSecret = motSecret;
        this.lettresProp = lettresProp;
        this.motCourant = motCourant;
        this.nbErreurs = nbErreurs;
        this.etatPartie = etatPartie;
    }
    
    /**
     *
     */
    public JeuDuPendu() {
    }
    
    /**
     *
     * @return
     */
    public String getMotSecret() {
        return motSecret;
    }

    /**
     *
     * @param motSecret
     */
    public void setMotSecret(String motSecret) {
        this.motSecret = motSecret;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getLettresProp() {
        return lettresProp;
    }

    /**
     *
     * @param lettresProp
     */
    public void setLettresProp(ArrayList<String> lettresProp) {
        this.lettresProp = lettresProp;
    }

    /**
     *
     * @return
     */
    public String getMotCourant() {
        return motCourant;
    }

    /**
     *
     * @param motCourant
     */
    public void setMotCourant(String motCourant) {
        this.motCourant = motCourant;
    }

    /**
     *
     * @return
     */
    public int getNbErreurs() {
        return nbErreurs;
    }

    /**
     *
     * @param nbErreurs
     */
    public void setNbErreurs(int nbErreurs) {
        this.nbErreurs = nbErreurs;
    }

    /**
     *
     * @return
     */
    public int getEtatPartie() {
        return etatPartie;
    }

    /**
     *
     * @param etatPartie
     */
    public void setEtatPartie(int etatPartie) {
        this.etatPartie = etatPartie;
    }
    
    /**
     *
     * @param scanner
     * @return
     */
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

    /**
     *
     * @param lettreProp
     * @param maxErreurs
     */
    public void majEtat(String lettreProp, int maxErreurs){
        ConfigJeu config = new ConfigJeu(maxErreurs);

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
                    motCourant=" "+c+" ";
                } else {
                    motCourant=" _ ";
                }
            }
        }
        //on vérifie si motCourant est égale au mot Secret
        if (motCourant.equals(motSecret)){
            etatPartie=2;
        }
        
        else if(nbErreurs==config.getMaxErreurs()){
            etatPartie=1;
        }
        
        
        
        
        
    }
    
    
    
    
}
