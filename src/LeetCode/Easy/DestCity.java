package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestCity {
//    You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from
//    cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
//
//    It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly
//    one destination city.
//
//
//
//    Example 1:
//
//    Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
//    Output: "Sao Paulo"
//    Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your
//    trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
//    Example 2:
//
//    Input: paths = [["B","C"],["D","B"],["C","A"]]
//    Output: "A"
//    Explanation: All possible trips are:
//            "D" -> "B" -> "C" -> "A".
//            "B" -> "C" -> "A".
//            "C" -> "A".
//            "A".
//    Clearly the destination city is "A".
//    Example 3:
//
//    Input: paths = [["A","Z"]]
//    Output: "Z"
//
//
//    Constraints:
//
//            1 <= paths.length <= 100
//    paths[i].length == 2
//            1 <= cityAi.length, cityBi.length <= 10
//    cityAi != cityBi
//    All strings consist of lowercase and uppercase English letters and the space character.

    public String destCity1(List<List<String>> paths) {
        String isEndDestination = "";
        for (int i = 0; i < paths.size(); i++) {
            isEndDestination = paths.get(i).get(1);
            boolean end = true;
            for (int j = 0; j < paths.size(); j++) {
                if (paths.get(j).get(0).equals(isEndDestination)){
                    end = false;
                    break;
                }
            }
            if (end){
                return isEndDestination;
            }
        }
        return isEndDestination;
    }

    public String destCity(List<List<String>> paths) {
        for (int i = 0 ; i < paths.size(); i++) {
            String to =  paths.get(i).get(1);
            boolean lastLink  = true;
            for (int j = 0; j < paths.size(); j++) {
                if (to == paths.get(j).get(0)) {
                    lastLink = false;
                }
            }
            if (lastLink) {
                return to;
            }
        }
        return "";
    }

    public String destCity2(List<List<String>> paths) {
        Map <String, String> routes = new HashMap<>();
        for (List<String> path:paths) {
            String from = path.get(0);
            String to = path.get(1);
            routes.put(from, to);
        }

        String dest = paths.get(0).get(0);  //checking whether destination is in keys and not in values.
        while (routes.containsKey(dest)) {    ////if paths[i] is only in keys then it is the destination.
            dest = routes.get(dest);
        }
        return dest;
    }

        public static void main(String[] args) {
        ArrayList<List<String>> paths = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        list1.add("London");
        list1.add("NewYork");
        list2.add("NewYork");
        list2.add("Lima");
        list3.add("Lima");
        list3.add("San Paulo");

        paths.add(list1);
        paths.add(list2);
        paths.add(list3);

        DestCity res = new DestCity();
            System.out.println(res.destCity(paths));
    }
}
