package 백준.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BJ4358 {

    static HashMap<String, Double> map = new HashMap<>();
    static double totalCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while (true) {
            if (str == null || str.length() == 0) {
                break;
            }
            totalCount++;

            map.put(str, map.getOrDefault(str, (double) 0) + 1);

            str = br.readLine();
        }

        TreeMap<String, Double> treeMap = new TreeMap<>(map);

        for (Map.Entry<String, Double> map : treeMap.entrySet()) {
            System.out.println(
                map.getKey() + " " + String.format("%.4f", map.getValue() * 100 / totalCount));
        }

    }

}
