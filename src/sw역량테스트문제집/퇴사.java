package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

    static int N;
    static int[] time;
    static int[] price;

    public static void solution() {
        //N일에 얻을 수 있는 최대 수익
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (i + time[i] <= N) {

                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + price[i]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);
    }


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        time = new int[N];
        price = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        solution();

    }


}