package CodingBat.Testing;

public class ConversionToBnary {

    public int conversionToBinary(int n) {
        int decValue = 0;
        int base = 1;
        int temp = n;
        while (temp > 0) {
            int last = temp%10;
            temp = temp/10;

            decValue += last * base;
            base *= 2;
        }
        return decValue;
    }

    public static void main(String[] args) {
        int n = 111, n2 = 101;
        ConversionToBnary res = new ConversionToBnary();
        System.out.println(res.conversionToBinary(n));
        System.out.println(res.conversionToBinary(n2));
    }
}
