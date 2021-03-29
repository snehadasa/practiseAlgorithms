import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partion(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
        return arr;
    }

    private int partion(int[] arr, int begin, int end) {
        int pivot = arr[end];

        int index = (begin-1);

        for (int i = begin; i < end; i++) {
            if (arr[i] <= pivot) {
                index++;

                int swap = arr[index];
                arr[index] = arr[i];
                arr[i] = swap;
            }
        }

        int temp = arr[index+1];
        arr[index+1] = arr[end];
        arr[end] = temp;

        return index+1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 4, 6, 5, 3};
        int begin = 0, end = 5;
        QuickSort res = new QuickSort();
        System.out.println(Arrays.toString(res.quickSort(arr, begin, end)));
    }
}
