package CodingBat;

public class StringE {
//    Return true if the given string contains between 1 and 3 'e' chars.
//
//
//            stringE("Hello") → true
//    stringE("Heelle") → true
//    stringE("Heelele") → false

    public boolean stringE(String str) {
        int count = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) == 'e')
                count += 1;
        }
        if (count >= 1 && count <= 3) return true;
        return false;
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "heleelo";
        String str3 = "helleee";
        StringE res = new StringE();
        System.out.println(res.stringE(str1));
        System.out.println(res.stringE(str2));
        System.out.println(res.stringE(str3));
    }
}
