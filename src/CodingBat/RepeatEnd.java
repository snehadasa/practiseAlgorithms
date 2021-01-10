package CodingBat;

public class RepeatEnd {

//    Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
//    You may assume that n is between 0 and the length of the string, inclusive.
//
//
//    repeatEnd("Hello", 3) → "llollollo"
//    repeatEnd("Hello", 2) → "lolo"
//    repeatEnd("Hello", 1) → "o"

    public String repeatEnd(String str, int n) {
        String res = "";
            for (int j = 0; j < n; j++) {
                res += (str.substring(str.length() - n, str.length()));
            }
        return res;
    }

    public static void main(String[] args) {
        String str = "Hello";
        int n1 = 3, n2 = 2, n3 = 1;
        RepeatEnd res = new RepeatEnd();
        System.out.println(res.repeatEnd(str, n1));
        System.out.println(res.repeatEnd(str, n2));
        System.out.println(res.repeatEnd(str, n3));

    }
}
