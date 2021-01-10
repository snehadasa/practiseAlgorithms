package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class CanMakeArthemeticProgression {
//    Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference
//    between any two consecutive elements is the same.
//
//    Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.
//
//
//
//    Example 1:
//
//    Input: arr = [3,5,1]
//    Output: true
//    Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between
//    each consecutive elements.
//    Example 2:
//
//    Input: arr = [1,2,4]
//    Output: false
//    Explanation: There is no way to reorder the elements to obtain an arithmetic progression.
//
//
//            Constraints:
//
//            2 <= arr.length <= 1000
//            -10^6 <= arr[i] <= 10^6

    public boolean canMakeArithmeticProgression(int[] arr) {
        ArrayList<Boolean> res = new ArrayList<>();
        int diff = 0;

        Arrays.sort(arr);
        diff = arr[1] - arr[0];
//        if ((arr[1] < 0 && arr[0] > 0) || (arr[1] > 0 && arr[0] < 0)) {
//            diff = arr[1] + arr[0];
//        }
        for (int i = 2; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {

                if (arr[i] - arr[i-1] != diff) {
                    res.add(false);
                } else
                    res.add(true);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == false) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1};
        int[] arr2 = {1,2,4};
        int[] arr3 = {-68,-96,-12,-40,16};
        int[] arr4 = {126,183,259,31,145,202,221,278,50,107,164,12,88,-7,240,69};
        CanMakeArthemeticProgression res = new CanMakeArthemeticProgression();
//        System.out.println(res.canMakeArithmeticProgression(arr));
//        System.out.println(res.canMakeArithmeticProgression(arr2));
        //System.out.println(res.canMakeArithmeticProgression(arr3));
        System.out.println(res.canMakeArithmeticProgression(arr4));
    }
}
