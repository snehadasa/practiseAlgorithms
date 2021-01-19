package LeetCode.Easy;

public class IslandPerimeter {
//    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
//
//    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by
//        water, and there is exactly one island (i.e., one or more connected land cells).
//
//    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
//    One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine
//    the perimeter of the island.
//
//
//
//    Example 1:
//
//
//    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//    Output: 16
//    Explanation: The perimeter is the 16 yellow stripes in the image above.
//    Example 2:
//
//    Input: grid = [[1]]
//    Output: 4
//    Example 3:
//
//    Input: grid = [[1,0]]
//    Output: 4
//
//
//    Constraints:
//
//    row == grid.length
//    col == grid[i].length
//1 <= row, col <= 100
//    grid[i][j] is 0 or 1.

    int numberOfOnes(int[][] mat, int rowVal, int colVal) {
        int count = 0;
        //up
        if (rowVal > 0 && mat[rowVal - 1][colVal] == 1) {
            count++;
        }
        //down
        if ((rowVal < mat.length - 1) && mat[rowVal + 1][colVal] == 1) {
            count++;
        }
        //left
        if (colVal > 0 && mat[rowVal][colVal - 1] == 1) {
            count++;
        }
        //right
        if ((colVal < mat.length - 1) && mat[rowVal][colVal + 1] == 1) {
            count++;
        }
        return count;
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4 - numberOfOnes(grid, i, j);
                }
            }
        }
        return perimeter;
    }

    public int islandPerimeter2(int[][] grid) {
      int perimeter = 0;

      for (int row = 0; row < grid.length; row++) {
          for (int col = 0; col < grid[0].length; col++) {
              if (grid[row][col] == 1) {
                  if (row == 0) {
                      perimeter++;
                  }
                  if (col == 0) {
                      perimeter++;
                  }
                  if (row == grid.length - 1) {
                      perimeter++;
                  }
                  if (col == grid.length - 1) {
                      perimeter++;
                  }
                  if (row > 0 && grid[row - 1][col] == 0) {
                      perimeter++;
                  }
                  if (col > 0 && grid[row][col - 1] == 0) {
                      perimeter++;
                  }
                  if (row < grid.length - 1 && grid[row+1][col] == 0) {
                      perimeter++;
                  }
                  if (col < grid.length - 1 && grid[row][col + 1] == 0) {
                      perimeter++;
                  }
              }
          }
      }
        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter res = new IslandPerimeter();
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(res.islandPerimeter2(grid));
    }
}
