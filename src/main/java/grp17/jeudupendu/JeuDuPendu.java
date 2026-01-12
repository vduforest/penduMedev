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

    JeuDuPendu(String motSecret, int nbErreurs) {
        this.motSecret = motSecret;
        this.lettresProp = new ArrayList<>();
        this.motCourant = "";
        for (int i = 0; i < motSecret.length(); i++){
            this.motCourant+="_";
        }
        this.nbErreurs = nbErreurs;
        this.etatPartie = 0;
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
     * @param lettre
     */
    public void proposerLettre(String lettre) {

        // Sécurité : partie terminée
        if (etatPartie != 0) {
            return;
        }

        // Normalisation
        lettre = lettre.toUpperCase();

        // Lettre déjà proposée → aucune pénalité
        if (lettresProp.contains(lettre)) {
            return;
        }

        lettresProp.add(lettre);

        boolean lettreTrouvee = false;

        // StringBuilder pour modifier motCourant
        StringBuilder nouveauMotCourant = new StringBuilder(motCourant);

        for (int i = 0; i < motSecret.length(); i++) {
            if (String.valueOf(motSecret.charAt(i)).equals(lettre)) {
                nouveauMotCourant.setCharAt(i, lettre.charAt(0));
                lettreTrouvee = true;
            }
        }

        // Mise à jour du mot courant
        motCourant = nouveauMotCourant.toString();

        // Si lettre absente → erreur
        if (!lettreTrouvee) {
            nbErreurs--;
        }

        // Mise à jour de l'état global
        majEtat();
    }

    /**
     * Méthode privée qui permet de 
     * @param lettreProp
     * @param maxErreurs
     */
    private void majEtat() {

        // Victoire : plus aucun '_' dans le mot courant
        if (!motCourant.contains("_")) {
            etatPartie = 2;
            return;
        }

        // Défaite : plus d'erreurs restantes
        if (nbErreurs <= 0) {
            etatPartie = 1;
            return;
        }

        // Sinon, la partie continue
        etatPartie = 0;
    }

}
