package Random;

public class RotationsInCircularSortedArray {
    public int findRotationCount1(int[] A) {
        int res = 0;
        int min = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
                res = i;
            }
        }
        return res;
    }

    public int findRotationCount(int[] A) {
        int left = 0, right = A.length-1;
        while (left <= right) {
            if (A[left] <= A[right]) {
                return left;
            }

            int mid = (left+right) / 2;

            int nextMid = (mid+1) % A.length;
            int prevMid = (mid-1 + A.length) % A.length;

            if (A[mid] <= A[nextMid] && A[mid] <= A[prevMid]) {
                return mid;
            }
            else if (A[mid] <= A[right]) {
                right = mid-1;
            }
            else if (A[mid] >= A[left])
                left = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        RotationsInCircularSortedArray res = new RotationsInCircularSortedArray();
        System.out.println(res.findRotationCount1(A));
    }
}
