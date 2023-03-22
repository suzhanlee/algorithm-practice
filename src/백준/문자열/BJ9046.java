package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ9046 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static Character solution(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        Character answer = null;

        for (char x : str.toCharArray()) {

            if (x != ' ') {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

        }

        for (Map.Entry<Character, Integer> x : map.entrySet()) {

            if (x.getValue() >= max) {
                max = x.getValue();
                answer = x.getKey();
            }
        }

        for (Map.Entry<Character, Integer> x : map.entrySet()) {

            if (x.getValue() == max) {
                cnt++;
            }
        }

        if (cnt != 1) {
            return '?';
        } else {
            return answer;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            sb.append(solution(str)).append('\n');

        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }

}
