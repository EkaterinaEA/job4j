package ru.job4j.loop;

public class Factorial {

    public static int calc(int n) {

        int result = 1;

        if (n == 0 || n == 1) {

        } else for (int i = 1; i <= n; i++) {
            result = result*i;
        }
        return result;
    }

}
