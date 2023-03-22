package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2748 {

    static long[] dp;

    public static long dfs(int N) {

        dp[0] = 0;

        if (N >= 1) {
            dp[1] = 1;
        }

        if (N >= 2) {
            dp[2] = 1;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];

        System.out.println(dfs(N));

    }

}
