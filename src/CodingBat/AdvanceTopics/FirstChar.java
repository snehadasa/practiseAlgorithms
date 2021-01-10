package CodingBat.AdvanceTopics;

import CodingBat.FirstHalf;

import java.util.HashMap;
import java.util.Map;

public class FirstChar {
    //    Given an array of non-empty strings, return a Map<String, String> with a key for every different first character
//        seen, with the value of all the strings starting with that character appended together
//    in the order they appear in the array.
//
//
//            firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
//    firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
//    firstChar([]) → {}
    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str: strings) {
            String first = str.substring(0, 1);
            if (map.containsKey(first)) {
                map.put(first, map.get(first) + str);
            } else
            map.put(first, str);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] str = {"aa", "bb", "cc", "aAA", "cCC", "d"};
        FirstChar res = new FirstChar();
        System.out.println(res.firstChar(str));
    }
}
