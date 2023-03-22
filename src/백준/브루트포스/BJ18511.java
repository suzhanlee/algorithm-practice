package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18511 {

    static int N, K;
    static int[] arr;
    static long answer = Integer.MIN_VALUE;

    public static void dfs(int L, String sum) {

        if (L == String.valueOf(N).length() - 1) {
            if (Long.parseLong(sum) <= N) {
                answer = Math.max(Long.parseLong(sum), answer);
            }
        }

        if (L == String.valueOf(N).length()) {
            if (Long.parseLong(sum) <= N) {
                answer = Math.max(Long.parseLong(sum), answer);
            }
        } else {
            for (int i = 0; i < K; i++) {
                dfs(L + 1, sum + arr[i]);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        arr = new int[K];

        for (int i = 0; i < K; i++) {
            int i1 = Integer.parseInt(st1.nextToken());
            arr[i] = i1;
        }

        dfs(0, "");

        System.out.println(answer);


    }
}
