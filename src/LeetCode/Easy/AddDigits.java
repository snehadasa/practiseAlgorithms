package LeetCode.Easy;

public class AddDigits {
//    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//
//    Example:
//
//    Input: 38
//    Output: 2
//    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
//    Since 2 has only one digit, return it.
//    Follow up:
//    Could you do it without any loop/recursion in O(1) runtime?

    public int addDigits1(int num) {
        int sum = 0;
        while (num > 0) {
            int remainder = num % 10;
            sum += remainder;
            num /= 10;

            if (num == 0 && sum > 9) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }

    public int addDigits2(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num%9;
    }

    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }

        public static void main(String[] args) {
        int num = 38;
        AddDigits res = new AddDigits();
        System.out.println(res.addDigits(num));
    }
}
