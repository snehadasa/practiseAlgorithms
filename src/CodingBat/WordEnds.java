package CodingBat;

public class WordEnds {

//    Given a string and a non-empty word string, return a string made of each char just before and just after every
//    appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char
//    may be included twice if it is between two words.
//
//
//            wordEnds("abcXY123XYijk", "XY") → "c13i"
//    wordEnds("XY123XY", "XY") → "13"
//    wordEnds("XY1XY", "XY") → "11"

    public String wordEnds1(String str, String word) {
        int toPrint[] = new int[str.length()];
        String res = "";

        for (int i = 0; i < str.length() - word.length() + 1; i++) {
            if (str.substring(i, Math.min(i+word.length(), str.length())).equals(word)) {
                if (i != 0) {
                    toPrint[i-1]++;
                }
                if (i + word.length() < str.length()) {
                    toPrint[i+word.length()]++;
                }
            }
        }
        for (int i = 0; i < str.length(); i++) {
            for  (int j = 0; j < toPrint[i]; j++) {
                res += str.charAt(i);
            }
        }
        return res;
    }

    public String wordEnds2(String str, String word) {
        if (str.length() <= word.length()) {
            return "";
        }
        String res = "";
        for (int i = 0; i < str.length() ; i++) {
            if ( i + 1 + word.length() <= str.length() &&
                    str.substring(i+1,  i + 1 + word.length()).equals(word)) {
                res += str.charAt(i);
            }
            if (i-word.length() >= 0 && str.substring(i-word.length(), i).equals(word)) {
                res += str.charAt(i);
            }
        }
        return res;
    }

    public String wordEnds(String str, String word) {
        String res = "";
        int wlen = word.length();
        int slen = str.length();

        for (int i = 0; i < slen-wlen+1; i++) {
            String sub = str.substring(i, i+wlen);
            if (i > 0 && sub.equals(word)) {
                res += str.substring(i - 1, i);
            }
            if (i < slen - wlen && sub.equals(word)) {
                res += str.substring(i+wlen, i+wlen+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //String str1 = "XYXY";
        String str2 = "XY123XY";
        String str3 = "XY1XY";
        String word = "XY";

        WordEnds res = new WordEnds();
        //System.out.println(res.wordEnds(str1, word));
        System.out.println(res.wordEnds(str2, word));
        System.out.println(res.wordEnds(str3, word));
    }
}
