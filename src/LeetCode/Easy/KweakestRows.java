package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KweakestRows {
//    Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the
//    indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
//
//    A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row
//    j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier
//    of a row, that is, always ones may appear first and then zeros.
//
//
//
//    Example 1:
//
//    Input: mat =
//            [[1,1,0,0,0],
//            [1,1,1,1,0],
//            [1,0,0,0,0],
//            [1,1,0,0,0],
//            [1,1,1,1,1]],
//    k = 3
//    Output: [2,0,3]
//    Explanation:
//    The number of soldiers for each row is:
//    row 0 -> 2
//    row 1 -> 4
//    row 2 -> 1
//    row 3 -> 2
//    row 4 -> 5
//    Rows ordered from the weakest to the strongest are [2,0,3,1,4]
//    Example 2:
//
//    Input: mat =
//            [[1,0,0,0],
//            [1,1,1,1],
//            [1,0,0,0],
//            [1,0,0,0]],
//    k = 2
//    Output: [0,2]
//    Explanation:
//    The number of soldiers for each row is:
//    row 0 -> 1
//    row 1 -> 4
//    row 2 -> 1
//    row 3 -> 1
//    Rows ordered from the weakest to the strongest are [0,2,3,1]
//
//
//    Constraints:
//
//    m == mat.length
//    n == mat[i].length
//2 <= n, m <= 100
//            1 <= k <= m
//    matrix[i][j] is either 0 or 1.

    public int[] kWeakestRows(int[][] mat, int k) {
        int count = 0;
        ArrayList<Integer> unsorted = new ArrayList<>();
        int[] result = new int[k];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            unsorted.add(count);
            count = 0;
        }

        ArrayList<Integer> sorted = new ArrayList<>();
        sorted = (ArrayList)unsorted.clone();
        Collections.sort(sorted);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < unsorted.size(); j++) {
                if (sorted.get(i) == unsorted.get(j)) {
                    result[i] = j;
                    unsorted.set(j, -1);
                    break;
                }
            }
        }
        return result;

//        int[] array = new int[res1.size()];
//        for(int i = 0; i < res1.size(); i++) {
//            array[i] = res1.get(i);
//        }
//        Arrays.(array);
//        for (int i = 0, j = 0; i < array.length - 1; i++) {
//            if (array[i] < array[i+1]) {
//                resultMat[j++] = i;
//            }
//        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}};
        int k = 3;
        KweakestRows res = new KweakestRows();
        System.out.println(Arrays.toString(res.kWeakestRows(mat, k)));
    }
}
