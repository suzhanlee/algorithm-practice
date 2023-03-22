package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2098 {

    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] graph;
    static int[] visited;
    static int firstNum;

    public static void dfs(int L, int x, int sum) {

        if (L == N - 1) {

            if (graph[x][firstNum] != 0) {

                boolean flag = true;

                for (int i = 1; i <= N; i++) {
                    if (visited[i] == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer = Math.min(answer, sum + graph[x][firstNum]);
                }
            }

        } else {

            for (int i = 1; i <= N; i++) {

                if (i == x) {
                    continue;
                }

                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(L + 1, i, sum + graph[x][i]);
                    visited[i] = 0;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            visited = new int[N + 1];
            visited[i] = 1;
            firstNum = i;

            dfs(0, i, 0);
        }

        System.out.println(answer);

    }
}
