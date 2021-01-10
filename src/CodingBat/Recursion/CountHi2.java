package CodingBat.Recursion;

public class CountHi2 {

//    Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count
//        "hi" that have an 'x' immedately before them.
//
//
//            countHi2("ahixhi") → 1
//    countHi2("ahibhi") → 2
//    countHi2("xhixhi") → 0

   public int countHi2(String str) {
       if (str.length() < 2) {
           return 0;
       }
       if (str.substring(0, 2).equals("hi")) {
           return 1 + countHi3(str.substring(1));
       }
       return countHi3(str);
   }
    public int countHi3(String str) {
        if (str.length() <= 2) {
            return 0;
        }
        if (str.charAt(0) != 'x' && str.substring(1, 3).equals("hi")) {
            return 1 + countHi3(str.substring(1));
        }
        return countHi3(str.substring(1));
    }


    public static void main(String[] args) {
        CountHi2 res = new CountHi2();

        System.out.println(res.countHi2("hibhichi"));
        System.out.println(res.countHi2("ahibhichi"));
        System.out.println(res.countHi2("xxxhibhichi"));
    }
}
