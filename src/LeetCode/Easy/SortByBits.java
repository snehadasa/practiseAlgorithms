package LeetCode.Easy;

import java.util.*;
import java.util.stream.Collectors;

public class SortByBits {
//    Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's
//    in their binary representation and in case of two or more integers have the same number of 1's you have to sort
//    them in ascending order.
//
//    Return the sorted array.
//
//
//
//    Example 1:
//
//    Input: arr = [0,1,2,3,4,5,6,7,8]
//    Output: [0,1,2,4,8,3,5,6,7]
//    Explantion: [0] is the only integer with 0 bits.
//[1,2,4,8] all have 1 bit.
//[3,5,6] have 2 bits.
//[7] has 3 bits.
//    The sorted array by bits is [0,1,2,4,8,3,5,6,7]
//    Example 2:
//
//    Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
//    Output: [1,2,4,8,16,32,64,128,256,512,1024]
//    Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
//    Example 3:
//
//    Input: arr = [10000,10000]
//    Output: [10000,10000]
//    Example 4:
//
//    Input: arr = [2,3,5,7,11,13,17,19]
//    Output: [2,3,5,17,7,11,13,19]
//    Example 5:
//
//    Input: arr = [10,100,1000,10000]
//    Output: [10,100,10000,1000]

    public int binaryConversion(int n) {
        int index = 0;
        ArrayList<Integer> binaryNum = new ArrayList<>();
        while (n > 0) {
            binaryNum.add(n % 2);
            n /= 2;
            index++;
        }
        int[] num = new int[binaryNum.size()];
        for (int i = index - 1, j = 0; i >= 0; i--) {
            num[j++] = binaryNum.get(i);
        }
        StringBuilder strNum = new StringBuilder();
        for (int number : num) {
            strNum.append(number);
        }
        return Integer.parseInt(strNum.toString());
    }

    class Pair {
        private int index;
        private int oneCount;

        public Pair(int index, int oneCount) {
            this.index = index;
            this.oneCount = oneCount;
        }

        public int getIndex() {
            return index;
        }

        public int getOneCount() {
            return oneCount;
        }
    }

    public int countOnes(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        String[] num = new String[arr.length];
        List<Pair> list = new ArrayList<>();
        int[] countOfEachDec = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            num[i] = Integer.toString(arr[i], 2);
        }
        for (int i = 0; i < num.length; i++) {
            int count = 0;
            for (int j = 0; j < num[i].length(); j++) {
                if (num[i].charAt(j) == '1') {
                    count++;
                }
            }
            list.add(new Pair(i, count));
        }
        Collections.sort(list, (a,b) -> a.oneCount - b.oneCount);

        for (int i = 0; i < list.size(); i++) {
            countOfEachDec[i] = arr[list.get(i).index];
        }
        return countOfEachDec;
    }

        public int[] sortByBits1(int[] arr) {
        List<Integer> list  = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list,
                (Integer a, Integer b) ->
                countOnes(Integer.toString(a, 2)) - countOnes(Integer.toString(b, 2)));
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] n = {0,1,2,3,4,5,6,7,8};
        int[] n2 = {1024,512,256,128,64,32,16,8,4,2,1};
        SortByBits res = new SortByBits();
        System.out.println(Arrays.toString(res.sortByBits(n)));
        System.out.println(Arrays.toString(res.sortByBits(n2)));
        System.out.println(Arrays.toString(res.sortByBits1(n)));
        System.out.println(Arrays.toString(res.sortByBits1(n2)));
        //System.out.println(Arrays.toString(res.binaryConversion(n)));
    }
}
