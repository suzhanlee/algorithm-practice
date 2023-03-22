package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2609 {

    static int N, K;
    static StringBuilder sb = new StringBuilder();

    public static StringBuilder solution() {

        int min = Math.min(N, K);
        int gcd = 0;

        for (int i = 1; i <= min; i++) {

            if (N % i == 0 && K % i == 0) {
                gcd = i;
            }
        }

        return sb.append(gcd).append('\n').append(N * K / gcd);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(solution());


    }
}
