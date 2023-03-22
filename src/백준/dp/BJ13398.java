package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13398 {

    static int N;
    static int sum;
    static int[] arr;
    static int[] lt;
    static int[] rt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        lt = new int[N];
        rt = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        lt[0] = arr[0];
        rt[N - 1] = arr[N - 1];
        sum = arr[0];

        for (int i = 1; i < N; i++) {

            lt[i] = Math.max(arr[i], lt[i - 1] + arr[i]);
            sum = Math.max(lt[i], sum);

        }

        for (int i = N - 2; i >= 0; i--) {

            rt[i] = Math.max(arr[i], rt[i + 1] + arr[i]);

        }

        for (int i = 1; i < N - 1; i++) {

            int tmp = lt[i - 1] + rt[i + 1];
            sum = Math.max(sum, tmp);

        }

        System.out.println(sum);

    }
}
