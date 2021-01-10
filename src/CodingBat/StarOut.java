package CodingBat;

public class StarOut {

//    Return a version of the given string, where for every star (*) in the string the star and the chars immediately to
//    its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
//
//
//    starOut("sm***eil*ly") → "siy"
//    starOut("ab**cd") → "ad"
//    starOut("sm*eilly") → "silly"

    public String starOut(String str) {
        String res = "";
        boolean shouldReplace[] = new boolean[str.length()];
        if (str.length() <= 1) {
           return str == "*" ? "" : str;
        }

        if (str.charAt(0) == '*') {
            shouldReplace[0] = true;
            shouldReplace[1] = true;
        }
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*') {
                shouldReplace[i] = true;
                shouldReplace[i - 1] = true;
                shouldReplace[i + 1] = true;
            }

        }
        if (str.charAt(str.length() - 1) == '*') {
            shouldReplace[str.length() - 1] = true;
            shouldReplace[str.length() - 2] = true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!shouldReplace[i]) {
                res += str.charAt(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String str1 = "*stringy*";
        String str2 = "a*";
        String str3 = "sm*eilly";

        StarOut res = new StarOut();
        System.out.println(res.starOut(str1));
        System.out.println(res.starOut(str2));
        System.out.println(res.starOut(str3));
    }
}
