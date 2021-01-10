package LeetCode.Easy;

public class XORoperation {
//    Given an integer n and an integer start.
//
//    Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.
//
//    Return the bitwise XOR of all elements of nums.
//
//
//
//            Example 1:
//
//    Input: n = 5, start = 0
//    Output: 8
//    Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
//    Where "^" corresponds to bitwise XOR operator.
//            Example 2:
//
//    Input: n = 4, start = 3
//    Output: 8
//    Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
//    Example 3:
//
//    Input: n = 1, start = 7
//    Output: 7
//    Example 4:
//
//    Input: n = 10, start = 5
//    Output: 2
//
//
//    Constraints:
//
//            1 <= n <= 1000
//            0 <= start <= 1000
//    n == nums.length

    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int res = nums[0];

        for (int i = 0; i < n; i++) {
            nums[i] = start + (2*i);
        }
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 10, start = 5;
        int n1 = 5, start1 = 0;

        XORoperation res = new XORoperation();
        System.out.println(res.xorOperation(n, start));
        System.out.println(res.xorOperation(n1, start1));
    }
}
