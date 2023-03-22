package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2407 {

    static int N, M;
    static double[][] dp;

    public static double dfs(int N, int M) {

        if (dp[N][M] != 0) {
            return dp[N][M];
        }

        if (M == 1) {
            return dp[N][M] = N;

        } else if (N == M) {
            return dp[N][M] = 1;

        } else {
            return dp[N][M] = dfs(N - 1, M - 1) + dfs(N - 1, M);
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new double[N + 1][M + 1];

        double answer = dfs(N, M);
        System.out.println(answer);


    }

}
