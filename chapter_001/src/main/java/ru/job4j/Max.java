package ru.job4j;

public class Max {

    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int first, int second, int third) {
        return max(first, second) < third ? third : (first < second ? second : first);
    }

    public static int max(int first, int second, int third, int fourth) {
        return max(first, second, third) < first ? first : (max(first, second) < third ? third :
                (first < second ? second : first));
    }

}
