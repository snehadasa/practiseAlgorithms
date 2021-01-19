package LeetCode.Easy;

public class AddBinary {
//    Given two binary strings a and b, return their sum as a binary string.
//
//
//
//    Example 1:
//
//    Input: a = "11", b = "1"
//    Output: "100"
//    Example 2:
//
//    Input: a = "1010", b = "1011"
//    Output: "10101"
//
//
//    Constraints:
//
//            1 <= a.length, b.length <= 104
//    a and b consist only of '0' or '1' characters.
//    Each string does not contain leading zeros except for the zero itself.

    //method1
    int binaryToDecimalNotLargestNumber(int number) {
        int n = 0;
        int decVal = 0;

        while (true) {
            if (number == 0) {
                break;
            } else {
                int temp = number % 10;
                decVal += temp * Math.pow(2, n);
                number /= 10;
                n++;
            }
        }
        return decVal;
    }

    public int binaryToDecimal(String n) {
        int base = 1;
        int decValue = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') {
                decValue += base;
            }
            base *= 2;
        }

        return decValue;
    }

    public String addBinary1(String a, String b) {
//        Integer aInt = Integer.valueOf(a);
//        Integer bInt = Integer.valueOf(b);
//
        int decA = binaryToDecimal(a);
        int decB = binaryToDecimal(b);

//        int decA = Integer.parseInt(a, 2);
//        int decB = Integer.parseInt(b, 2);


        int sumInDec = decA + decB;
        String sumInBin = Integer.toBinaryString(sumInDec);

        return sumInBin;
    }

    //method2
   public String appendZerosToEquateLen(String str, int length) {
        if (str.length() >= length) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
       while (sb.length() < (length - str.length())) {
           sb.append(0);
       }
       sb.append(str);

        return sb.toString();
   }

    public String addBinary(String a, String b) {
        String newA = "", newB = "";
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();

        if (a.length() == b.length()) {
            newA = a;
            newB = b;
        } else
        if (a.length() < b.length()) {
            newA = appendZerosToEquateLen(a, b.length());
            newB = b;
        } else
        if (b.length() < a.length()) {
            newB = appendZerosToEquateLen(b, a.length());
            newA = a;
        }
        char carry = '0';
        for (int i = newA.length() - 1; i >= 0; i--) {
            if (newA.charAt(i) == '0' && newB.charAt(i) == '0' && carry == '0') {
                result.append('0');
            } else
            if (newA.charAt(i) == '1' && newB.charAt(i) == '0' && carry == '0') {
                result.append('1');
            } else
            if (newA.charAt(i) == '0' && newB.charAt(i) == '1' && carry == '0') {
                result.append('1');
            } else
            if (newA.charAt(i) == '1' && newB.charAt(i) == '1' && carry == '0') {
                result.append('0');
                carry = '1';
            } else
            if (newA.charAt(i) == '1' && newB.charAt(i) == '1' && carry == '1') {
                result.append('1');
                carry = '1';
            } else
            if (newA.charAt(i) == '0' && newB.charAt(i) == '1' && carry == '1') {
                result.append('0');
                carry = '1';
            } else
            if (newA.charAt(i) == '1' && newB.charAt(i) == '0' && carry == '1') {
                result.append('0');
                carry = '1';
            } else
            if (newA.charAt(i) == '0' && newB.charAt(i) == '0' && carry == '1') {
                result.append('1');
                carry = '0';
            }
        }

        if (carry == '1') {
            result.append('1');
        }
        return result.reverse().toString();

    }

        // int count =0 ;
    public static void main(String[] args) {
        String a1 = "1010", b1 = "1011";
        String a2 = "11", b2 = "1";
        //int a = 1010, b = 1011;
        AddBinary res = new AddBinary();
        //System.out.println(res.addBinary(a2, b2));
        System.out.println(res.addBinary(a1, b1));
        //System.out.println(res.appendZerosToEquateLen(a2, 5));

    }
}
