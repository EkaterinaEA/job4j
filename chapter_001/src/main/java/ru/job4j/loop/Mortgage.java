package ru.job4j.loop;

public class Mortgage {

    public int year(double amount, int salary, double percent) {
        int year = 1;
        while (salary < (amount + amount * percent / 100)) {
            amount = amount - (amount * percent / 100);
            year++;
        }
        return year;
    }

}
