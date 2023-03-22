package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8958 {

    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void solution(String s) {

        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'O') {
                cnt++;
                sum += cnt;
            } else {
                cnt = 0;
            }

        }
        sb.append(sum).append('\n');


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String s = br.readLine();
            solution(s);

        }

        System.out.println(sb);


    }

}
