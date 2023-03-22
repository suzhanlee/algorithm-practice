package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010_1 {

    static int T;
    static int N, M;
    static int answer;
    static int[][] dp;

    public static int solution(int N, int M) {

        if(dp[N][M] > 0) {
            return dp[N][M];
        }

        if (N == M) {
            return dp[N][M] = 1;

        } else if (N == 0) {
            return dp[N][M] = 1;

        } else {
            return dp[N][M] = solution(N - 1, M - 1) + solution(N, M - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new int[N + 1][M + 1];

            int solution = solution(N, M);
            System.out.println(solution);


        }


    }

}
