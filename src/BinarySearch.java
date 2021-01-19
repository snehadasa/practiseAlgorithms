public class BinarySearch {

    public int binarySearch(int[] arr, int toBeFound) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == toBeFound) {
                return mid;
            }

            if (arr[mid] < toBeFound) {
                left = mid+1;
            } else
                right = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 40};
        int toBeFound = 10;
        BinarySearch res = new BinarySearch();
        System.out.println(res.binarySearch(arr, toBeFound));
    }
}
