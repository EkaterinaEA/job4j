package ru.job4j;

public class SqArea {

    public static double square(int p, int k) {
        double L = (p * k) / (2* (1 + k));
        double h = L / k;
        return L * h;
    }

    public static void main(String[] args) {
        double result1 = square(4, 1);
        double result2 = square(6, 2);
        System.out.println(" p = 4, k = 1, s = 1, real = " + result1);
        System.out.println(" p = 6, k = 2, s = 2, real = " + result2);
    }
}
