package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {
//    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
//
//    Find all the elements that appear twice in this array.
//
//    Could you do it without extra space and in O(n) runtime?
//
//    Example:
//    Input:
//            [4,3,2,7,8,2,3,1]
//
//    Output:
//            [2,3]

    public List<Integer> findDuplicates1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]);
                map.put(nums[i], 1 + value);
            } else
                map.put(nums[i], 1);
        }

        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    public int binarySearchFindDuplicates(int[] num, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (num[mid] == target) {
                return mid;
            }

            if (num[mid] > target) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return -1;
    }

    //second loop, binary search
    public List<Integer> findDuplicates(int[] nums) {
        int count[] = new int[nums.length + 1];
        for (int num : nums) {
            count[num]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDuplicates res = new FindDuplicates();
        System.out.println(res.findDuplicates(nums));
    }
}
