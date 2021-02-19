package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateSpiralMatrix {
    //    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//
//
//
//            Example 1:
//
//
//    Input: n = 3
//    Output: [[1,2,3],[8,9,4],[7,6,5]]
//    Example 2:
//
//    Input: n = 1
//    Output: [[1]]
//
//
//    Constraints:
//
//            1 <= n <= 20

//    public int[][] generateMatrix(int n) {
//        int[][] mat = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                mat[i][j]
//            }
//        }
//    }

    public List<Integer> perimeterOfEdges(int[][] matrix) {
        int[] perimeter = new int[4];
        List<Integer> numbers = new ArrayList<>();
        int n = matrix.length;
        for (int i = 0; i <= (n+1)/2; )
            for (int col = 0; col < matrix[0].length; col++) {
                numbers.add(matrix[0][col]);
            }

        for (int row  = 1; row < matrix.length; row++) {
            numbers.add(matrix[row][matrix.length - 1]);
        }

        for (int col = matrix[0].length - 2; col >= 0; col--) {
            numbers.add(matrix[matrix.length - 1][col]);
        }

        for (int row = matrix.length - 2; row >= 1; row--) {
            numbers.add(matrix[row][0]);
        }

        return numbers;
    }
//    public int[][] generateMatrix(int n) {
//        int[][] mat = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                mat[i][j]
//            }
//        }
//    }

    public static void main(String[] args) {
        GenerateSpiralMatrix res = new GenerateSpiralMatrix();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(res.perimeterOfEdges(matrix));
    }
}
