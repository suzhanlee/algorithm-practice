package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ2577 {

    static int A, B, C;
    static long num;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void solution() {

        num = (long) A * B * C;
        String str = String.valueOf(num);

        for (int i = 0; i < str.length(); i++) {

            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

        }

        sb.append(map.getOrDefault('0', 0)).append('\n');

        for (int i = 1; i <= 9; i++) {
            String tmp = String.valueOf(i);
            char c = tmp.charAt(0);

            Integer integer = map.getOrDefault(c, 0);
            sb.append(integer).append('\n');

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        solution();

        System.out.println(sb);


    }

}
