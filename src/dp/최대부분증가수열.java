package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대부분증가수열 {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void solution() {

        for (int i = 0; i < N; i++) {
            int max = arr[i];
            int cnt = 1;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] > max) {
                    cnt++;
                    max = arr[j];
                }
            }
            dp[i] = cnt;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            int i1 = Integer.parseInt(st.nextToken());
            arr[i] = i1;
        }

        solution();

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
