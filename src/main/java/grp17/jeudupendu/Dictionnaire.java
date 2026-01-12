/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grp17.jeudupendu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe permettant de gérer l'utilisation d'un dictionnaire de mot si le
 * joueur joue tout seul
 *
 * @author vdufo
 */
public class Dictionnaire {

    private final List<String> mots;
    private final Random random;

    /**
     * Constructeur à partir d'un chemin Fichier
     * @param cheminFichier
     * @throws DictionnaireException si aucun mot n'est récupéré car aucun n'est valide
     */
    public Dictionnaire(String cheminFichier) throws DictionnaireException {
        this.mots = new ArrayList<>();
        this.random = new Random();
        chargerFichier(cheminFichier);

        if (mots.isEmpty()) {
            throw new DictionnaireException("Le dictionnaire ne contient aucun mot valide.");
        }
    }

    /**
     * Méthode privée qui permet de charger et lire un fichier
     * @param cheminFichier le chemin du fichier à ouvrir
     * @throws DictionnaireException si le fichier ne peut pas être lu
     */
    private void chargerFichier(String cheminFichier) throws DictionnaireException {
        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                String mot = ligne.trim();

                if (estMotValide(mot)) {
                    mots.add(mot.toUpperCase());
                }
            }
        } catch (IOException e) {
            throw new DictionnaireException("Impossible de lire le fichier : " + cheminFichier);
        }
    }
    
    /**
     * Méthode privée qui vérifie la validité du mot qui a été trouvé
     * @param mot le mot trouvé
     */
    private boolean estMotValide(String mot) {
        return !mot.isEmpty() && mot.matches("[a-zA-Z]+");
    }

    /**
     * Méthode qui tire un mot de manière aléatoire parmi tous les mots trouvés dans le fichier
     * @return un mot aléatoire
     */
    public String getMotAleatoire() {
        int index = random.nextInt(mots.size());
        return mots.get(index);
    }

    /**
     * Classe publique définie ici pour définir l'exception des dictionnaires
     */
    public static class DictionnaireException extends Exception {

        /**
         * 
         * @param message
         */
        public DictionnaireException(String message) {
            super(message);
        }
    }

}
