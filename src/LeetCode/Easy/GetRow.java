package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
//    Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
//
//    Notice that the row index starts from 0.
//
//
//    In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
//    Follow up:
//
//    Could you optimize your algorithm to use only O(k) extra space?
//
//
//
//    Example 1:
//
//    Input: rowIndex = 3
//    Output: [1,3,3,1]
//    Example 2:
//
//    Input: rowIndex = 0
//    Output: [1]
//    Example 3:
//
//    Input: rowIndex = 1
//    Output: [1,1]
//
//
//    Constraints:
//
//            0 <= rowIndex <= 33

    public List<List<Integer>> pascalTriangle(int numsRows) {
     List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < numsRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            List<Integer> prevRow = new ArrayList<>();

            newRow.add(1);
            for (int j = 0; j < i; j++) {
                newRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            newRow.add(1);

            pascal.add(newRow);
        }
        return pascal;
    }

//    public List<Integer> getRow(int rowIndex) {
//
//    }
}
