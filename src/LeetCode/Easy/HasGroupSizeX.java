package LeetCode.Easy;

import java.util.*;

public class HasGroupSizeX {
//    In a deck of cards, each card has an integer written on it.
//
//    Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more
//    groups of cards, where:
//
//    Each group has exactly X cards.
//    All the cards in each group have the same integer.
//
//
//    Example 1:
//
//    Input: deck = [1,2,3,4,4,3,2,1]
//    Output: true
//    Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
//    Example 2:
//
//    Input: deck = [1,1,1,2,2,2,3,3]
//    Output: false´
//    Explanation: No possible partition.
//            Example 3:
//
//    Input: deck = [1]
//    Output: false
//    Explanation: No possible partition.
//            Example 4:
//
//    Input: deck = [1,1]
//    Output: true
//    Explanation: Possible partition [1,1].
//    Example 5:
//
//    Input: deck = [1,1,2,2,2,2]
//    Output: true
//    Explanation: Possible partition [1,1],[2,2],[2,2].
//
//
//    Constraints:
//
//            1 <= deck.length <= 10^4
//            0 <= deck[i] < 10^4

    public Boolean hasGroupsSizeX1(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> evenOrOdd = new ArrayList<>();

        Arrays.sort(deck);
        int count = 0;
        for (int i = 0; i < deck.length; i++) {
            if (map.containsKey(deck[i])) {
                int value = map.get(deck[i]);
                map.put(deck[i], 1 + value);
            } else
                map.put(deck[i], 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          evenOrOdd.add(entry.getValue());
        }

        search: for (int i = 2; i <= deck.length; ++i) {
            if (deck.length % i == 0) {
                for (int v: evenOrOdd) {
                    if (v%i != 0) {
                        continue search;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean hasGroupsSizeX(int[] deck) {
       int[] count = new int[deck.length];
       List<Integer> countlist = new ArrayList<>();

       for (int i = 0; i < deck.length; i++) {
           count[deck[i]]++;
       }

       for (int i = 0; i < count.length; i++) {
           if (count[i] > 0) {
               countlist.add(count[i]);
           }
       }

       search: for (int i = 2; i < deck.length; i++) {
           if (deck.length % i == 0) {
               for (int c:countlist) {
                   if (c%i != 0) {
                       continue search;
                   }
               }
               return true;
           }
       }
       return false;
    }

        public static void main(String[] args) {
        int[] deck1 = {1,1,2,2,2,2};
        int[] deck2 = {1,1,1,2,2,2,3,3};
        HasGroupSizeX res = new HasGroupSizeX();
        //System.out.println(res.hasGroupsSizeX(deck1));
        System.out.println(res.hasGroupsSizeX(deck2));
    }
}
