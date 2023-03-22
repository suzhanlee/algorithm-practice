package 백준.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ10986 {

    static int N, M;
    static long[] sum;
    static long answer;
    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new long[N + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st1.nextToken())) % M;

        }

        for (int i = 0; i <= N; i++) {
            map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1);
        }

        map.forEach((key, value) -> {
            answer += value * (value - 1) / 2;
        });

        System.out.println(answer);


    }

}
