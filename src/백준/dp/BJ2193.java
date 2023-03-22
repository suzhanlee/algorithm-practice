package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2193 {

    static long dp[];
    static int N;

    public static void solution() {
        // d[n] = n자리 이친수.

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];

        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];

        solution();


    }


}
