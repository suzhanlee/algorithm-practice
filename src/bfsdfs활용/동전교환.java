package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전교환 {

    static int N, M;
    static Integer[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int L, int sum) {

        if (sum < 0) {
            return;
        }
        if (L >= answer) {
            return;
        }

        if (sum == 0) {
            answer = Math.min(answer, L);

        } else {
            for (int i = 0; i < N; i++) {
                dfs(L + 1, sum - arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        M = Integer.parseInt(br.readLine());

        dfs(0, M);
        System.out.println(answer);
    }
}
