package ru.job4j;

public class Converter {

    public static double rubleToEuro(int value) {
        return value / 70;
    }

    public static double rubleToDollar(int value) {
        return value / 60;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static void main(String[] args) {
        double euro = rubleToEuro(140);
        double dollar = rubleToDollar(3874);
        int rubleFromDollar = dollarToRuble(845);
        int rubleFromEuro = euroToRuble(45894);
        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("3874 rubles are " + dollar + " dollars.");
        System.out.println("845 dollars are " + rubleFromDollar + " rubles.");
        System.out.println("45894 euro are " + rubleFromEuro + " rubles.");

        int in = 140;

        // method testing
        System.out.println("140 rubles are 2 euro. Test result : " + (rubleToEuro(in) == 2));
        System.out.println("120 rubles are 2 dollars. Test result : " + (rubleToDollar(in) == 2));
        System.out.println("140 dollars are 8400 rubles. Test result : " + (dollarToRuble(in) == 8400));
        System.out.println("140 euro are 9800 rubles. Test result : " + (euroToRuble(in) == 9800));
    }
}
