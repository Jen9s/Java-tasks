package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static java.lang.Math.sqrt;
import static org.example.Main.ReplacementForTheLagrangeMethod;

class MainTest {
    @Test
    public void FirstTest(){
        double x = 0.1;
        int k = 3;
        double expected = sqrt(1 + x);
        double result = ReplacementForTheLagrangeMethod(k,x);

        Assertions.assertEquals(expected, result, k);
    }
    @Test
    public void SecondTest(){
        double x = -0.999;
        int k = 5;
        double expected = sqrt(1 + x);
        double result = ReplacementForTheLagrangeMethod(k,x);

        Assertions.assertEquals(expected, result, k);
    }
    @Test
    public void ThirdTest(){
        double x = 0.3333334;
        int k = 7;
        double expected = sqrt(1 + x);
        double result = ReplacementForTheLagrangeMethod(k,x);

        Assertions.assertEquals(expected, result, k);
    }
}