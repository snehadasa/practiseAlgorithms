package CodingBat;

public class RepeatFront {

//    Given a string and an int n, return a string made of the first n characters of the string, followed by the
//    first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string,
//    inclusive (i.e. n >= 0 and n <= str.length()).
//
//
//    repeatFront("Chocolate", 4) → "ChocChoChC"
//    repeatFront("Chocolate", 3) → "ChoChC"
//    repeatFront("Ice Cream", 2) → "IcI"

    public String repeatFront(String str, int n) {
        String res = "";
        for (int i = 0;n >= 0 && n <= str.length(); i++) {
            res += str.substring(0, n);
            n = n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "Chocolate";
        String str2 = "Ice Cream";
        int n1 = 4, n2 = 3, n3 = 2;
        RepeatFront res = new RepeatFront();
        System.out.println(res.repeatFront(str1, n1));
        System.out.println(res.repeatFront(str1, n2));
        System.out.println(res.repeatFront(str2, n3));
    }
}
