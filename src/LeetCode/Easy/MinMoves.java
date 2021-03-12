package LeetCode.Easy;

import java.util.*;

public class MinMoves {
//    Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements
//    equal, where a move is incrementing n - 1 elements by 1.
//
//    Example:
//
//    Input:
//            [1,2,3]
//
//    Output:
//            3
//
//    Explanation:
//    Only three moves are needed (remember each move increments two elements):
//
//            [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

    public int minMoves1(int[] nums) {
        int[] arr = new int[nums.length];
        Set<Integer> numsSet = new HashSet<>();

        int count = 0;
        Arrays.sort(nums);
        int min = nums[0];

        for (int num:nums) {
            numsSet.add(num);
        }

        if (numsSet.size() > 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != min) {
                    arr[i] = min;
                    count++;
                } else {
                    arr[i] = min;
                }
            }
            Set<Integer> set = new HashSet<>();

            for (int a : arr) {
                set.add(a);
            }
            if (set.size() == 1) {
                return count;
            }
        }
        return 0;
    }

    public int minMoves(int[] nums) {
        int min = nums[0], sum = 0;

        for (int num: nums) {
            sum += num;
            if (num <  min) {
                min = num;
            }
        }
        return sum - (nums.length*min);
    }

    public int minMoves2(int[] nums) {
        int min = nums[0], count = 0;
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] != min);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != min) {
                li.add(nums[i] - min);
            }
        }
        for (int i = 0; i < li.size(); i++) {
            count += li.get(i);
        }
        return count;
    }

        public static void main(String[] args) {
        MinMoves res = new MinMoves();
        int[] nums = {1, 2};
        int []nums1 = {1,2,3};
        int []nums2 = {1,1,1};
        System.out.println(res.minMoves(nums));
        System.out.println(res.minMoves(nums1));
        System.out.println(res.minMoves(nums2));
    }
}
