package CodingBat.Recursion;

public class PowerN {
    public int powerN(int base, int n) {
        if (n < 1) {
            return 1;
        }
        return base * powerN(base, n-1);
    }

    public static void main(String[] args) {
        PowerN res = new PowerN();
        System.out.println(res.powerN(7, 9));
    }
}
