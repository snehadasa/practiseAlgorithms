package Random;

import java.util.*;

public class DuplicatesAndSortedInDescendingOrder {
    class Pair {
        public String getWord() {
            return word;
        }

        public Integer getCount() {
            return count;
        }

        String word;
        Integer count;

        public Pair(String word, Integer count) {
            this.count = count;
            this.word = word;
        }
    }

    public List<String> duplicatesAndSortedInDescendingOrder(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }

        List<Pair> listOfKeyValuePairs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            listOfKeyValuePairs.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(listOfKeyValuePairs, (Pair a, Pair b) ->
                (a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count));

        for (int i = 0; i < listOfKeyValuePairs.size(); i++) {
            res.add(listOfKeyValuePairs.get(i).word);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("c");
        list.add("ab");
        list.add("c");
        list.add("c");

        DuplicatesAndSortedInDescendingOrder res = new DuplicatesAndSortedInDescendingOrder();
        System.out.println(res.duplicatesAndSortedInDescendingOrder(list));
    }
}
