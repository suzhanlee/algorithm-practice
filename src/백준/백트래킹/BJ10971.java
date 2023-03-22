package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10971 {

    static int N;
    static int[][] arr;
    static int[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int start, int now, int L, int sum) {

        if (L == N - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                answer = Math.min(answer, sum);
            }

        } else {
            for (int i = 0; i < N; i++) {

                if (visited[i] == 0 && arr[now][i] != 0) {
                    visited[i] = 1;
                    dfs(start, i, L + 1, sum + arr[now][i]);
                    visited[i] = 0;
                }

            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = 1;
            dfs(i, i, 0, 0);

        }
        System.out.println(answer);
    }
}
