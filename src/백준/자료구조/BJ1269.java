package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1269 {

    static int N, M; // 집합 a의 원소 개수, 집합 b의 원소 개수
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int answer;

    public static void solution() {

        map.forEach((key, value) -> {
            if (value == 1) {
                answer++;
            }
        });

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer stN = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            int k = Integer.parseInt(stN.nextToken());
            map.put(k, map.getOrDefault(k, 0) + 1);

        }

        StringTokenizer stM = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {

            int k = Integer.parseInt(stM.nextToken());
            map.put(k, map.getOrDefault(k, 0) + 1);

        }

        solution();

        System.out.println(answer);

    }

}
