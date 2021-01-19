package LeetCode.Easy;

public class NumSpecial {
//    Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the number of special positions in mat.
//
//            A position (i,j) is called special if mat[i][j] == 1 and all other elements in row i and column j are
//            0 (rows and columns are 0-indexed).
//
//
//
//    Example 1:
//
//    Input: mat = [[1,0,0],
//            [0,0,1],
//            [1,0,0]]
//    Output: 1
//    Explanation: (1,2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
//    Example 2:
//
//    Input: mat = [[1,0,0],
//            [0,1,0],
//            [0,0,1]]
//    Output: 3
//    Explanation: (0,0), (1,1) and (2,2) are special positions.
//    Example 3:
//
//    Input: mat = [[0,0,0,1],
//            [1,0,0,0],
//            [0,1,1,0],
//            [0,0,0,0]]
//    Output: 2
//    Example 4:
//
//    Input: mat = [[0,0,0,0,0],
//            [1,0,0,0,0],
//            [0,1,0,0,0],
//            [0,0,1,0,0],
//            [0,0,0,1,1]]
//    Output: 3
//
//
//    Constraints:
//
//    rows == mat.length
//    cols == mat[i].length
//1 <= rows, cols <= 100
//    mat[i][j] is 0 or 1.


    public boolean otherPosNotEqualsOne(int[][] mat, int x, int y) {
        for (int i = 0; i < mat.length; i++) {
            if (i != x && mat[i][y] == 1) {
                return false;
            }
        }
        for (int j = 0; j < mat[0].length; j++) {
            if (j != y && mat[x][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (otherPosNotEqualsOne(mat, i , j)) {
                    count++;
                }
            }
        }
        return count;
    }

    //method2
    public int numSpecial1(int [][]mat) {
        int numOnesRows[] = new int[mat.length];
        int numOnesColumns[] = new int[mat[0].length];
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    numOnesRows[i]++;
                    numOnesColumns[j]++;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (numOnesRows[i] == 1 && numOnesColumns[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,0,0}, {0,1,0}, {0,0,1}};
        NumSpecial res = new NumSpecial();
        System.out.println(res.numSpecial(mat));
    }
}
