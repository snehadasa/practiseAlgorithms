package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class NumEquivDominoPairs {
//    Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either
//            (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
//
//    Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
//
//
//
//    Example 1:
//
//    Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
//    Output: 1
//
//
//    Constraints:
//
//            1 <= dominoes.length <= 40000
//            1 <= dominoes[i][j] <= 9

    public int numEquivDominoPairs(int[][] dominoes) {
       Map<Integer, Integer> map = new HashMap<>();
       int result = 0;

       for (int[] item: dominoes) {
           int value = item[0] < item[1] ? item[0] * 10 + item[1] : item[1] * 10 + item[0];
           int count = map.getOrDefault(value, 0);
           map.put(value , count+1);
           result += count;
       }
       return result;
    }

    public static void main(String[] args) {
        int[][] dominoes1 = {{1,2},{2,1},{3,4},{4,3},{5,6}};
        int[][] dominoes2 = {{1,2},{1,2},{3,4},{1,2},{5,6}};
        NumEquivDominoPairs res = new NumEquivDominoPairs();
        System.out.println(res.numEquivDominoPairs(dominoes1));
        System.out.println(res.numEquivDominoPairs(dominoes2));
    }
}
