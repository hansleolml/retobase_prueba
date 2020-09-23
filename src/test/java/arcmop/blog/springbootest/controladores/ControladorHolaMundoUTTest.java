/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arcmop.blog.springbootest.controladores;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mastermind
 */
public class ControladorHolaMundoUTTest {

    public ControladorHolaMundoUTTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saludar method, of class ControladorHolaMundo.
     */
    @Test
    public void testSaludar() {
        System.out.println("saludar");
        Integer sum01 = 10;
        Integer sum02 = 20;
        ControladorHolaMundo instance = new ControladorHolaMundo();
        Assert.assertNotNull(instance.saludar(sum01, sum02));
        Assert.assertEquals(30, Integer.parseInt(String.valueOf(instance.saludar(sum01, sum02).get("resultado"))));
    }

}
