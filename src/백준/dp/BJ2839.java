package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839 {

    static int N;
    static int[] dp;
    static int answer = Integer.MAX_VALUE;
    static boolean flag = false;

    public static int dp(int L, int sum) {

        if (flag) {
            return -1;
        }

        if (sum > N) {
            return -1;

        }

        if (sum == N) {
            answer = L;
            flag = true;
            return -1;

        } else {

            dp[sum + 5] = dp(L + 1, sum + 5);
            dp[sum + 3] = dp(L + 1, sum + 3);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[50001];

        dp(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}
