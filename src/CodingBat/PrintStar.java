package CodingBat;

public class PrintStar {
    //Print star using nested loop

    public void printStar(int width, int height) {
        for (int row = 0; row <= height; row++) {
           // System.out.print("*");
            System.out.println();

            for (int col = row-1; col <= width; col++) {
                System.out.print("*");
            }
        }
    }

    public static void main(String[] args) {
        int width1 = 5, height1 = 7;
        PrintStar res = new PrintStar();

        res.printStar(width1, height1);
    }
}
