package LeetCode.Easy;

import java.util.*;

public class FindDisappearedNumbers {
//    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
//
//    Find all the elements of [1, n] inclusive that do not appear in this array.
//
//    Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
//
//    Example:
//
//    Input:
//            [4,3,2,7,8,2,3,1]
//
//    Output:
//            [5,6]

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int[] totalNumbers = new int[nums.length+1];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            totalNumbers[nums[i]] = nums[i];
        }

        for (int i = 1; i < totalNumbers.length; i++) {
            if (totalNumbers[i] == 0) {
                result.add(i);
            }
        }
         return result;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> newNums2 = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            newNums2.add(i+1);
        }
        List numsList1 = Arrays.asList(nums);
        Set<Integer> setNumList1 = new HashSet<Integer>(newNums2);
        Set<Integer> setNumList2 = new HashSet<Integer>(numsList1);

        setNumList2.removeAll(newNums2);
        ArrayList<Integer> result = new ArrayList<>(setNumList2);

        return result;

//        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
//
//// Iterate over array1 and populate frequency map whereby
//// the key is the integer and the value is the number of
//// occurences.
//        for (int val1 : array1) {
//            Integer freq = freqMap.get(val1);
//
//            if (freq == null) {
//                freqMap.put(val1, 1);
//            } else {
//                freqMap.put(val1, freq + 1);
//            }
//        }
//
//// Now read the second array, reducing the frequency for any value
//// encountered that is also in array1.
//        for (int val2 : array2) {
//            Integer freq = freqMap.get(val2);
//
//            if (freq == null) {
//                freqMap.remove(val2);
//            } else {
//                if (freq == 0) {
//                    freqMap.remove(val2);
//                } else {
//                    freqMap.put(freq - 1);
//                }
//            }
//        }
//
//// Finally, iterate over map and build results.
//        List<Integer> result = new LinkedList<Integer>();
//
//        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
//            int remaining = entry.getValue();
//
//            for (int i=0; i<remaining; ++i) {
//                result.add(entry.getKey());
//            }
//        }
//
//// TODO: Convert to int[] using the util. method of your choosing.
    }

        public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDisappearedNumbers res = new FindDisappearedNumbers();
        System.out.println(res.findDisappearedNumbers(nums));
        //System.out.println(Arrays.toString(res.findDisappearedNumbers(nums)));
    }
}
