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
public class DictionnaireTest {
    
    public DictionnaireTest() {
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
     * Test of Dictionnaire method, of class Dictionnaire.
     */
    @Test
    public void testDictionnaire(){
        System.out.println("Création Dictionnaire");
        
    }
    
    /**
     * Test of getMotAleatoire method, of class Dictionnaire.
     */
    @Test
    public void testGetMotAleatoire() {
        System.out.println("getMotAleatoire");
        Dictionnaire instance = null;
        String expResult = "";
        String result = instance.getMotAleatoire();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
