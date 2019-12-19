package job4j;

public class MultiMax {

    public int max(int first, int second, int third) {
        return first > second ? (first > third ? first : third) : (second > third ? second : third);
    }

}
