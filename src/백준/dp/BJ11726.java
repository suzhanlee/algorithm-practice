package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11726 {

    static int N;
    static long answer;
    static int[] dp;

    public static void solution() {

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 3; i <= N; i++) {

            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

        }

        answer = dp[N];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[10001];

        solution();

        System.out.println(answer);


    }

}
