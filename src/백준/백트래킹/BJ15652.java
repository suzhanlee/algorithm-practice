package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15652 {

    static int N, M;
    static int[] arr;

    public static void dfs(int V) {

        if (V == M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            arr[V] = Integer.MIN_VALUE;

        } else {
            for (int i = 1; i <= N; i++) {

                arr[V + 1] = i;
                if (V >= 1) {
                    if (arr[V] > arr[V + 1]) {
                        continue;
                    }
                }
                dfs(V + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];

        dfs(0);
    }
}