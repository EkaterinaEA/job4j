package job4j;

public class Max {

    public static int max(int left, int right) {
        int max = left > right || left == right ? left : right;
        return max;
    }

}
