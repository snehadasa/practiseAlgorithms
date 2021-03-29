package LeetCode.Medium;

import java.util.*;

public class TopKFrequent {
//    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//
//
//
//            Example 1:
//
//    Input: nums = [1,1,1,2,2,3], k = 2
//    Output: [1,2]
//    Example 2:
//
//    Input: nums = [1], k = 1
//    Output: [1]
//
//
//    Constraints:
//
//            1 <= nums.legth <= 105
//    k is in the range [1, the number of unique elements in the array].
//    It is guaranteed that the answer is unique.
//
//
//    Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

    class Pair {
        private Integer a;
        private Integer b;

        public Integer getA() {
            return a;
        }

        public Integer getB() {
            return b;
        }

        public Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] arr = new int[k];

        List<Pair> pairOfCount = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairOfCount.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(pairOfCount, (Pair x, Pair y) -> y.b - x.b);

        for (int i = 0, j = 0; i < k; i++) {
            arr[j++] = pairOfCount.get(i).a;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        TopKFrequent res = new TopKFrequent();
        System.out.println(Arrays.toString(res.topKFrequent(nums, k)));
    }
}
