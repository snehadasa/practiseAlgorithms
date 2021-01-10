package CodingBat.AdvanceTopics;

import java.util.*;

public class WordAppend {
//    Loop over the given array of strings to build a result string like this: when a string appears
//        the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty
//    string if no string appears a 2nd time.
//
//
//    wordAppend(["a", "b", "a"]) → "a"
//    wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
//    wordAppend(["a", "", "a"]) → "a"

    public String wordAppend1(String[] strings) {
//        Map<String, String> map = new HashMap<>();
        List<Integer> newA = new ArrayList<>();
        String res = "";
        Integer count = 0;
        String lastItem = strings[0];
        Arrays.sort(strings);
        for (String str: strings) {
            if (str.equals(lastItem)) {
                count++;
            } else {
                newA.add(count);
                count = 1;
            }
            lastItem = str;
        }
        newA.add(count);

        int num = 0;
        for (int i = 0 ; i < newA.size(); i++) {
            String str = strings[num];
            for (int j = 0; j < newA.get(i) / 2; j++) {
                res += str;
            }
            num += newA.get(i);
        }

        return res;
    }

    public String wordAppend(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        for (String str : strings) {
            if (map.containsKey(str)) {
                Integer count = map.get(str);
                map.put(str, count + 1);
            } else
            map.put(str, 1);

            if (map.get(str) % 2 == 0) {
                res += str;
            }
        }
        return res;
    }

        public static void main(String[] args) {
        String[] str = {"a", "b", "a", "c", "b", "a", "a"};
        WordAppend res = new WordAppend();
        System.out.println(res.wordAppend(str));
    }
}
