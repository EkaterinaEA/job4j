package ru.job4j.array;

public class Matrix {

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }

    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X' && (monoHorizontal(board, i) || monoVertical(board, i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    static boolean monoHorizontal(char[][] board, int index) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][index] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    static boolean monoVertical(char[][] board, int index) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[index][i] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }
}
