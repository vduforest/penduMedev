/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package grp17.jeudupendu;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vdufo
 */
public class JeuDuPenduTest {
    
    public JeuDuPenduTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test de la transition de l'état partie en cours vers l'état de victoire
     */
    @Test
    public void testTransitionEtatVictoire() {
        JeuDuPendu jeu = new JeuDuPendu("HI", 5);

        // Partie en cours initialement
        assertEquals(0, jeu.getEtatPartie());

        jeu.proposerLettre("H");
        assertEquals(0, jeu.getEtatPartie()); // encore en cours

        jeu.proposerLettre("I");
        assertEquals(2, jeu.getEtatPartie()); // victoire
    }

    /**
     * Test de la transition de l'état partie en cours vers l'état de défaite
     */
    @Test
    public void testTransitionEtatDefaite() {
        JeuDuPendu jeu = new JeuDuPendu("HI", 2);

        assertEquals(0, jeu.getEtatPartie());
        jeu.proposerLettre("A"); // erreur 1
        assertEquals(0, jeu.getEtatPartie());
        jeu.proposerLettre("B"); // erreur 2
        assertEquals(1, jeu.getEtatPartie()); // perdue
    }

    /**
     * Test si plusieurs lettres sont répétées alors elles sont bien mises en une seule fois
     */
    @Test
    public void testLettresRepetees() {
        JeuDuPendu jeu = new JeuDuPendu("ANNA", 5);

        jeu.proposerLettre("A");
        assertEquals("A__A", jeu.getMotCourant());
        assertEquals(5, jeu.getNbErreurs());

        // proposer une lettre déjà proposée ne change rien
        int erreursAvant = jeu.getNbErreurs();
        jeu.proposerLettre("A");
        assertEquals(erreursAvant, jeu.getNbErreurs());
        assertEquals("A__A", jeu.getMotCourant());
    }

    /**
     * Test si des lettres sont invalides
     */
    @Test
    public void testLettresInvalides() {
        JeuDuPendu jeu = new JeuDuPendu("TEST", 5);

        // lettre invalide (non alphabétique)
        int erreursAvant = jeu.getNbErreurs();
        jeu.proposerLettre("1");
        // Comme le code actuel ne gère pas explicitement les invalides, on peut tester que nbErreurs reste identique
        assertEquals(erreursAvant, jeu.getNbErreurs());
        assertEquals("____", jeu.getMotCourant());

        // lettre correcte continue à fonctionner
        jeu.proposerLettre("T");
        assertEquals("T__T", jeu.getMotCourant());
    }

    /**
     * Test si problème avec les règles principales
     */
    @Test
    public void testNonRegressionReglesPrincipales() {
        JeuDuPendu jeu = new JeuDuPendu("AB", 3);

        // lettre correcte
        jeu.proposerLettre("A");
        assertEquals("A_", jeu.getMotCourant());
        assertEquals(3, jeu.getNbErreurs());

        // lettre incorrecte
        jeu.proposerLettre("Z");
        assertEquals(2, jeu.getNbErreurs());

        // lettre déjà proposée ne réduit pas les erreurs
        jeu.proposerLettre("A");
        assertEquals(2, jeu.getNbErreurs());
    }

    /**
     * Test Victoire si un mot contient une seule lettre
     */
    @Test
    public void testVictoireMotUnique() {
        JeuDuPendu jeu = new JeuDuPendu("X", 1);

        assertEquals(0, jeu.getEtatPartie());
        jeu.proposerLettre("X");
        assertEquals(2, jeu.getEtatPartie());
    }

    /**
     * Test defaite si le nombre d'erreurs max a été atteint
     */
    @Test
    public void testDefaiteNombreErreursMax() {
        JeuDuPendu jeu = new JeuDuPendu("Y", 1);

        assertEquals(0, jeu.getEtatPartie());
        jeu.proposerLettre("Z"); // erreur fatale
        assertEquals(1, jeu.getEtatPartie());
    }

    /**
     * Test si le mot courant est coorect ou non
     */
    @Test
    public void testMotCourantCorrect() {
        JeuDuPendu jeu = new JeuDuPendu("JAVA", 5);

        jeu.proposerLettre("J");
        assertEquals("J___", jeu.getMotCourant());

        jeu.proposerLettre("A");
        assertEquals("JA_A", jeu.getMotCourant());

        jeu.proposerLettre("V");
        assertEquals("JAVA", jeu.getMotCourant());
        assertEquals(2, jeu.getEtatPartie()); // victoire
    }

}
