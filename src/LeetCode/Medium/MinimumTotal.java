package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {
//    Given a triangle array, return the minimum path sum from top to bottom.
//
//    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
//    current row, you may move to either index i or index i + 1 on the next row.
//
//
//
//    Example 1:
//
//    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//    Output: 11
//    Explanation: The triangle looks like:
//            2
//            3 4
//            6 5 7
//            4 1 8 3
//    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
//    Example 2:
//
//    Input: triangle = [[-10]]
//    Output: -10
//
//
//    Constraints:
//
//            1 <= triangle.length <= 200
//    triangle[0].length == 1
//    triangle[i].length == triangle[i - 1].length + 1
//            -104 <= triangle[i][j] <= 104
//
//
//    Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

    public int minInList(List<Integer> list) {
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int minInEachList = 0;
        List<Integer> min = new ArrayList<>();

        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                minInEachList = minInList(triangle.get(i));
                min.add(minInEachList);
            }
        }

        int sum = 0;
        for (Integer item: min) {
            sum += item;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<List<Integer> > listOfLists = new ArrayList<List<Integer>>();

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        listOfLists.add(list1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        listOfLists.add(list2);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        listOfLists.add(list3);

        List<Integer> list4 = new ArrayList<Integer>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        listOfLists.add(list4);

        MinimumTotal res = new MinimumTotal();
        System.out.println(res.minimumTotal(listOfLists));
    }
}
