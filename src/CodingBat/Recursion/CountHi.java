package CodingBat.Recursion;

public class CountHi {
    public int countHi(String str) {
        if (str.length() < 2) {
            return 0;
        }
        if (str.charAt(0) == 'h' && str.charAt(1) == 'i') {
            return 1 + countHi(str.substring(1));
        }
        return countHi(str.substring(1));
    }

//    public int countHi(String str) {
//        if (str.length() <= 1) return 0;
//        int count = 0;
//        if (str.substring(0, 2).equals("hi")) count = 1;  // could use startsWith()
//        return count + countHi(str.substring(1));
//    }

    public static void main(String[] args) {
        CountHi res = new CountHi();
        System.out.println(res.countHi("khihijhisdhias"));
    }
}
