/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grp17.jeudupendu;

/**
 *
 * @author rapha
 */
public class ConfigJeu {
    private int maxErreurs;

    /**
     *
     * @param maxErreurs
     */
    public ConfigJeu(int maxErreurs) {
        this.maxErreurs = maxErreurs;
    }

    /**
     *
     * @return
     */
    public int getMaxErreurs() {
        return maxErreurs;
    }

    /**
     *
     * @param maxErreurs
     */
    public void setMaxErreurs(int maxErreurs) {
        this.maxErreurs = maxErreurs;
    }
}
