package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌다리건너기 {

    static int N;
    static int[] dp;

    public static int solution(int L) {

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[L + 1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 2];

        System.out.println(solution(N));


    }

}
