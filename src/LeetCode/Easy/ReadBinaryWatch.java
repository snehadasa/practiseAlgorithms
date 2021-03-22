package LeetCode.Easy;

import java.util.*;

public class ReadBinaryWatch {
//    A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the
//    minutes (0-59).
//
//    Each LED represents a zero or one, with the least significant bit on the right.
//
//
//    For example, the above binary watch reads "3:25".
//
//    Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times
//    the watch could represent.
//
//            Example:
//
//    Input: n = 1
//    Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
//    Note:
//    The order of output does not matter.
//    The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
//    The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should
//        be "10:02".

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int min = 0; min < 60; min++) {
                if (Integer.bitCount(h) + Integer.bitCount(min) == num) {
                    res.add(String.format("%d:%02d", h, min));
                }
            }
        }
        return res;
    }

    public List<String> readBinaryWatch1(int num) {
        Map<Integer, List<Integer>> hrMap = new HashMap<>();
        Map<Integer, List<Integer>> minMap = new HashMap<>();
        List<String> results = new ArrayList<>();
        prepareHrMap(hrMap);
        prepareMinMap(minMap);
        for(int i=0; i<=3; i++) {
            if(!hrMap.containsKey(i) || !minMap.containsKey(num-i))
                continue;
            List<Integer> hrList = hrMap.get(i);
            List<Integer> minList = minMap.get(num-i);
            for(int a=0; a<hrList.size(); a++ ) {
                for(int b=0; b<minList.size(); b++ ) {
                    results.add(hrList.get(a)+":"+((minList.get(b)<10)?"0"+minList.get(b):minList.get(b)));
                }
            }
        }
        return results;
    }

    private void prepareHrMap(Map<Integer,List<Integer>> map) {
        map.put(0, Arrays.asList(0));
        map.put(1, Arrays.asList(1,2,4,8));
        map.put(2, Arrays.asList(3,5,6,9,10));
        map.put(3, Arrays.asList(7,11));
    }

    private void prepareMinMap(Map<Integer,List<Integer>> map) {
        map.put(0, Arrays.asList(0));
        map.put(1, Arrays.asList(1,2,4,8,16,32));
        map.put(2, Arrays.asList(3,5,6,9,10,12,17,18,20,24,33,34,36,40,48));
        map.put(3, Arrays.asList(7,11,13,14,19,21,22,25,26,28,35,37,38,41,42,44,49,50,52,56));
        map.put(4, Arrays.asList(15,23,27,29,30,39,43,45,46,51,53,54,57,58));
        map.put(5, Arrays.asList(31,47,55,59));
    }

    public static void main(String[] args) {
        int num = 1;
        ReadBinaryWatch res = new ReadBinaryWatch();
        System.out.println(res.readBinaryWatch(num));
    }
}
