package CodingBat;

public class MatchUp {

//    Given arrays nums1 and nums2 of the same length, for every element in nums1,
//    consider the corresponding element in nums2 (at the same index). Return the count of
//    the number of times that the two elements differ by 2 or less, but are not equal.
//
//
//            matchUp([1, 2, 3], [2, 3, 10]) → 2
//    matchUp([1, 2, 3], [2, 3, 5]) → 3
//    matchUp([1, 2, 3], [2, 3, 3]) → 2

    public int matchUp(int[] nums1, int[] nums2) {
        int count = 0;
        for (int i = 0; i < nums1.length && i < nums2.length; i++) {
            if (nums1.length == nums2.length && (nums1[i] != nums2[i])) {
                if (Math.abs(nums1[i] - nums2[i]) <= 2)
                    count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] anums1 = {1, 2, 3}, anums2 = {2, 3, 10};
        int[] bnums1 = {1, 2, 3}, bnums2 = {2, 3, 5};
        int[] cnums1 = {1, 2, 3}, cnums2 = {2, 3, 3};
        MatchUp res = new MatchUp();

        System.out.println(res.matchUp(anums1, anums2));
        System.out.println(res.matchUp(bnums1, bnums2));
        System.out.println(res.matchUp(cnums1, cnums2));
    }
}
