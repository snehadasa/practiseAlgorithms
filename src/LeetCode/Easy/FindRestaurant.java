package LeetCode.Easy;

import CodingBat.StringMatch;

import java.util.*;

public class FindRestaurant {
//    Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
//    represented by strings.
//
//    You need to help them find out their common interest with the least list index sum. If there is a choice tie
//    between answers, output all of them with no order requirement. You could assume there always exists an answer.
//
//
//
//    Example 1:
//
//    Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines",
//    "Hungry Hunter Steakhouse","Shogun"]
//    Output: ["Shogun"]
//    Explanation: The only restaurant they both like is "Shogun".
//    Example 2:
//
//    Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
//    Output: ["Shogun"]
//    Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
//    Example 3:
//
//    Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger King","Tapioca Express","Shogun"]
//    Output: ["KFC","Burger King","Tapioca Express","Shogun"]
//    Example 4:
//
//    Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
//    Output: ["KFC","Burger King","Tapioca Express","Shogun"]
//    Example 5:
//
//    Input: list1 = ["KFC"], list2 = ["KFC"]
//    Output: ["KFC"]
//
//
//    Constraints:
//
//            1 <= list1.length, list2.length <= 1000
//            1 <= list1[i].length, list2[i].length <= 30
//    list1[i] and list2[i] consist of spaces ' ' and English letters.
//    All the stings of list1 are unique.
//    All the stings of list2 are unique.

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j)) {
                        map.put(i + j, new ArrayList<>());
                    }
                    map.get(i + j).add(list1[i]);
                }
            }
        }

        //to find minimun index sum (i+j)
        int minIndexSum = Integer.MAX_VALUE;

        for (Integer key : map.keySet()) {
            minIndexSum = Math.min(minIndexSum, key);
        }
        String[] res = new String[map.get(minIndexSum).size()];

        return map.get(minIndexSum).toArray(res);
    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for(int i = 0 ; i < list1.length ; i++) {
            map1.put(list1[i], i);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < list2.length ; i++) {
            map2.put(list2[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for(String r: map1.keySet()) {
            Integer idx1 = map1.get(r);
            Integer idx2 = map2.get(r);
            if (idx1 != null && idx2 != null) {
                int sum = idx1 + idx2;
                if (sum < minSum) {
                    result.clear();
                    result.add(r);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(r);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        FindRestaurant res = new FindRestaurant();
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KNN","KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(Arrays.toString(res.findRestaurant(list1, list2)));
    }
}
