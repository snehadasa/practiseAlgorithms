package LeetCode.Easy;

import java.util.*;

public class MinimumAbsDistance {
    //    Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
//
//    Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//
//    a, b are from arr
//    a < b
//    b - a equals to the minimum absolute difference of any two elements in arr
//
//
//    Example 1:
//
//    Input: arr = [4,2,1,3]
//    Output: [[1,2],[2,3],[3,4]]
//    Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
//            Example 2:
//
//    Input: arr = [1,3,6,10,15]
//    Output: [[1,3]]
//    Example 3:
//
//    Input: arr = [3,8,-10,23,19,-4,-14,27]
//    Output: [[-14,-10],[19,23],[23,27]]
//
//
//    Constraints:
//
//            2 <= arr.length <= 10^5
//            -10^6 <= arr[i] <= 10^6

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
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Map<Pair, Integer> diff = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i+1] - arr[i];
            diff.put(new Pair(arr[i], arr[i+1]), temp);
            if (temp < minDiff) {
                minDiff = temp;
            }
        }

        for (Map.Entry<Pair, Integer> entry: diff.entrySet()) {
            if (entry.getValue() == minDiff) {
                List<Integer> node = new ArrayList<>();
                node.add(entry.getKey().a);
                node.add(entry.getKey().b);
                result.add(node);
            }
        }

        Collections.sort(result, (a,b) -> a.get(0) - b.get(0));
        return result;
    }

    public static void main(String[] args) {
        MinimumAbsDistance res = new MinimumAbsDistance();
        int [] number = {4,2,1,3};
        System.out.println(res.minimumAbsDifference(number));
    }
}
