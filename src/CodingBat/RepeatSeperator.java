package CodingBat;

public class RepeatSeperator {

//    Given two strings, word and a separator sep, return a big string made of count occurrences of the word,
//    separated by the separator string.
//
//
//    repeatSeparator("Word", "X", 3) → "WordXWordXWord"
//    repeatSeparator("This", "And", 2) → "ThisAndThis"
//    repeatSeparator("This", "And", 1) → "This"

    public String repeatSeparator(String word, String sep, int count) {
        String res = "";
        for (int i = 0; i < count; i++) {
            res += sep + word;
        }
        if (count == 0) {
            return "";
        }
        return res;
    }

    public static void main(String[] args) {
        String word1 = "Word", word2 = "This";
        String sep1 = "X", sep2 = "And";
        int count1 = 3, count2 = 2, count3 = 1;
        RepeatSeperator res = new RepeatSeperator();
        System.out.println(res.repeatSeparator(word1, sep1, count1));
        System.out.println(res.repeatSeparator(word2, sep2, count2));
        System.out.println(res.repeatSeparator(word2, sep2, count3));
    }
}
