package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome {
//    Given a string s which consists of lowercase or uppercase letters, return the length of the longest
//    palindrome that can be built with those letters.
//
//    Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//
//
//
//    Example 1:
//
//    Input: s = "abccccdd"
//    Output: 7
//    Explanation:
//    One longest palindrome that can be built is "dccaccd", whose length is 7.
//    Example 2:
//
//    Input: s = "a"
//    Output: 1
//    Example 3:
//
//    Input: s = "bb"
//    Output: 2
//
//
//    Constraints:
//
//            1 <= s.length <= 2000
//    s consists of lowercase and/or uppercase English letters only.

    public boolean isPalindrome(String s) {
        StringBuilder reverse = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            reverse.append(s.charAt(i));
        }

        if (s.toLowerCase().equals(reverse.toString().toLowerCase())) {
            return true;
        }
        return false;
     }
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int value = map.get(c);
                map.put(c, 1 + value);
            } else {
                map.put(c, 1);
            }
        }
        int countEven = 0;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                countEven += entry.getValue();
                //even.add(entry.getValue());
            } else {
                odd.add(entry.getValue());
            }
        }
        int countOdd = 0;
        //int evenSum = 0;


        for (int i = 0; i < odd.size(); i++) {
            countOdd += (odd.get(i) - 1);
        }

        return countEven + countOdd + (odd.size() > 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        LongestPalindrome res = new LongestPalindrome();
//        String s1 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonag" +
//                "reatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhohere" +
//                "gavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewe" +
//                "cannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehave" +
//                "consecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayh" +
//                "erebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhic" +
//                "htheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingb" +
//                "eforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureof" +
//                "devotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewb" +
//                "irthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        String s1 = "bananas";
        String s2 = "bb";
        System.out.println(res.longestPalindrome(s1));
        //System.out.println(res.longestPalindrome(s2));
    }
}
