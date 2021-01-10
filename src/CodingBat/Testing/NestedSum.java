package CodingBat.Testing;

public class NestedSum {

//    public static void main(String s[])
//    {
//        printFormation(5);
//
//    }
//
//
//    public static void printFormation(int size) {
//        for (int i = 1; i <= size; i++) {
//            for (int j = 1; j <= size; j++) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
