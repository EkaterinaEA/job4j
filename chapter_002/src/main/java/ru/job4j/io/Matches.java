package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    static int matches = 11;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (matches > 0) {
            System.out.println("Количество спичек на столе: " + matches);
            System.out.print("Выберите количество спичек от 1 до 3: \n");
            int select = Integer.valueOf(input.nextLine());
            if (select < 1 || select > 3) {
                System.out.println("Введённое число не соответствует диапазону от 1 до 3\n");
                continue;
            } else if (matches - select <= 0) {
                System.out.println("Вы победили!");
            }
            matches -= select;
            System.out.println();
        }
    }

}
