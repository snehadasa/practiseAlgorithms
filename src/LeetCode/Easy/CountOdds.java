package LeetCode.Easy;

public class CountOdds {
//    Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
//
//
//
//    Example 1:
//
//    Input: low = 3, high = 7
//    Output: 3
//    Explanation: The odd numbers between 3 and 7 are [3,5,7].
//    Example 2:
//
//    Input: low = 8, high = 10
//    Output: 1
//    Explanation: The odd numbers between 8 and 10 are [9].
//
//
//    Constraints:
//
//            0 <= low <= high <= 10^9



    public int countOdds(int low, int high) {
       int count = (high-low) / 2;
       if (high%2 != 0 || low%2 != 0) {
           count++;
       }
       return count;
    }

    public static void main(String[] args) {
        int low = 21, high = 22;
        CountOdds res = new CountOdds();
        System.out.println(res.countOdds(low, high));
    }
}
