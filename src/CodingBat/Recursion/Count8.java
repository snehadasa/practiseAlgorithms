package CodingBat.Recursion;

public class Count8 {
    public int count8(int n) {
        if (n < 1) {
            return 0;
        }
        if (n%10 == 8 && n % 100 == 88) {
            return 2+count8(n/10);
        } else
        if (n%10 == 8) {
            return 1+count8(n/10);
        } else
            return count8(n/10);
    }

    public static void main(String[] args) {
        Count8 res = new Count8();
        System.out.println(res.count8(87988228));
    }
}
