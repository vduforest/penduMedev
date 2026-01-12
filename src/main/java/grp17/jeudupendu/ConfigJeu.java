/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grp17.jeudupendu;

/**
 * Classe qui permet de modifier les configurations d'une partie, ici le nombre max d'erreurs autorisées.
 * @author rapha
 */
public class ConfigJeu {
    private final int maxErreurs;

    /**
     * Constructeur ConfigJeu
     * @param maxErreurs
     */
    public ConfigJeu(int maxErreurs) {
        this.maxErreurs = maxErreurs;
    }

    /**
     * Getter maxErreurs
     * @return maxErreurs
     */
    public int getMaxErreurs() {
        return maxErreurs;
    }
}
