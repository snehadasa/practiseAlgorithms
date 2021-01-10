import java.util.HashMap;
import java.util.Map;

public class SnakeAndLadder {
    public int minCounts(HashMap<Integer, Integer> snakesAndLadders, int maxIndex, int currentIndex) {
        if (maxIndex - 6 < currentIndex) {
            return 1;
        }

        int minCount = 1000000000;
        for (int i = 1; i <= 6; i++) {
            int newIndex = currentIndex + i;
            if (snakesAndLadders.containsKey(newIndex)) {
                newIndex = snakesAndLadders.get(newIndex);
            }
            minCount = Math.min(minCounts(snakesAndLadders, maxIndex, newIndex), minCount);
        }
        minCount++;
        return minCount;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> str = new HashMap<>();
        str.put(5, 7);
        int maxIndex = 30;
        int currentindex = 1;
        SnakeAndLadder res = new SnakeAndLadder();
        System.out.println(res.minCounts(str, maxIndex, currentindex));
    }
}
