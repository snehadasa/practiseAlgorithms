package CodingBat.AdvanceTopics;

import java.util.HashMap;
import java.util.Map;

public class WordLen {

//    Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array,
//    and the value is that string's length.
//
//
//    wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
//    wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
//    wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> hm = new HashMap<>();
        String[] newA = new String[strings.length];
        int j = 0;
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i] != strings[i + 1]) {
                newA[j++] = strings[i];
            }
        }
        if (strings.length > 0) {
            newA[j++] = strings[strings.length - 1];
        }

        for (int i = 0; i < newA.length; i++) {
            if (newA[i] != "0") {
                hm.put(strings[i], strings[i].length());
            }
        }
        return hm;
    }
}
