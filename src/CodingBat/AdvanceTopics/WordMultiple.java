package CodingBat.AdvanceTopics;

import java.util.HashMap;
import java.util.Map;

public class WordMultiple {


//    Given an array of strings, return a Map<String, Boolean> where each different string is a key and its value is
//    true if that string appears 2 or more times in the array.
//
//
//    wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
//    wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
//    wordMultiple(["c", "c", "c", "c"]) → {"c": true}

    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Boolean> res = new HashMap<>();

        for (String str: strings) {
            if (map.containsKey(str)) {
                Integer count = map.get(str);
                map.put(str, count+1);
            } else
                map.put(str, 1);

            if (map.get(str) >= 2) {
                res.put(str, true);
            } else
                res.put(str, false);
        }
        return res;
    }

//    public Map<String, Boolean> wordMultiple(String[] strings) {
//        Map<String, Boolean> map = new HashMap();
//        for (String s:strings) {
//            // plan for stored boolean:
//            //   false = seen it once
//            //   true = seen it twice or more
//            if (!map.containsKey(s)) {
//                map.put(s, false);
//            }
//            else if (map.get(s) == false) {  // works without this test
//                map.put(s, true);
//            }
//        }
//        return map;
//    }

    public static void main(String[] args) {
        String[] str = {"a", "b", "a", "c", "b", "a", "a"};
        WordMultiple res = new WordMultiple();
        System.out.println(res.wordMultiple(str));
    }
}
