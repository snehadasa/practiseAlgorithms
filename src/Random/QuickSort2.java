package Random;

import java.util.Arrays;

public class QuickSort2 {
    public  int partition(int nums[], int begin, int end) {
       int pivot = nums[end];
       int index = begin-1;

       for (int i = begin; i < end; i++) {
           if (nums[i] <= pivot) {
               index++;

               int swap = nums[index];
               nums[index] = nums[i];
               nums[i] = swap;
           }
       }

       int temp = nums[index+1];
       nums[index+1] = nums[end];
       nums[end] = temp;

       return index+1;
    }

    public int[] quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partition = partition(arr, begin, end);

            quickSort(arr, begin, partition-1);
            quickSort(arr, partition+1, end);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {6,4,8,2,9,1};
        QuickSort2 res = new QuickSort2();
        System.out.println(Arrays.toString(res.quickSort(arr, 0, 5)));
    }
}
