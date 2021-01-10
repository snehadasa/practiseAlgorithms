package CodingBat;

public class BlackJack {

//    Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over.
//
//
//    blackjack(19, 21) → 21
//    blackjack(21, 19) → 21
//    blackjack(19, 22) → 19

    public int blackjack(int a, int b) {
        int n1 = Math.abs(21-a);
        int n2 = Math.abs(21-b);
        if (a > 21 && b > 21) {
            return 0;
        }
        if (a > 21 && b <= 21) {
            return b;
        } else
        if (b > 21 && a<= 21) {
            return a;
        }
        if (n1 > n2) {
            return b;
        }else
        if (n2 > n1) {
            return a;
        }
        return 0;
    }

//    public int blackjack(int a, int b) {
//        // The value of a/b, or 0 if over 21
//        int aVal = a;
//        if (aVal > 21) {
//            aVal = 0;
//        }
//        int bVal = b;
//        if (bVal > 21) {
//            bVal = 0;
//        }
//
//        // Now it works to just return whichever is larger.
//        if (aVal > bVal) {
//            return aVal;
//        }
//        else {
//            return bVal;
//        }
//
//        // You can write a very short version of this same strategy
//        // using the "ternary operator" ?: and Math.max()
//    }

    public static void main(String[] args) {
        BlackJack res = new BlackJack();
        System.out.println(res.blackjack(54, 21));
    }
}
