package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2023 {

    static int N;
//    static long[] dp;

    public static void dfs(int L, int num) {

        if (L == N - 1) {
            boolean prime = isPrime(num);
            if (prime) {
                System.out.println(num);
            }

        } else {

            for (int i = 1; i <= 9; i++) {
                boolean prime = isPrime(num * 10 + i);
                if (prime) {
                    dfs(L + 1, num * 10 + i);

                }
            }
        }
    }

    private static boolean isPrime(int num) {

//        if (dp[num] != 1) {

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }

        }
//            dp[num] = 1;
//        }
        return true;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

//        String s = "";
//
//        for (int i = 0; i < N; i++) {
//            s += 9;
//        }
//
//        int end = Integer.parseInt(s);
//
//        dp = new long[end + 1];

        dfs(0, 2);
        dfs(0, 3);
        dfs(0, 5);
        dfs(0, 7);

    }
}
