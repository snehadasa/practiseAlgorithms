package NestedLoops;

public class TriangleStars4 {

    public static void main(String[] args) {
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < i; j++) {   //spaces are printed till j is less than i
                System.out.print(" ");
            }
            for (int k = 5; k >= i; k--) {  //stars are printing from back
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
