package CodingBat;

public class Sum67 {

//    Return the sum of the numbers in the array, except ignore sections of numbers starting
//    with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.
//
//    sum67([1, 2, 2]) → 5
//    sum67([1, 2, 2, 6, 99, 99, 7]) → 5
//    sum67([1, 1, 6, 7, 2]) → 4

    public int sum67(int[] nums) {
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6)
                flag = true;
            if (!flag)
                sum += nums[i];
            if (nums[i] == 7)
                flag = false;

        }

        return sum;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 2, };
        int[] n2 = {1, 2, 2, 6, 99, 99, 7};
        int[] n3 = {1, 1, 6, 7, 2};
        int[] n4 = {1, 6, 2, 6, 2, 7, 1, 6, 99, 99, 7};
        Sum67 res = new Sum67();
        System.out.println(res.sum67(n1));
        System.out.println(res.sum67(n2));
        System.out.println(res.sum67(n3));
        System.out.println(res.sum67(n4));
    }
}
