package LeetCode.Easy;

import java.util.Arrays;

public class ReplaceElements {
//    Given an array arr, replace every element in that array with the greatest element among the elements to its right,
//    and replace the last element with -1.
//
//    After doing so, return the array.
//
//
//
//    Example 1:
//
//    Input: arr = [17,18,5,4,6,1]
//    Output: [18,6,6,6,1,-1]
//    Explanation:
//            - index 0 --> the greatest element to the right of index 0 is index 1 (18).
//            - index 1 --> the greatest element to the right of index 1 is index 4 (6).
//            - index 2 --> the greatest element to the right of index 2 is index 4 (6).
//            - index 3 --> the greatest element to the right of index 3 is index 4 (6).
//            - index 4 --> the greatest element to the right of index 4 is index 5 (1).
//            - index 5 --> there are no elements to the right of index 5, so we put -1.
//    Example 2:
//
//    Input: arr = [400]
//    Output: [-1]
//    Explanation: There are no elements to the right of index 0.
//
//
//    Constraints:
//
//            1 <= arr.length <= 104
//            1 <= arr[i] <= 105

    public void swapElements(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public int[] replaceElements1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr.length < 2) {
                arr[i] = -1;
            }
            arr[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    arr[i] = arr[j];
                }
            }

        }
        return arr;
    }

    public int[] replaceElements(int[] arr) {
      int current = -1;

      for (int i = arr.length - 1; i >= 0; i--) {
          int temp = arr[i];
          arr[i] = current;
          current = Math.max(current, temp);
      }
      return arr;
    }


    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        ReplaceElements res = new ReplaceElements();
        System.out.println(Arrays.toString(res.replaceElements(arr)));
    }
}
