package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class MinCostClimbingStairs {
//    On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
//
//    Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of
//    the floor, and you can either start from the step with index 0, or the step with index 1.
//
//    Example 1:
//    Input: cost = [10, 15, 20]
//    Output: 15
//    Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
//    Example 2:
//    Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//    Output: 6
//    Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
//    Note:
//    cost will have a length in the range [2, 1000].
//    Every cost[i] will be an integer in the range [0, 999].

    public List<Integer> minCostClimbingStairs1(int[] cost) {
        List<Integer> costList = new ArrayList<>();
        int sum1 = 0, sum2 = 0;
        costList.add(cost[0]);
        costList.add(cost[1]);
        for (int i = 0; i < cost.length-1; i++) {
            if (i+2 == cost.length - 1) {
                sum1 = cost[i] + cost[i + 1];
                costList.add(sum1);
            }
//            sum2 = cost[i] + cost[i+2];
//            costList.add(sum2);
        }
        return costList;
    }

    public int minCostClimbingStairs2(int[] cost) {
       int[] totalCost = new int[cost.length+1];
       totalCost[0] = 0;
       totalCost[1] = 0;

       for (int i = 2; i < cost.length+1; i++) {
           if (cost[i-1] + totalCost[i -1] < cost[i-2] + totalCost[i-2]) {
               totalCost[i] = cost[i-1]+totalCost[i-1];
           } else {
               totalCost[i] = cost[i-2] + totalCost[i-2];
           }
       }
       return totalCost[cost.length];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] totalCost = new int[cost.length+1];
        int f1 = cost[0], f2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int total = cost[i] + Math.min(f1, f2);
            f1 = f2;
            f2 = total;
        }
        return Math.min(f1, f2);
    }

        public static void main(String[] args) {
        int[] cost = {10,15,20};
        MinCostClimbingStairs res = new MinCostClimbingStairs();
        System.out.println(res.minCostClimbingStairs(cost));
    }
}
