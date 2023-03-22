package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ14425 {

    static int N, M; // 집합 수 , 문자열 수
    static HashMap<String, Integer> map = new HashMap<>();
    static int answer;

    public static void solution(String str) {

        boolean key = map.containsKey(str);
        if (key) {
            answer++;
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            solution(str);
        }

        System.out.println(answer);

    }
}
