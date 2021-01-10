package CodingBat.Recursion;

public class CountX {
    public int countX(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (str.charAt(0) == 'x') {
            return 1 + countX(str.substring(1));
        }
        return countX(str.substring(1));
    }

    public static void main(String[] args) {
        CountX res = new CountX();
        System.out.println(res.countX("xkjsuduxxxjd"));
    }
}
