package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5347 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void solution(Long i1, Long i2) {

        Long gcd = 0L;

        Long min = Math.min(i1, i2);

        for (int i = 1; i <= min; i++) {
            if (i1 % i == 0 && i2 % i == 0) {
                gcd = (long) i;
            }
        }

        sb.append(i1 * i2 / gcd).append('\n');


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            Long i1 = Long.valueOf(st.nextToken());
            Long i2 = Long.valueOf(st.nextToken());

            solution(i1, i2);
        }

        System.out.println(sb);

    }
}
