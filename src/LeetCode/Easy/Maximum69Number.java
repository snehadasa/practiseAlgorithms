package LeetCode.Easy;

public class Maximum69Number {
//    Given a positive integer num consisting only of digits 6 and 9.
//
//    Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
//
//
//
//    Example 1:
//
//    Input: num = 9669
//    Output: 9969
//    Explanation:
//    Changing the first digit results in 6669.
//    Changing the second digit results in 9969.
//    Changing the third digit results in 9699.
//    Changing the fourth digit results in 9666.
//    The maximum number is 9969.
//    Example 2:
//
//    Input: num = 9996
//    Output: 9999
//    Explanation: Changing the last digit 6 to 9 results in the maximum number.
//            Example 3:
//
//    Input: num = 9999
//    Output: 9999
//    Explanation: It is better not to apply any change.
//
//
//    Constraints:
//
//            1 <= num <= 10^4
//    num's digits are 6 or 9.

    public int arrayToInt(int[] num) {
        StringBuilder s = new StringBuilder();
        for (int i:num) {
            s.append(i);
        }
        return Integer.parseInt(s.toString());
    }
    public int maximum69Number (int num) {
        String temp = Integer.toString(num);
        int[] numA = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numA[i] = temp.charAt(i) - '0';
        }
        int highest = 9;
        for (int i = 0; i < numA.length; i++) {
            if (numA[i] != 9) {
                numA[i] = 9;
                break;
            }
        }
        num = arrayToInt(numA);

        return num;
    }
    public int maximum69Number1(int n) {
        int multiplier = 1;
        int temp = n;
        int toDelete = 0;
        int toAdd = 0;
        while (temp != 0) {
            if (temp % 10 != 9) {
                toDelete = temp % 10 * multiplier;
                toAdd = 9 * multiplier;
            }
            multiplier *= 10;
            temp = temp / 10;
        }
        return n - toDelete + toAdd;
    }

    public static void main(String[] args) {
        int num = 696;
        int num1 = 9669;
        int num2 = 9996;
        Maximum69Number res = new Maximum69Number();
        System.out.println(res.maximum69Number(num));
        System.out.println(res.maximum69Number(num1));
        System.out.println(res.maximum69Number(num2));
    }
}
