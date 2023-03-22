package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1934 {

    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void solution(int i1, int i2) {

        int gcd = 0;
        int min = Math.min(i1, i2);

        for (int i = 1; i <= min; i++) {
            if (i1 % i == 0 && i2 % i == 0) {
                gcd = i;
            }
        }

        sb.append(i1 * i2 / gcd).append('\n');
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            solution(i1, i2);
        }

        System.out.println(sb);


    }

}
