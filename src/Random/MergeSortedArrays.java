package Random;

import java.util.Arrays;

public class MergeSortedArrays {
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr11 = {4, 6, 2}, arr12 = {5,3,8,1}, arr13 = {}, arr14 = {2,7,5,5};
        int[] arr21 = {5,7,2,3}, arr22 = {9, 7, 0}, arr23 = {4,3,8,9}, arr24 = {};
        MergeSortedArrays res = new MergeSortedArrays();
        System.out.println(Arrays.toString(res.mergeSortedArrays(arr11, arr21)));
        System.out.println(Arrays.toString(res.mergeSortedArrays(arr12, arr22)));
        System.out.println(Arrays.toString(res.mergeSortedArrays(arr13, arr23)));
        System.out.println(Arrays.toString(res.mergeSortedArrays(arr14, arr24)));
    }
}
