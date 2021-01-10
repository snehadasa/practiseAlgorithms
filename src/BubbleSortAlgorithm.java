public class BubbleSortAlgorithm {

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSortAlgorithm res = new BubbleSortAlgorithm();
        int arr[] = {45, 1, 23, 89, 67, 92, 76, 54, 88};
        res.bubbleSort(arr);
        res.printArray(arr);
    }
}
