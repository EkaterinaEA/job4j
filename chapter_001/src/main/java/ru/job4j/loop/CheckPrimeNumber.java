package ru.job4j.loop;

public class CheckPrimeNumber {

    public static boolean check(int finish) {
        boolean prime = false;
        for(int i = 2; i < Math.sqrt(finish); i++){
            if (finish % i != 0) {
                prime = true;
                break;
            }
        }
        return prime;
    }

}
