package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로탐색dfs {

    static int answer = 0;
    static int[] visited;
    static int[][] graph;
    static int N;

    public static void dfs(int V) {

        if (V == N) {
            answer++;
        } else {
            for (int i = 1; i <= N; i++) {
                if (graph[V][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    dfs(i);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st1.nextToken());
            int num2 = Integer.parseInt(st1.nextToken());

            graph[num1][num2] = 1;
        }

        visited = new int[N + 1];
        visited[1] = 1;

        경로탐색dfs.dfs(1);
        System.out.println(answer);
    }
}
