package ru.job4j;

public class Point {

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        double result = distance(1, 2, 3, 4);
        System.out.println("result (1, 2) to (3, 4): " + result);
    }

}
