package CodingBat;

public class CatDog {

//    Return true if the string "cat" and "dog" appear the same number of times in the given string.
//
//
//    catDog("catdog") → true
//    catDog("catcat") → false
//    catDog("1cat1cadodog") → true

    public boolean catDog(String str) {
       // char[] chars = str.toCharArray();
        int dogCount = 0, catCount = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (i <= str.length() - 3 && str.substring(i, i+3).equals("cat")) {
                catCount++;
                i+=2;
            }
            if (i <= str.length() - 3 && str.substring(i, i+3).equals("dog")) {
                dogCount++;
                i+=2;
            }
        }
        return (dogCount == catCount);
    }

    public static void main(String[] args) {
        String str1 = "catdog";
        String str2 = "catcat";
        String str3 = "1cat1cadodog";


        CatDog res = new CatDog();
        System.out.println(res.catDog(str1));
        System.out.println(res.catDog(str2));
        System.out.println(res.catDog(str3));
    }
}
