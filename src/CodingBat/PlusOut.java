package CodingBat;

public class PlusOut {

//    Given a string and a non-empty word string, return a version of the original String where all chars have been
//    replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
//
//
//            plusOut("12xy34", "xy") → "++xy++"
//    plusOut("12xy34", "1") → "1+++++"
//    plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"

    public String plusOut(String str, String word) {

        boolean replaceword[] = new boolean[str.length()];
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, Math.min(str.length(), i + word.length())).equals(word)) {
                replaceword[i] = true;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (replaceword[i]) {
                res += word;
                i += word.length() - 1;
            } else
                res += "+";

        }
        return res;
    }

    public String plusOut1(String str, String word) {

        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, Math.min(str.length(), i + word.length())).equals(word)) {
                res += word;
                i += word.length() - 1;
            } else {
                res += "+";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "12xy34xyabcxy";
        String str2 = "12xy34";
        String str3 = "12xy34xyabcxy";
        String word1 = "xy", word2 = "1", word3 = "xy";

        PlusOut res = new PlusOut();
        System.out.println(res.plusOut(str1, word1));
        System.out.println(res.plusOut(str2, word2));
        System.out.println(res.plusOut(str3, word3));
    }
}
