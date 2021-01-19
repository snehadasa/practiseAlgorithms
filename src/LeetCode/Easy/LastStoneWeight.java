package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LastStoneWeight {
//    We have a collection of stones, each stone has a positive integer weight.
//
//    Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y
//    with x <= y.  The result of this smash is:
//
//    If x == y, both stones are totally destroyed;
//    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
//    At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
//
//
//
//    Example 1:
//
//    Input: [2,7,4,1,8,1]
//    Output: 1
//    Explanation:
//    We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//    we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//    we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//    we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
//
//
//    Note:
//
//            1 <= stones.length <= 30
//            1 <= stones[i] <= 1000

    public List<Integer> lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(stones);

        for (int i = 0; i < stones.length-1; i++) {
            if (Math.abs(stones[i] - stones[i+1]) == 1) {
                list.add(1);
            }
            else if (Math.abs(stones[i] - stones[i+1]) == 2) {
                    list.add(2);
                }
            else if (Math.abs(stones[i] - stones[i+1]) == 0) {
                        list.add(0);
                    }
        }

        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for (int i = 0; i < list.size()-1; i++) {
            if (Math.abs(list.get(i) - list.get(i+1)) == 1) {
                list2.add(1);
            }
            else if (Math.abs(list.get(i) - list.get(i+1)) == 2) {
                list2.add(2);
            }
            else if (Math.abs(list.get(i) - list.get(i+1))== 1) {
                list2.add(0);
            }
        }

        for (Integer integer : list) {
            if (integer != 0) {
                list3.add(integer);
            }
        }
        return list2;
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        LastStoneWeight res = new LastStoneWeight();
        System.out.println(res.lastStoneWeight(stones));
    }
}
