package LeetCode.Easy;

public class CanThreePartsEqualSum {
//    Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
//
//            Formally, we can partition the array if we can find indexes i + 1 < j with
//            (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1]
//            + ... + arr[arr.length - 1])
//
//
//
//    Example 1:
//
//    Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
//    Output: true
//    Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//    Example 2:
//
//    Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
//    Output: false
//    Example 3:
//
//    Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
//    Output: true
//    Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//
//
//    Constraints:
//
//            3 <= arr.length <= 5 * 104
//            -104 <= arr[i] <= 104

//    public boolean canThreePartsEqualSum(int[] arr) {
//        int sum1 = 0, sum2 = 0, sum3 = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum1 += arr[i];
//        }
//        int firstThird = sum1/3;
//        sum2 = sum1 - firstThird;
//        int secondThird = sum2 / 3;
//        sum3 = sum2 - secondThird;
//
//        if (firstThird == secondThird && secondThird == sum3) {
//            return true;
//        }
//        return false;
//
//    }

    public boolean canThreePartsEqualSum(int[] arr) {
       int sum = 0;
       for (int a: arr) {
           sum += a;
       }
       if (sum%3 != 0) {
           return false;  //if there are no 3 equal parts in the array.
       }
       int firstThird = sum/3; //first third of the sum
       int target = firstThird, current = 0, count = 0;

       for (int a: arr) {
           current += a;  //sum till the first third of the sum
           if (target == current) {
               count++;  //if 1st third is found, then count++. there should be 3 equal thirds.
               target += firstThird; //if first half is found then add till the second third.
           }
       }
       return count >= 3;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        CanThreePartsEqualSum res = new CanThreePartsEqualSum();
        System.out.println(res.canThreePartsEqualSum(arr));
    }
}
