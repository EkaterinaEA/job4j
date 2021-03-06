package ru.job4j;

public class Fit {

    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(180);
        double woman = womanWeight(170);
        System.out.println("Man 180 is " + man);
        System.out.println("Man 170 is " + woman);
    }

}
