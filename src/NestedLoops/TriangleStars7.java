package NestedLoops;

public class TriangleStars7 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < (i*2); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 5; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
