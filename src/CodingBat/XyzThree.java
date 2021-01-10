package CodingBat;

public class XyzThree {
//    Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded
//    by a period (.). So "xxyz" counts but "x.xyz" does not.
//
//
//    xyzThere("abcxyz") → true
//    xyzThere("abc.xyz") → false
//    xyzThere("xyz.abc") → true

    public boolean xyzThere(String str) {
        for (int i = 0; i <= str.length() - 3; i++) {
            if (i > 0 && (str.charAt(i) == 'x') && str.charAt(i - 1) != '.') {
                if (str.substring(i, i + 3).equals("xyz")) {
                    return true;
                }
            } else if (i == 0 && str.charAt(i) == 'x') {
                if (str.substring(i, i + 3).equals("xyz")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "1.xyz.xyz2.xyz";
        String str2 = "xyz.abc";
        String str3 = "hxix";

        XyzThree res = new XyzThree();
        System.out.println(res.xyzThere(str1));
        System.out.println(res.xyzThere(str2));
        System.out.println(res.xyzThere(str3));

    }
}
