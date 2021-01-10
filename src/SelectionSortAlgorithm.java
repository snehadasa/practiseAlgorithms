public class SelectionSortAlgorithm {

    public void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++){
            int min_index = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }

    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSortAlgorithm res = new SelectionSortAlgorithm();
        int arr[] = {45, 11, 23, 79, 67, 92, 76, 54, 88};
        res.selectionSort(arr);
        res.printArray(arr);
    }
}
