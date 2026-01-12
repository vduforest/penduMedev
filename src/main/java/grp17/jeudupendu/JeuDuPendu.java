/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package grp17.jeudupendu;

import java.util.ArrayList;

/**
 *
 * @author vdufo
 */
public class JeuDuPendu {

    private String motSecret;
    private ArrayList<String> lettresProp;
    private String motCourant;
    private int nbErreurs;
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
     * Constructeur d'une partie à partir d'un mot secret et d'un nbr d'erreurs max
     * @param motSecret le mot à trouver dans la partie
     * @param nbErreurs le nombre d'erreurs max
     */
    public JeuDuPendu(String motSecret, int nbErreurs) {
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
     * Getter motSecret
     * @return motSecret
     */
    public String getMotSecret() {
        return motSecret;
    }

    /**
     * Setter motSecret
     * @param motSecret
     */
    public void setMotSecret(String motSecret) {
        this.motSecret = motSecret;
    }

    /**
     * Getter lettresProp
     * @return lettresProp
     */
    public ArrayList<String> getLettresProp() {
        return lettresProp;
    }

    /**
     * Setter lettresProp
     * @param lettresProp
     */
    public void setLettresProp(ArrayList<String> lettresProp) {
        this.lettresProp = lettresProp;
    }

    /**
     * getter motCourant
     * @return motCourant
     */
    public String getMotCourant() {
        return motCourant;
    }

    /**
     * Setter motCourant
     * @param motCourant
     */
    public void setMotCourant(String motCourant) {
        this.motCourant = motCourant;
    }

    /**
     * Getter NbErreurs
     * @return nbErreurs
     */
    public int getNbErreurs() {
        return nbErreurs;
    }

    /**
     * Setter NbErreurs
     * @param nbErreurs
     */
    public void setNbErreurs(int nbErreurs) {
        this.nbErreurs = nbErreurs;
    }

    /**
     * Getter EtatPartie
     * @return etatPartie
     */
    public int getEtatPartie() {
        return etatPartie;
    }

    /**
     * Setter EtatPartie
     * @param etatPartie
     */
    public void setEtatPartie(int etatPartie) {
        this.etatPartie = etatPartie;
    }

    /**
     * Méthode qui vérifie la lettre qui a été proposée par le joueur
     * Elle vérifie sa présence dans le mot secret ou non
     * @param lettre la lettre proposée
     */
    public void proposerLettre(String lettre) {

        // On vérifie que la partie n'est pas terminée
        if (etatPartie != 0) {
            return;
        }

        // Normalisation
        lettre = lettre.toUpperCase();

        // Si la lettre a déjà été proposé, on passe au tour suivant
        if (lettresProp.contains(lettre)) {
            return;
        }
        
        // Si la lettre est invalide, on passe aussi au tour suivant
        // Vérifier que c'est une seule lettre alphabétique
        if (lettre.length() != 1 || !lettre.matches("[A-Z]")) {
            return;
        }

        
        // Sinon on l'ajoute dans la liste des lettres proposées
        lettresProp.add(lettre);

        boolean lettreTrouvee = false;

        // StringBuilder pour modifier motCourant
        StringBuilder nouveauMotCourant = new StringBuilder(motCourant);
        
        //On regarde si la lettre fait partie du mot secret
        for (int i = 0; i < motSecret.length(); i++) {
            if (String.valueOf(motSecret.charAt(i)).equals(lettre)) {
                nouveauMotCourant.setCharAt(i, lettre.charAt(0));
                lettreTrouvee = true;
            }
        }

        // Mise à jour du mot courant
        motCourant = nouveauMotCourant.toString();

        // Si la lettre est absente alors le joueur a une erreur en plus
        if (!lettreTrouvee) {
            nbErreurs--;
        }

        // Mise à jour de l'état de la partie
        majEtat();
    }

    /**
     * Méthode privée qui permet de mettre à jour l'état de la partie,
     * Si le nbErreurs est négatif alors la partie est perdue,
     * Si le le mot courant ne contient plus de "_", alors la partie est gagné
     * Sinon, la partie continue
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
