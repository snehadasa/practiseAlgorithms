package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayRankTransform {
//    Given an array of integers arr, replace each element with its rank.
//
//    The rank represents how large the element is. The rank has the following rules:
//
//    Rank is an integer starting from 1.
//    The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
//    Rank should be as small as possible.
//
//
//            Example 1:
//
//    Input: arr = [40,10,20,30]
//    Output: [4,1,2,3]
//    Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
//    Example 2:
//
//    Input: arr = [100,100,100]
//    Output: [1,1,1]
//    Explanation: Same elements share the same rank.
//    Example 3:
//
//    Input: arr = [37,12,28,9,100,56,80,5,12]
//    Output: [5,3,4,2,8,6,7,1,3]
//
//
//    Constraints:
//
//            0 <= arr.length <= 105
//            -109 <= arr[i] <= 109

    class Pair {

        private Integer a;
        private Integer b;

        public Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
        public Integer getA() {
            return a;
        }

        public Integer getB() {
            return b;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        List<Pair> pairOfCount = new ArrayList<>();
        int[] positions = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            pairOfCount.add(new Pair(i, arr[i]));
        }

        Collections.sort(pairOfCount, (Pair a, Pair b) -> a.b - b.b);

        for (int i = 0, rank = 1; i < pairOfCount.size(); i++) {
            if (i > 0 && pairOfCount.get(i).b > pairOfCount.get(i-1).b) {
                rank++;
            }
            positions[pairOfCount.get(i).a] = rank;
        }
        return positions;
    }

    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        ArrayRankTransform res = new ArrayRankTransform();
        System.out.println(Arrays.toString(res.arrayRankTransform(arr)));
    }
}
