package LeetCode.Easy;

import java.util.*;

public class AssignCookies {
//    Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at
//    most one cookie.
//
//    Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
//    and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i
//    will be content. Your goal is to maximize the number of your content children and output the maximum number.
//
//
//
//
//
//    Example 1:
//
//    Input: g = [1,2,3], s = [1,1]
//    Output: 1
//    Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
//    And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor
//    is 1 content.
//    You need to output 1.
//    Example 2:
//
//    Input: g = [1,2], s = [1,2,3]
//    Output: 2
//    Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
//    You have 3 cookies and their sizes are big enough to gratify all of the children,
//    You need to output 2.
//
//
//    Constraints:
//
//            1 <= g.length <= 3 * 104
//            0 <= s.length <= 3 * 104
//            1 <= g[i], s[j] <= 231 - 1

    public int findContentChildren1(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    count++;
                    g[i] = -1;
                    s[j] = -1;
                    break;
                }
            }
        }
        return count;
    }

    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
        }
        return count;
    }


//        for (int i = 0, j = 0; i < g.length && j < s.length; i++) {
//            if (s[j] >= g[i]) {
//                count++;
//                g[i] = -1;
//                s[j] = -1;
//                j++;
//            }
    //}

//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int group: g) {
//            map.put(group, map.getOrDefault(group, 0) + 1);
//        }
//        for (int cookie: s) {
//            map.put(cookie, map.getOrDefault(cookie, 0) + 1);
//        }
//        List<Integer> list = new ArrayList<>();
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() >= 2) {
//                list.add(entry.getKey());
//            }
//        }
//    }

    public static void main(String[] args) {
        AssignCookies res = new AssignCookies();
        int[] g1 = {1, 2}, g2 = {10, 9, 8, 7};
        int[] s1 = {1, 2, 3}, s2 = {5, 6, 7, 8};
        System.out.println(res.findContentChildren(g1, s1));
        System.out.println(res.findContentChildren(g2, s2));
    }
}
