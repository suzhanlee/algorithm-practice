package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1969 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int answer;
    static String[] str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                map.put(str[j].charAt(i), map.getOrDefault(str[j].charAt(i), 0) + 1);
            }

            int max = Integer.MIN_VALUE;
            Character value = null;

            for (Map.Entry<Character, Integer> keySet : map.entrySet()) {
                if (max == keySet.getValue()) {
                    if (value - '0' > keySet.getKey() - '0') {
                        value = keySet.getKey();
                    }
                } else if (max < keySet.getValue()) {
                    max = keySet.getValue();
                    value = keySet.getKey();
                }
            }

            sb.append(value);

            for (Map.Entry<Character, Integer> keySet : map.entrySet()) {
                if (value != keySet.getKey()) {
                    answer += keySet.getValue();
                }
            }
        }

        System.out.println(sb);
        System.out.println(answer);
    }

}
