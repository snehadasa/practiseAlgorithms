package LeetCode.Easy;

public class CountNegatives {
//    Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
//
//    Return the number of negative numbers in grid.
//
//
//
//    Example 1:
//
//    Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//    Output: 8
//    Explanation: There are 8 negatives number in the matrix.
//            Example 2:
//
//    Input: grid = [[3,2],[1,0]]
//    Output: 0
//    Example 3:
//
//    Input: grid = [[1,-1],[-1,-1]]
//    Output: 3
//    Example 4:
//
//    Input: grid = [[-1]]
//    Output: 1
//
//
//    Constraints:
//
//    m == grid.length
//    n == grid[i].length
//1 <= m, n <= 100
//            -100 <= grid[i][j] <= 100

    public int countNegatives1(int[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int row[]: grid) {
            for (int col:row) {
                if (col < 0) {
                    count++;
                }
            }
        }
        return count;
    }

        public static void main(String[] args) {
        int[][] grid = {{5,1,0},{-5,-5,-5}};
        int[][] grid1 = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        CountNegatives res = new CountNegatives();
        System.out.println(res.countNegatives(grid));
        System.out.println(res.countNegatives(grid1));
    }
}
