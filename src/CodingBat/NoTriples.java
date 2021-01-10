package CodingBat;

public class NoTriples {

//    Given an array of ints, we'll say that a triple is a value appearing 3 times in a row
//    in the array. Return true if the array does not contain any triples.
//
//
//    noTriples([1, 1, 2, 2, 1]) → true
//    noTriples([1, 1, 2, 2, 2, 1]) → false
//    noTriples([1, 1, 1, 2, 2, 2, 1]) → false

    public boolean noTriples(int[] nums) {
        //int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums.length >= 3 && ((nums[i] == nums[i+1]) && (nums[i] == nums[i+2])))
                return false;
        }
        return true;
    }

//    public boolean noTriples(int[] nums) {
//        // Iterate < length-2, so can use i+1 and i+2 in the loop.
//        // Return false immediately if every seeing a triple.
//        for (int i=0; i < (nums.length-2); i++) {
//            int first = nums[i];
//            if (nums[i+1]==first && nums[i+2]==first) return false;
//        }
//
//        // If we get here ... no triples.
//        return true;
//    }

    public static void main(String[] args) {
        int[] num1 = {1, 1, 2, 2, 1};
        int[] num2 = {1, 1, 2, 2, 2, 1};
        int[] num3 = {1, 1, 1, 2, 2, 2, 1};
        NoTriples res = new NoTriples();
        System.out.println(res.noTriples(num1));
        System.out.println(res.noTriples(num2));
        System.out.println(res.noTriples(num3));
    }
}
