package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Main {

    public static String ReplacementForTheLagrangeMethod(int k,double x){
        double tmp = 1;
        double sum = 1;
        double eps = pow(10.0,-k);

        for(int i = 0; abs(tmp) >= eps;i++){
            tmp *= (double)(x * (1 - 2 * i)) / (2 * i + 2);
            sum += tmp;
        }

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k);
        return formatter.format(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k;
        System.out.println("Введите k: ");
        k = sc.nextInt();
        System.out.println(ReplacementForTheLagrangeMethod(k,0.34));
    }
}