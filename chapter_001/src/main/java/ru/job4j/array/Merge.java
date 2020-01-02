package ru.job4j.array;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int indexLeft = 0, indexRight = 0, indexRsl = 0;
        while (indexLeft < left.length && indexRight < right.length){
            rsl[indexRsl++] = left[indexLeft] < right[indexRight] ? left[indexLeft++] : right[indexRight++];
        }
        while (indexLeft < left.length){
            rsl[indexRsl++] = left[indexLeft++];
        }
        while (indexRight < right.length){
            rsl[indexRsl++] = right[indexRight++];
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
