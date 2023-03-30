package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10844 {

    static int N;
    static long[][] dp;
    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 각 자릿수 값 넣어주기 1 or 0
        dp = new long[N + 1][10];

        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1; // 일의 자리 배열
        }

        // 두 번째 자릿수부터 N까지 탐색
        for (int i = 2; i <= N; i++) { // 2의 자리부터 구하려는 N의 자리 배열

            // i번째 자릿수의 자릿값들을 탐색 (0~9)
            for (int j = 0; j < 10; j++) {

                // j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능

                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % 1000000000;
                }
                // j=9라면 이전 자릿수는 8만 가능
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % 1000000000;
                }
                // 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        // 각 자릿값마다의 경우의 수를 모두 더해준다.
        for (int i = 0; i < 10; i++) {

            answer += dp[N][i];

        }

        System.out.println(answer % 1000000000);

    }

}