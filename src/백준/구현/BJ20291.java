package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ20291 {

    static int N;
    static ArrayList<String> arr;
    static HashMap<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");

            String file = st.nextToken();
            String x = st.nextToken();

            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr.add(entry.getKey());
        }

        Collections.sort(arr);

        for (String str : arr) {
            sb.append(str).append(" ").append(map.get(str)).append('\n');
        }

        System.out.println(sb);


    }

}
