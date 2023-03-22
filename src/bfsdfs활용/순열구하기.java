package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열구하기 {

    static int N, M;
    static int[] arr;
    static int[] visited;
    static int[] pm;

    public static void dfs(int L) {

        if (L == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
        } else {

            for (int i = 0; i < N; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    pm[L] = arr[i];
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

        arr = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        visited = new int[N];
        pm = new int[M];
        dfs(0);
    }
}
