package CodingBat.AdvanceTopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllSwap {

//    We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and
//    then return the given array of non-empty strings as follows: if a string matches an earlier string in the
//        array, swap the 2 strings in the array. When a position in the array has been swapped, it no longer matches
//    anything. Using a map, this can be solved making just one pass over the array. More difficult than it looks.
//
//
//    allSwap(["ab", "ac"]) → ["ac", "ab"]
//    allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
//    allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]

//    Make a Map<String, Integer> with the first char as the key and the index in the array as the value.
//    After doing a swap, remove that key so it won't match anything in the future.

    public String[] allSwap1(String[] strings) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            char firstChar = strings[i].charAt(0);
            if (map.containsKey(firstChar)) {
                ArrayList<Integer> indexes = map.get(firstChar);
                indexes.add(i);
            } else {
                ArrayList<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                map.put(firstChar, indexes);
            }
        }
        for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> indexes = entry.getValue();
            for (int i = 0 ; i < indexes.size() - 1 ; i += 2) {
                swap(strings, indexes.get(i), indexes.get(i+1));
            }
        }
        return strings;
    }

    public void swap(String[] strings, int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public String[] allSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String firstChar = strings[i].substring(0, 1);
            if (map.containsKey(firstChar)) { //checking if the map contains firstChar.
                int match = map.get(firstChar); //initialising index of firstChar to variable match so that it can be swapped.
//                String temp = strings[match];
//                strings[match] = strings[i];
//                strings[i] = temp;
                swap(strings, match, i); //i is the current index that need to be checked. Swap is done. Now put a stopper.
                map.remove(firstChar); //once swapped, firstChar is removed so it is not matched again with other chars.
            } else
                map.put(firstChar, i); //if map does not contain firstChar, it is entered into map along with its index.
        }
        return strings; //return swapped final array
    }


        public static void main(String []args) {
        AllSwap allSwap = new AllSwap();
        String []strings1 = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};
        System.out.println(Arrays.toString(allSwap.allSwap1(strings1)));
    }
}
