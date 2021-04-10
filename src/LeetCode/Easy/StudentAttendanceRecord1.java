package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class StudentAttendanceRecord1 {
//    You are given a string s representing an attendance record for a student where each character signifies whether
//    the student was absent, late, or present on that day. The record only contains the following three characters:
//
//            'A': Absent.
//'L': Late.
//'P': Present.
//    The student is eligible for an attendance award if they meet both of the following criteria:
//
//    The student was absent ('A') for strictly fewer than 2 days total.
//    The student was never late ('L') for 3 or more consecutive days.
//    Return true if the student is eligible for an attendance award, or false otherwise.
//
//
//
//            Example 1:
//
//    Input: s = "PPALLP"
//    Output: true
//    Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
//    Example 2:
//
//    Input: s = "PPALLL"
//    Output: false
//    Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
//
//
//    Constraints:
//
//            1 <= s.length <= 1000
//    s[i] is either 'A', 'L', or 'P'.

    public boolean threeConsecutiveL(String s) {
        int count = 0;
        for(int i=0; i<s.length()-1; i++){
            count = 0;
            while (i < s.length() && s.charAt(i) == 'L') {
                count++;
                i++;

                if (count >= 3) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRecord(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] charArr = s.toCharArray();

        for (char ch : charArr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int absent = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == 'A') {
               absent = entry.getValue();
            }
        }

        if (absent < 2 && threeConsecutiveL(s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "LLPPPLL";
        String s2 = "PPALLL";
        StudentAttendanceRecord1 res = new StudentAttendanceRecord1();
        System.out.println(res.threeConsecutiveL(s1));
        System.out.println(res.threeConsecutiveL(s2));
        //System.out.println(res.checkRecord(s1));
        //System.out.println(res.checkRecord(s2));
    }
}
