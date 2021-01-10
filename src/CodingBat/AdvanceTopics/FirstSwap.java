package CodingBat.AdvanceTopics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstSwap {

//    We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then
//            return the given array of non-empty strings as follows: if a string matches an earlier string in the
//        array, swap the 2 strings in the array. A particular first char can only cause 1 swap, so once a char has
//    caused a swap, its later swaps are disabled. Using a map, this can be solved making just one pass over the array.
//    More difficult than it looks.
//
//
//    firstSwap(["ab", "ac"]) → ["ac", "ab"]
//    firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
//    firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]

    public String[] firstSwap(String[] strings) {
       Map<String, Integer> map = new HashMap<>();
       for (int i = 0; i < strings.length; i++) {
           String firstChar = strings[i].substring(0, 1);
           if (map.containsKey(firstChar)) {  //checking if the map contains firstChar.
               if (map.get(firstChar) > -1) {  //checking if it is not empty
                   int match = map.get(firstChar);  //initialising index of firstChar to variable match so that it can be swapped.
                   swap(strings, match, i);  //i is the current index that need to be checked. Swap is done. Now put a stopper.
                   map.put(firstChar, -1);  //why -1? So it cannot be entered into these condition due to if-conditn.
               }
           } else {
               map.put(firstChar, i);  //if map does not contain firstChar, it is entered into map along with its index.
           }
       }
       return strings;  //return swapped final array
    }

    public void swap(String[] strings, int i, int j) {
        String  temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public static void main(String []args) {
        FirstSwap allSwap = new FirstSwap();
        String []strings1 = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};
        System.out.println(Arrays.toString(allSwap.firstSwap(strings1)));
    }

}
