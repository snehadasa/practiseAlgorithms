package Random;

public class ElementInCircularSortedArray {
    public int elementInCircularSortedArray(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] <= arr[right]) {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid+1;
                } else
                    right = mid-1;
            } else
                if (arr[mid] >= arr[left]) {
                    if (target >= arr[left] && target < arr[mid]) {
                        right = mid-1;
                    } else
                        left = mid+1;
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 10, 2, 5, 6, 8};
        int key = 5;

        ElementInCircularSortedArray res = new ElementInCircularSortedArray();
        System.out.println(res.elementInCircularSortedArray(arr,key));
    }
}
