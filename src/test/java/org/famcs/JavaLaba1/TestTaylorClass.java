/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.famcs.JavaLaba1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
/**
 *
 * @author supre
 */
public class TestTaylorClass 
{
    @Test
     public void testSimpleTaylor() 
    {
        double x = 0.25;
        int k = 5;
        double eps = Math.pow(10, -k);

        double actual = TaylorClass.simpleTaylor(x, k);
        double expected = Math.log (1-x);

        assertEquals(expected, actual, eps, "Значения должны совпадать с точностью до 10 в -5 степени.");

        x = 1;
        actual = TaylorClass.simpleTaylor(x, k);
        expected = Math.log (1-x);
        assertEquals(expected, actual, eps, "Значения должны совпадать с точностью до 10 в -5 степени.");

    }

    @Test
     public void testBigTaylor() 
    {
        double x = 0.25;
        long k = 5;
        double eps = Math.pow(10, -k);

        double actual = TaylorClass.BigTaylor(x, k);
        double expected = Math.log (1-x);

        assertEquals(expected, actual, eps, "Значения должны совпадать с точностью до 10 в -5 степени.");
        
        x = 1;
        actual = TaylorClass.BigTaylor(x, k);
        expected = Math.log (1-x);
        assertEquals(expected, actual, eps, "Значения должны совпадать с точностью до 10 в -5 степени.");

    }

}