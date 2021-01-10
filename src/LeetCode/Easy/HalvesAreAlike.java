package LeetCode.Easy;

public class HalvesAreAlike {
//    You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the
//    first half and b be the second half.
//
//    Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
//    Notice that s contains uppercase and lowercase letters.
//
//    Return true if a and b are alike. Otherwise, return false.
//
//
//
//    Example 1:
//
//    Input: s = "book"
//    Output: true
//    Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
//            Example 2:
//
//    Input: s = "textbook"
//    Output: false
//    Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
//    Notice that the vowel o is counted twice.
//    Example 3:
//
//    Input: s = "MerryChristmas"
//    Output: false
//    Example 4:
//
//    Input: s = "AbCdEfGh"
//    Output: true
//
//
//    Constraints:
//
//            2 <= s.length <= 1000
//    s.length is even.
//    s consists of uppercase and lowercase letters.

    public boolean halvesAreAlike(String s) {
        String a = "";
        String b = "";
        int countA = 0, countB = 0;
        if (s.length() % 2 == 0) {
             a = s.substring(0, s.length() / 2);
             b = s.substring(s.length() / 2);
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.toLowerCase().charAt(i) == 'a' || a.toLowerCase().charAt(i) == 'e' || a.toLowerCase().charAt(i) == 'i'
                    || a.toLowerCase().charAt(i) == 'o' || a.toLowerCase().charAt(i) == 'u') {
                countA++;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.toLowerCase().charAt(i) == 'a' || b.toLowerCase().charAt(i) == 'e' || b.toLowerCase().charAt(i) == 'i'
                    || b.toLowerCase().charAt(i) == 'o' || b.toLowerCase().charAt(i) == 'u') {
                countB++;
            }
        }

        if (countA == countB) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "textbook", s1 = "book";
        HalvesAreAlike res = new HalvesAreAlike();
        System.out.println(res.halvesAreAlike(s));
        System.out.println(res.halvesAreAlike(s1));
    }
}
