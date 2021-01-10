package CodingBat;

public class LcfOfNumbers {

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }

    public int lcm(int a, int b) {
        return (a/gcd(a, b) * b);
    }

    public int hcf(int a, int b) {
        if (b==0) {
            return a;
        }
        return hcf(a, a%b);
    }

    public static void main(String[] args) {
        int a = 15, b = 20;
        LcfOfNumbers res = new LcfOfNumbers();
        System.out.println(res.lcm(a, b));
        System.out.println(res.hcf(a, b));
    }
}
