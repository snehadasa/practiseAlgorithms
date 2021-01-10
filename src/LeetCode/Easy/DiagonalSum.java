package LeetCode.Easy;

public class DiagonalSum {
//    Given a square matrix mat, return the sum of the matrix diagonals.
//
//    Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal
//    that are not part of the primary diagonal.
//
//
//
//    Example 1:
//
//
//    Input: mat = [[1,2,3],
//            [4,5,6],
//            [7,8,9]]
//    Output: 25
//    Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
//    Notice that element mat[1][1] = 5 is counted only once.
//    Example 2:
//
//    Input: mat = [[1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1]]
//    Output: 8
//    Example 3:
//
//    Input: mat = [[5]]
//    Output: 5
//
//
//    Constraints:
//
//    n == mat.length == mat[i].length
//1 <= n <= 100
//            1 <= mat[i][j] <= 100

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if (row == col) {
                    sum += mat[row][col];
                }
                if (row == mat.length - row - 1 && row != col) {
                    sum += mat[row][col];
                }
            }
        }
//        for (int row = mat.length - 1; row > 0; row--) {
//            for (int col = mat[row].length - 1; col > 0; col--) {
//                sum += mat[row][col];
//            }
//        }
        return sum;
    }

    public int diagonalSum1(int[][] mat) {
        int sum = 0;
        for (int row = 0; row < mat.length; row++) {
            sum += mat[row][row];
            if (row != mat.length - 1 - row) {
                sum += mat[row][mat.length - 1 - row];
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat2 = {{5}};
        DiagonalSum res = new DiagonalSum();
        System.out.println(res.diagonalSum1(mat));
        System.out.println(res.diagonalSum1(mat2));
    }
}
