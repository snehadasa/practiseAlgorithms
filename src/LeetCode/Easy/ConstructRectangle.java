package LeetCode.Easy;

import java.util.*;
import java.util.stream.Stream;

public class ConstructRectangle {
//    A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area,
//    your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
//
//    The area of the rectangular web page you designed must equal to the given target area.
//    The width W should not be larger than the length L, which means L >= W.
//    The difference between length L and width W should be as small as possible.
//    Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.
//
//
//
//            Example 1:
//
//    Input: area = 4
//    Output: [2,2]
//    Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
//    But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to
//    [2,2]. So the length L is 2, and the width W is 2.
//    Example 2:
//
//    Input: area = 37
//    Output: [37,1]
//    Example 3:
//
//    Input: area = 122122
//    Output: [427,286]
//
//
//    Constraints:
//
//            1 <= area <= 107


    class Pair {

        private Integer a;
        private Integer b;

        public Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
        public Integer getA() {
            return a;
        }

        public Integer getB() {
            return b;
        }

    }

    public int[] constructRectangle1(int area) {
        List<Pair> list = new ArrayList<>();

        for (int i = 1; i <= area; i++) {
            for (int j = 1; j <= i; j++) {
                if (i * j >= area) {
                    list.add(new Pair(i, j));
                }
            }
        }

        int minDiff = list.get(0).a - list.get(0).b;
        Pair minDiffPair = list.get(0);

        for (Pair pair : list) {
            int diff = pair.a - pair.b;
            if (diff < minDiff) {
                minDiff = diff;
                minDiffPair = pair;
            }
        }
//        for (int i = 1; i < list.size(); i++) {
//            int diff = list.get(i).a - list.get(i).b;
//            if (diff < minDiff) {
//                minDiff = diff;
//                minDiffPair = list.get(i);
//            }
//        }

        int res[] = {minDiffPair.getA(), minDiffPair.getB()};
        return res;
    }

    public int[] factorialIntoArr(int num) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            if (num%i == 0) {
                factors.add(i);
            }
        }

        int[] array = factors.stream().mapToInt(i->i).toArray();

        return array;
    }

    public int roundOff(double num) {
        double round = Math.round(num * 100.0) / 100.0;
        return (int)round;
    }

    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        for (int i = (int) Math.ceil(Math.sqrt(area)); i <= area; i++) {
            if (area % i == 0) {
                res[0] = i;
                res[1] = area / i;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ConstructRectangle res = new ConstructRectangle();
        int area = 4;
        //System.out.println(Arrays.toString(res.factorialIntoArr(area)));
        System.out.println(Arrays.toString(res.constructRectangle(area)));
    }
}
