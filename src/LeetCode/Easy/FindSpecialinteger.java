package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class FindSpecialinteger {
//    Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more
//        than 25% of the time.
//
//    Return that integer.
//
//
//
//            Example 1:
//
//    Input: arr = [1,2,2,6,6,6,6,7,10]
//    Output: 6
//
//
//    Constraints:
//
//            1 <= arr.length <= 10^4
//            0 <= arr[i] <= 10^5

    public int findSpecialInteger(int[] arr) {
        int count = 0;
        Map<Integer, Integer> countNumbers = new HashMap<>();
        int percentage25 = (int)(arr.length * (25.00 / 100.00));

        for (int i = 0; i < arr.length; i++) {
            if (countNumbers.containsKey(arr[i])) {
                int value = countNumbers.get(arr[i]);
                countNumbers.put(arr[i], 1+value);
            } else
                countNumbers.put(arr[i], 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : countNumbers.entrySet()) {
            if (entry.getValue() > percentage25) {
                res = entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindSpecialinteger res = new FindSpecialinteger();
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(res.findSpecialInteger(arr));
    }
}
