package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ2776 {

    static int T;
    static int N, M;
    static HashMap<Integer, Integer> map;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int l = 0; l < T; l++) {
            map = new HashMap<>();

            N = Integer.parseInt(br.readLine());
            StringTokenizer stN = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {

                int k = Integer.parseInt(stN.nextToken());
                map.put(k, map.getOrDefault(k, 0) + 1);

            }

            M = Integer.parseInt(br.readLine());
            StringTokenizer stM = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {

                int k = Integer.parseInt(stM.nextToken());
                Integer a = map.getOrDefault(k, 0);

                if (a == 0) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(1).append('\n');
                }

            }

        }
        System.out.println(sb);
    }
}
