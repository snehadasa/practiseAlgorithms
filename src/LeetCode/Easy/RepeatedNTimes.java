package LeetCode.Easy;

public class RepeatedNTimes {
//    In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
//
//    Return the element repeated N times.
//
//
//
//    Example 1:
//
//    Input: [1,2,3,3]
//    Output: 3
//    Example 2:
//
//    Input: [2,1,2,5,3,2]
//    Output: 2
//    Example 3:
//
//    Input: [5,1,5,2,5,3,5,4]
//    Output: 5
//
//
//    Note:
//
//            4 <= A.length <= 10000
//            0 <= A[i] < 10000
//    A.length is even

    public int repeatedNTimes(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i+1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    return A[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {2,1,2,5,3,2};
        int[] A1 = {5,1,5,2,5,3,5,4};
        RepeatedNTimes res = new RepeatedNTimes();
        System.out.println(res.repeatedNTimes(A));
        System.out.println(res.repeatedNTimes(A1));
    }

}
