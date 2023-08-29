package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649 {

    static int N, M;
    static int[] arr;
    static int[] visited;

    public static void dfs(int L) {

        if (L == M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

        } else {
            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    arr[L + 1] = i;
                    dfs(L + 1);
                    visited[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
        visited = new int[N + 1];

        dfs(0);
    }
}