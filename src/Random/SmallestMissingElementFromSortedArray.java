package Random;

public class SmallestMissingElementFromSortedArray {
    public int smallestMissing1(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i+1) {
                res = i+1;
            }
        }
        return res;
    }

    public int smallestMissing(int[] arr, int left, int right) {
        if (left > right) return left;

        int mid = left+(right-left) / 2;
        if (arr[mid] == mid) {
            return smallestMissing(arr, mid+1, right);
        }
        else {
            return smallestMissing(arr, left, mid-1);
        }
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6};
        int left = 0, right = arr.length-1;
        SmallestMissingElementFromSortedArray res = new SmallestMissingElementFromSortedArray();
        System.out.println(res.smallestMissing(arr, left, right));
    }
}
