package Random;

import java.util.ArrayList;
import java.util.List;

public class CountOccurancesOfAnElement {

    public List<Integer> countOccurances(int[] A) {
        int[] countArr = new int[A.length];

        for (int c : A) {
            countArr[c]++;
        }

        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {
                countList.add(countArr[i]);
            }
        }
        return countList;
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (right < left) return -1;
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, right, target);
        }
        //else if (arr[mid] > target) {
        return binarySearch(arr, 0, mid - 1, target);
        // }
    }

    public int numberOfOccurences(int[] arr, int x) {
//        int searchElementIndex = binarySearch(A, 0, A.length - 1, x); //to know the index of first accurence of that element.
//        if (searchElementIndex == -1) {
//            return 0;
//        }
//        int count = 1;
//        int left = searchElementIndex - 1;
//
//        while (left >= 0 && A[left] == x) { //checking if elements are present to the left of the search element
//            count++;
//            left--;
//        }
//
//        int right = searchElementIndex + 1;  ////checking if elements are present to the right of the search element
//        while (right < A.length && A[right] == x) {
//            count++;
//            right++;
//        }
//
//        return count;

        int indexOfElement = binarySearch(arr, 0, arr.length-1, x);

        if (indexOfElement == 0) return -1;
        int count = 1;
        int left = indexOfElement-1;
        while (left >= 0 && arr[left] == x){
            count++;
            left--;
        }

        int right = indexOfElement+1;
        while (right < arr.length && arr[right] == x) {
            count++;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountOccurancesOfAnElement res = new CountOccurancesOfAnElement();
        int[] arr = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        //System.out.println(res.countOccurances(arr));
        System.out.println(res.numberOfOccurences(arr, 5));
    }
}
