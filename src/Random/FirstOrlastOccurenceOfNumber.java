package Random;

import java.util.Arrays;

public class FirstOrlastOccurenceOfNumber {
    public int[] findFirstAndLastOccurrence(int arr[], int x) {
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                res[0] = i;
                break;
            }
        }

        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == x) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public int findFirstOccurrence(int arr[], int x) {
        int left = 0, right = arr.length-1;
        int res = -1;
        while (left <= right) {
            int mid = (left+right) / 2;

            if (x == arr[mid]) {
                res = mid;
                right = mid-1;
            }
            else if (x <= arr[mid]) {
                right = mid-1;
            }
            else if (x >= arr[mid]) {
                left = mid+1;
            }
        }
        return res;
    }

    public int findlastOccurrence(int arr[], int x) {
        int left = 0, right = arr.length-1;
        int res = -1;

        while (left <= right) {
            int mid = (left+right) / 2;
            if (x == arr[mid]) {
                res = mid;
                left = mid+1;
            }
            else if (x <= arr[mid]) {
                right = mid-1;
            }
            else if (x >= arr[mid]) {
                left = mid+1;
            }
        }
        return res;
    }

        public static void main(String[] args) {
        int[] arr = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        FirstOrlastOccurenceOfNumber res = new FirstOrlastOccurenceOfNumber();
        System.out.println(Arrays.toString(res.findFirstAndLastOccurrence(arr, 5)));
        System.out.println(res.findFirstOccurrence(arr, 5));
        System.out.println(res.findlastOccurrence(arr, 5));
    }
}
