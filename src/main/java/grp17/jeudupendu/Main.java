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
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        char lettre = proposerLettre(scanner);
        System.out.println("Vous avez entré la lettre : " + lettre);
        scanner.close();
        
        
    }
    
}
