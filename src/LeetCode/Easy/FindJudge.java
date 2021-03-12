package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindJudge {
//    In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
//
//    If the town judge exists, then:
//
//    The town judge trusts nobody.
//            Everybody (except for the town judge) trusts the town judge.
//    There is exactly one person that satisfies properties 1 and 2.
//    You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the
//    person labelled b.
//
//    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
//
//
//
//    Example 1:
//
//    Input: N = 2, trust = [[1,2]]
//    Output: 2
//    Example 2:
//
//    Input: N = 3, trust = [[1,3],[2,3]]
//    Output: 3
//    Example 3:
//
//    Input: N = 3, trust = [[1,3],[2,3],[3,1]]
//    Output: -1
//    Example 4:
//
//    Input: N = 3, trust = [[1,2],[2,3]]
//    Output: -1
//    Example 5:
//
//    Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//    Output: 3
//
//
//    Constraints:
//
//            1 <= N <= 1000
//            0 <= trust.length <= 10^4
//    trust[i].length == 2
//    trust[i] are all different
//    trust[i][0] != trust[i][1]
//            1 <= trust[i][0], trust[i][1] <= N

    public int findJudge1(int N, int[][] trust) {
        int judge = -1;
        for (int i = 0; i < trust.length-1; i++) {
            for (int j = 0; j < trust[0].length; j++) {
                if (trust[i][j] == trust[i+1][j]) {
                    judge = trust[i][j];
                }
            }
        }
        return judge;

    }

//    So to make things easy to understand, we can say we are trying to find the element, who doesn’t like anybody,
//    but is being liked by N-1 persons in the town. How can we keep track of the number of times an element likes and
//    being liked? We use hash.
//    To calculate two different numbers of likes and being liked, we set the keys of hashes from 1 to N, so we wouldn’t
//    miss any number. And we loop through the trust array to increment the count of likes and being liked according to
//    the element order of the subarray. The code looks like the following.
    public int findJudge(int N, int[][] trust) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {
            set.add(trust[i][0]);
            if (map.containsKey(trust[i][1])) {
                int value = map.get(trust[i][1]);
                map.put(trust[i][1], 1+value);
            } else {
                map.put(trust[i][1], 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (!set.contains(key) && map.get(key) == N-1) {
                return key;
            }
        }
        return -1;
    }

        public static void main(String[] args) {
        int n1 = 3, n2 = 2;
        int[][] trust1 = {{1,3},{2,3}};
        int[][] trust2 = {{1,2}};
        FindJudge res = new FindJudge();
        System.out.println(res.findJudge(n1, trust1));
        System.out.println(res.findJudge(n2, trust2));
    }
}
