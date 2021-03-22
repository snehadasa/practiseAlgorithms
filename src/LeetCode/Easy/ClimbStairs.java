package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
//    You are climbing a staircase. It takes n steps to reach the top.
//
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//
//
//    Example 1:
//
//    Input: n = 2
//    Output: 2
//    Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//    Example 2:
//
//    Input: n = 3
//    Output: 3
//    Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
//
//    Constraints:
//
//            1 <= n <= 45

    public int climbStairs1(int n) {
       if (n == 1) return 1;
       if (n == 2) return 2;

       int numOfSteps = 0, f1 = 1, f2 = 1;
       for (int i = 2; i <= n; i++) {
           numOfSteps = f1+f2;
           f1 = f2;
           f2 = numOfSteps;
       }
       return numOfSteps;
    }

    Map<Integer, Integer> stairsMap = new HashMap<>();
    public int helper(int n) {
        int result = 0;

        if (stairsMap.containsKey(n)) {
            return stairsMap.get(n);
        }

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        result = helper(n-1) + helper(n-2);
        stairsMap.put(n, result);

        return result;
    }

    public int climbStairs(int n) {
        return helper(n);
    }

    public static void main(String[] args) {
        ClimbStairs res = new ClimbStairs();
        int n = 3;
        System.out.println(res.climbStairs(n));
    }
}
