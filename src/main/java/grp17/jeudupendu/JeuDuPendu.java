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
     * Constructeur du Jeu Du Pendu
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
    public static String proposerLettre(String input){
        // on demande une lettre au joueur
        
        
        while (true) {
            try {
            
            
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
    }
}
