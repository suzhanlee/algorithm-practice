package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BJ20291 { //split 함수 사용시 왜 "." 은 안되고, "\\." 이렇게 써야 되는 걸까?

    static int N;
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<String> arrayList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] split = str.split("\\.");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

        for (Map.Entry<String, Integer> x : map.entrySet()) {
            arrayList.add(x.getKey());
        }

        Collections.sort(arrayList);

        for (String x : arrayList) {
            sb.append(x).append(" ").append(map.get(x)).append('\n');
        }

        System.out.println(sb);

    }

}
