package org.example;

import java.text.NumberFormat;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Main {

    public static double ReplacementForTheLagrangeMethod(int k,double x){
        double tmp = 1;
        double sum = 1;
        double eps = pow(10.0,-k);

        for(int i = 0; abs(tmp) >= eps;i++){
            tmp *= (double)(x * (1 - 2 * i)) / (2 * i + 2);
            sum += tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(ReplacementForTheLagrangeMethod(3,0.1));
    }
}