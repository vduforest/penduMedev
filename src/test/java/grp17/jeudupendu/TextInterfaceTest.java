/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package grp17.jeudupendu;

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
public class TextInterfaceTest {
    
    public TextInterfaceTest() {
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
     * Test of lancerPartie method, of class TextInterface.
     */
    @Test
    public void testLancerPartie() {
        System.out.println("lancerPartie");
        JeuDuPendu jeu = null;
        TextInterface instance = new TextInterface();
        instance.lancerPartie(jeu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherEtat method, of class TextInterface.
     */
    @Test
    public void testAfficherEtat() {
        System.out.println("afficherEtat");
        JeuDuPendu jeu = null;
        TextInterface instance = new TextInterface();
        instance.afficherEtat(jeu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherLettresProposees method, of class TextInterface.
     */
    @Test
    public void testAfficherLettresProposees() {
        System.out.println("afficherLettresProposees");
        JeuDuPendu jeu = null;
        TextInterface instance = new TextInterface();
        instance.afficherLettresProposees(jeu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of demanderLettre method, of class TextInterface.
     */
    @Test
    public void testDemanderLettre() {
        System.out.println("demanderLettre");
        TextInterface instance = new TextInterface();
        char expResult = ' ';
        char result = instance.demanderLettre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherFin method, of class TextInterface.
     */
    @Test
    public void testAfficherFin() {
        System.out.println("afficherFin");
        JeuDuPendu jeu = null;
        TextInterface instance = new TextInterface();
        instance.afficherFin(jeu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choisirMot method, of class TextInterface.
     */
    @Test
    public void testChoisirMot() {
        System.out.println("choisirMot");
        int mode = 0;
        Dictionnaire dico = null;
        TextInterface instance = new TextInterface();
        String expResult = "";
        String result = instance.choisirMot(mode, dico);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
