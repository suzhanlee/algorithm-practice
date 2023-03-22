package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BJ2108 {

    static double N;
    static long[] arr;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Long, Long> map = new HashMap<>();

    public static void solution() {

        double sum = 0;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

        }

        long frequent = Integer.MIN_VALUE;

        for (Map.Entry<Long, Long> map : map.entrySet()) {
            frequent = Math.max(frequent, map.getValue());
        }

        ArrayList<Long> arrayList = new ArrayList<>();

        for (Map.Entry<Long, Long> map : map.entrySet()) {
            if (map.getValue() == frequent) {
                arrayList.add(map.getKey());
            }
        }

        Collections.sort(arrayList);

        double average = sum / N;
        average = Math.round(average);
        sb.append((int) average).append('\n');
        sb.append(arr[(arr.length / 2)]).append('\n');
        if (arrayList.size() >= 2) {
            sb.append(arrayList.get(1)).append('\n');
        } else {
            sb.append(arrayList.get(0)).append('\n');
        }
        sb.append(max - min);


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Double.parseDouble(br.readLine());

        arr = new long[(int) N];

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();
        System.out.println(sb);

    }

}
