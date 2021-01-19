package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheDistanceValue {
//    Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
//
//    The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where
//    |arr1[i]-arr2[j]| <= d.
//
//
//
//            Example 1:
//
//    Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
//    Output: 2
//    Explanation:
//    For arr1[0]=4 we have:
//            |4-10|=6 > d=2
//            |4-9|=5 > d=2
//            |4-1|=3 > d=2
//            |4-8|=4 > d=2
//    For arr1[1]=5 we have:
//            |5-10|=5 > d=2
//            |5-9|=4 > d=2
//            |5-1|=4 > d=2
//            |5-8|=3 > d=2
//    For arr1[2]=8 we have:
//            |8-10|=2 <= d=2
//            |8-9|=1 <= d=2
//            |8-1|=7 > d=2
//            |8-8|=0 <= d=2
//    Example 2:
//
//    Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
//    Output: 2
//    Example 3:
//
//    Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
//    Output: 1
//
//
//    Constraints:
//
//            1 <= arr1.length, arr2.length <= 500
//            -10^3 <= arr1[i], arr2[j] <= 10^3
//            0 <= d <= 100

    public int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        return count;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        List<Integer> diff = new ArrayList<>();
        int count = 0;
        Map<Integer, Integer> countValue = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                //diff.add(Math.abs(arr1[i] - arr2[j]));
                if (Math.abs(arr1[i] - arr2[j]) > d) {
                    diff.add(arr1[i]);
                }
            }
        }

        for (int i = 0; i < diff.size(); i++) {
            if (countValue.containsKey(diff.get(i))) {
                int value = countValue.get(diff.get(i));
                countValue.put(diff.get(i), value + 1);
            } else
                countValue.put(diff.get(i), 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : countValue.entrySet()) {
            if (entry.getValue() == arr2.length) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FindTheDistanceValue res = new FindTheDistanceValue();
        int[] arr1 = {-3, -3, 4, -1, -10};
        int[] arr2 = {7, 10};
        int d = 12;
        System.out.println(res.findTheDistanceValue1(arr1, arr2, d));
    }
}
