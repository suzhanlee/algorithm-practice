package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {

    static int N;
    static int[] dp;

    public static int dfs(int L) {
//        if(L == 1) {             이렇게도 가능하다!
//            return dp[1] = 1;
//        } else if (L == 2) {
//            return dp[2] = 2;
//        } else {
//            return dp[L] = dfs(L - 1) + dfs(L - 2);
//        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[L];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        System.out.println(dfs(N));

    }
}
