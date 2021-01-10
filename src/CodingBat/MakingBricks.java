package CodingBat;

public class MakingBricks {

//    We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big
//    bricks (5 inches each). Return true if it is possible to make the goal by choosing from the given bricks. This is a
//    little harder than it looks and can be done without any loops. See also: Introduction to MakeBricks
//
//
//    makeBricks(3, 1, 8) → true
//    makeBricks(3, 1, 9) → false
//    makeBricks(3, 2, 10) → true

    public boolean makeBricks(int small, int big, int goal) {
        int bigBricksRequired = goal/5;
        int smallBricksRequired = goal%5;

        if (bigBricksRequired > big) {  //if number of big bricks req are more than given big bricks.
            smallBricksRequired += (bigBricksRequired - big) * 5;  //small bricks req are bigreq - big * 5 + small req
        }

        if (small >= smallBricksRequired) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MakingBricks res = new MakingBricks();
        System.out.println(res.makeBricks(5, 4, 30));
        System.out.println(res.makeBricks(5, 4, 25));
    }
}
