package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
//    Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//
//    Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements
//    that don't appear in arr2 should be placed at the end of arr1 in ascending order.
//
//
//
//    Example 1:
//
//    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//    Output: [2,2,2,1,4,3,3,9,6,7,19]
//
//
//    Constraints:
//
//            1 <= arr1.length, arr2.length <= 1000
//            0 <= arr1[i], arr2[i] <= 1000
//    All the elements of arr2 are distinct.
//    Each arr2[i] is in arr1.

    //method 1 using lamda fn
    int posOfArr2InArr1(int[] arr2, int x) {
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == x) {
                return i;
            }
        }
        return arr2.length + x;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Integer[] intToINTEGERArr = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(intToINTEGERArr, (a, b) -> posOfArr2InArr1(arr2, a) - posOfArr2InArr1(arr2, b));
        return Arrays.stream(intToINTEGERArr).mapToInt(Integer::intValue).toArray();
    }

    int posOfArr2InArr1(Map<Integer,Integer> map, int x) {
        if (map.containsKey(x)) {
            return map.get(x);
        }
        return map.size() + x;
    }

    //method 2 using hashmap
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2pos = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr2.length; i++) {
                arr2pos.put(arr2[i], i);
        }
        Integer[] intToINTEGERArr = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(intToINTEGERArr, (a, b) -> posOfArr2InArr1(arr2pos, a) - posOfArr2InArr1(arr2pos, b));
        return Arrays.stream(intToINTEGERArr).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        RelativeSortArray res = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        //System.out.println(Arrays.toString(res.relativeSortArray(arr1, arr2)));
        System.out.println(res.relativeSortArray(arr1, arr2));
    }
}
