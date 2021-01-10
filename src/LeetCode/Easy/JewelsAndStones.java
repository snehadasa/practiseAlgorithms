package LeetCode.Easy;

public class JewelsAndStones {
//    You're given strings jewels representing the types of stones that are jewels, and stones representing the stones
//    you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have
//    are also jewels.
//
//    Letters are case sensitive, so "a" is considered a different type of stone from "A".
//
//
//
//    Example 1:
//
//    Input: jewels = "aA", stones = "aAAbbbb"
//    Output: 3
//    Example 2:
//
//    Input: jewels = "z", stones = "ZZ"
//    Output: 0
//
//
//    Constraints:
//
//            1 <= jewels.length, stones.length <= 50
//    jewels and stones consist of only English letters.
//    All the characters of jewels are unique.

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0, countnewA = 0;
        char stonesA[] = stones.toCharArray();
        char jewelA[] = jewels.toCharArray();

        for (int i = 0; i < stonesA.length; i++) {  //for every stones in the array,
            for (int j = 0; j < jewelA.length; j++) {  //jewel array has to repeat(checking each and every element if it is a jewel)
                if (stonesA[i] == jewelA[j]) {  //if they are equal, increase the count;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones res = new JewelsAndStones();
        String jewels = "z", stones = "zzz";

        System.out.println(res.numJewelsInStones(jewels, stones));
    }
}
