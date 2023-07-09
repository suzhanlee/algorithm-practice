package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] arr;
    static int[] sign;

    private static void dfs(int L, int sum) {

        if (L == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

        } else {
            for (int i = 0; i < 4; i++) {

                if (sign[i] > 0) {
                    sign[i]--;

                    if (i == 0) {
                        dfs(L + 1, sum + arr[L]);
                    } else if (i == 1) {
                        dfs(L + 1, sum - arr[L]);
                    } else if (i == 2) {
                        dfs(L + 1, sum * arr[L]);
                    } else {
                        dfs(L + 1, sum / arr[L]);
                    }

                    sign[i]++;

                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        sign = new int[4];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st1.nextToken());

        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }

}
