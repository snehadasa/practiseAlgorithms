package NestedLoops;

public class TriangleStars9 {
    public static void main(String[] args) {
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 8-i-1; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < 2*i; k++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
