package LeetCode.Easy;

import java.util.Arrays;
import java.util.List;

public class Decrypt {
//    You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular
//    array code of length of n and a key k.
//
//    To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
//
//    If k > 0, replace the ith number with the sum of the next k numbers.
//    If k < 0, replace the ith number with the sum of the previous k numbers.
//    If k == 0, replace the ith number with 0.
//    As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
//
//    Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
//
//
//
//    Example 1:
//
//    Input: code = [5,7,1,4], k = 3
//    Output: [12,10,16,13]
//    Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is
//    [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
//    Example 2:
//
//    Input: code = [1,2,3,4], k = 0
//    Output: [0,0,0,0]
//    Explanation: When k is zero, the numbers are replaced by 0.
//    Example 3:
//
//    Input: code = [2,4,9,3], k = -2
//    Output: [12,5,6,13]
//    Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again.
//    If k is negative, the sum is of the previous numbers.
//
//
//    Constraints:
//
//    n == code.length
//1 <= n <= 100
//            1 <= code[i] <= 100
//            -(n - 1) <= k <= n - 1

//    public int nextElement(int[] arr, int curr) {
//
//    }
//    public boolean isCircular(int[] arr) {
//        int fast = 0, slow = 0;
//
//        slow =
//    }
public int[] decrypt1(int[] code, int k) {
    int[] newDecrypt = new int[code.length];
    for (int i = 0; i < code.length; i++) {
        if (k == 0) {
            newDecrypt[i] = 0;
        }
        if (k > 0) {
            int count =0;
            for (int j = 1; j <= k; j++) {
                int newIndex = i + j;
                if (newIndex >= code.length) {
                    newIndex -= code.length;
                }
                count += code[newIndex];
                //count += code[newIndex %code.length];
            }
            newDecrypt[i] = count;
        }
        if (k < 0 ) {
            int count =0;
            for (int j = k; j < 0;j++) {
                int newIndex = i + j;
                if (newIndex < 0) {
                    newIndex += code.length;
                }
                count += code[newIndex];
            }
            newDecrypt[i] = count;
        }
    }

    return newDecrypt;
}
    public int[] decrypt(int[] code, int k) {
       int[] newDecrypt = new int[code.length];

       for (int i = 0; i < code.length; i++) {
           if (k == 0) {
               newDecrypt[i] = 0;
           }
           if (k > 0) {
               int count = 0;
               for (int j = 1; j <= k; j++) {
                   int newIndex = i + j;
                   if (newIndex >= code.length) {
                       newIndex -= code.length;
                   }
                   count += code[newIndex];
               }
               newDecrypt[i] = count;
           }

           if (k < 0) {
               int count = 0;
               for (int j = k; j < 0; j++) {
                   int newIndex = i+j;
                   if (newIndex < 0) {
                       newIndex += code.length;
                   }
                   count += code[newIndex];
               }
               newDecrypt[i] = count;
           }
       }
       return newDecrypt;
    }

    public static void main(String[] args) {
        int[] code = {5,7,1,4}, code2 = {1,2,3,4}, code3 = {2,4,9,3};
        int k = 3, k2 = 0, k3 = -2;
        Decrypt res = new Decrypt();
        //System.out.println(Arrays.toString(res.decrypt(code, k)));
        //System.out.println(Arrays.toString(res.decrypt(code2, k2)));
        System.out.println(Arrays.toString(res.decrypt1(code3, k3)));
    }
}
