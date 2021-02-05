package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class GridIllumination2 {
    static boolean ifLampLightsTheCell(List<Integer> lamp, List<Integer> cell) {
        int lampX = lamp.get(0);
        int lampY = lamp.get(1);
        int cellX = cell.get(0);
        int cellY = cell.get(1);

        if (lampX == cellX || lampY == cellY || Math.abs(lampX - cellX) == Math.abs(lampY-cellY)) {
            if (Math.abs(lampX - cellX) <= 1 && Math.abs(lampY-cellY) <= 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    static List<String> checkIllumination(int N, List<List<Integer>> lamps, List<List<Integer>> queries) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            String append = "DARK";
            for (int j = 0; j < lamps.size(); j++) {
                if (ifLampLightsTheCell(lamps.get(j), queries.get(i))) {
                    append = "LIGHT";
                    break;
                }
            }
            res.add(append);
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 8;
        List<List<Integer>> lamps = new ArrayList<>();
        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> lamp1 = new ArrayList<>();
        List<Integer> lamp2 = new ArrayList<>();
        List<Integer> query1 = new ArrayList<>();
        List<Integer> query2 = new ArrayList<>();

        lamp1.add(4);
        lamp1.add(3);
        lamp2.add(4);
        lamp2.add(4);
        lamps.add(lamp1);
        lamps.add(lamp2);

        query1.add(3);
        query1.add(4);
        query2.add(7);
        query2.add(6);
        queries.add(query1);
        queries.add(query2);

        System.out.println(checkIllumination(N, lamps, queries));
    }
}

