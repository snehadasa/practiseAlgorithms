package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindKthPositive {
//    Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//
//    Find the kth positive integer that is missing from this array.
//
//
//
//            Example 1:
//
//    Input: arr = [2,3,4,7,11], k = 5
//    Output: 9
//    Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
//    Example 2:
//
//    Input: arr = [1,2,3,4], k = 2
//    Output: 6
//    Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
//
//
//    Constraints:
//
//            1 <= arr.length <= 1000
//            1 <= arr[i] <= 1000
//            1 <= k <= 1000
//    arr[i] < arr[j] for 1 <= i < j <= arr.length

    public int findKthPositive1(int[] arr, int k) {
        List<Integer> missingIntegers = new ArrayList<>();
        int first = 1, last = 10000;

        for (int i = first; i < arr[0]; i++) {
            missingIntegers.add(i);
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1+arr[i-1]; j  < arr[i]; j++) {
                missingIntegers.add(j);
            }
        }

        for (int i = 1+arr[arr.length-1]; i <= last; i++) {
            missingIntegers.add(i);
        }

        int res = 0;
        for (int i = 0; i < missingIntegers.size(); i++) {
            if (i+1 == k) {
                res = missingIntegers.get(i);
            }
        }
        return res;
    }

    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (k <= arr[i]-i-1) {
                return k+i;
            }
        }

        int len = arr.length-1;
        return arr[len] + (k - (arr[len] - len - 1));
    }

        public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 7, 11};
        int[] arr2 = {1,2,3,4};
        FindKthPositive res = new FindKthPositive();
        System.out.println(res.findKthPositive(arr1, 5));
        System.out.println(res.findKthPositive(arr2, 2));
    }

    public int findKthPositive2(int[] arr, int k) {
        List<Integer> list = new ArrayList<Integer>();
        int last= arr[arr.length-1];
        int i;

        for( i=1;i<=last;++i)
        {
            if(isPresent(i,arr))
                continue;
            else{
                list.add(i);// adding the absent elements to a list
            }
        }

        if(list.size()>k )
            return list.get(k-1);//if the element to fetch lies within the array

        int list_size= list.size();
        for(i=last+1;;++i)  // adding continuous numbers to the list
        {
            list.add(i);
            list_size++;
            if(list_size>k )
            {
                return list.get(k-1);
            }
        }
    }
    //CAN BE REPLACED BY BINARY SEARCH
    public boolean isPresent(int num,int [] arr)
    { int check=0;
        for(int i=0;i<arr.length;++i)
        {
            if(arr[i]==num)
            {
                check=1;
            }
        }
        if(check==1) return true;
        else return false;
    }
}
