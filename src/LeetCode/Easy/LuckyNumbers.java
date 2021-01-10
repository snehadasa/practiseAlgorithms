package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuckyNumbers {
//    Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
//
//    A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
//
//
//
//    Example 1:
//
//    Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
//    Output: [15]
//    Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
//    Example 2:
//
//    Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//    Output: [12]
//    Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
//            Example 3:
//
//    Input: matrix = [[7,8],[1,2]]
//    Output: [7]
//
//
//    Constraints:
//
//    m == mat.length
//    n == mat[i].length
//1 <= n, m <= 50
//            1 <= matrix[i][j] <= 10^5.
//    All elements in the matrix are distinct.

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
//        List<Integer> lowestRow = new ArrayList<>();
//        List<Integer> highestCol = new ArrayList<>();
        Map<Integer, Integer> lowestRow = new HashMap<>();
        Map<Integer, Integer> highestCol = new HashMap<>();

        //minimum element in each sub-matrix(col)
        for (int row = 0; row < matrix.length; row++) {
            int minRow = matrix[row][0];
            lowestRow.put(row, 0);
            for (int col = 0; col < matrix[0].length; col++)
            if (matrix[row][col] < minRow) {
                minRow = matrix[row][col];
                lowestRow.put(row, col);
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {
            int maxCol = matrix[0][col];
            highestCol.put(col, 0);
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] > maxCol) {
                    maxCol = matrix[row][col];
                    highestCol.put(col, row);
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            int col = lowestRow.get(row);
            if (highestCol.get(col) == row) {
                result.add(matrix[row][col]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{7,8},{1,2}};
        int [][] matrix2 = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        LuckyNumbers res = new LuckyNumbers();
        System.out.println(res.luckyNumbers(matrix));
//        System.out.println(res.luckyNumbers(matrix2));
    }
}
