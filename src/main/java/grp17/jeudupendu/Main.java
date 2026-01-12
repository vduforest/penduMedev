/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grp17.jeudupendu;

import static grp17.jeudupendu.JeuDuPendu.proposerLettre;
import java.util.Scanner;

/**
 *
 * @author rapha
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // choix du mode
        Scanner scanner = new Scanner(System.in);
        String mode = demanderMode(scanner);
        System.out.println("Vous avez choisi le mode : " + mode);
        scanner.close();
        
        if ((mode!=1)&&(mode!=0)){
            System.out.println("erreur pas le bon mode");
        }
        
        // choix de la lettre
        Scanner scanner1 = new Scanner(System.in);
        String lettre = proposerLettre(scanner1);
        System.out.println("Vous avez entré la lettre : " + lettre);
        scanner.close();
        
        
    }
    
}
