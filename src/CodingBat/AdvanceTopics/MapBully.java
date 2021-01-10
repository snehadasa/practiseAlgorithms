package CodingBat.AdvanceTopics;

import java.util.HashMap;
import java.util.Map;

public class MapBully {

//    Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that value, and set
//    the key "a" to have the value "". Basically "b" is a bully, taking the value and replacing it with the empty string.
//
//
//    mapBully({"a": "candy", "b": "dirt"}) → {"a": "", "b": "candy"}
//    mapBully({"a": "candy"}) → {"a": "", "b": "candy"}
//    mapBully({"a": "candy", "b": "carrot", "c": "meh"}) → {"a": "", "b": "candy", "c": "meh"}

    public Map<String, String> mapBully(Map<String, String> map) {
        Map<String, String> newMap = new HashMap<String, String>();

        if (map.containsKey("a")) {
            newMap.put("b", map.get("a"));
            newMap.put("a", "");
        }
        if (map.containsKey("b") && (!map.containsKey("a"))) {
            newMap.put("b", map.get("b"));
        }
        if (map.containsKey("c")) {
            newMap.put("c", map.get("c"));
        }
        // }
        return newMap;
    }

//    public Map<String, String> mapBully(Map<String, String> map) {
//        if (map.containsKey("a")) {
//            map.put("b", map.get("a"));
//            map.put("a", "");
//        }
//        return map;
//    }


    public static void main(String[] args) {
        Map<String, String> str = new HashMap<>();
        str.put("a","candy");
        str.put("b","carrot");
        str.put("c","meh");
        MapBully res = new MapBully();
        System.out.println(res.mapBully(str));
    }
}
