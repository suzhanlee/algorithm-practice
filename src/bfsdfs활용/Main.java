package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] graph;
    static int[] visited = new int[1001];
    static int N, M;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder st = new StringBuilder();

    static void bfs(int v) {

        queue.offer(v);
        visited[v] = 1;

        while (!queue.isEmpty()) {

            v = queue.poll();
            st.append(v).append(" ");

            for (int i = 1; i <= N; i++) {
                if (graph[v][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(i);
                }
            }
        }
    }

    private static void dfs(int v) {

        visited[v] = 1;
        st.append(v).append(" ");

        for (int i = 1; i <= N; i++) {
            if (graph[v][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] token = br.readLine().split(" ");

        N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);
        int V = Integer.parseInt(token[2]);

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            token = br.readLine().split(" ");
            int i1 = Integer.parseInt(token[0]);
            int i2 = Integer.parseInt(token[1]);

            graph[i1][i2] = 1;
            graph[i2][i1] = 1;
        }

        dfs(V);
        st.append("\n");
        Arrays.fill(visited, 0);

        bfs(V);
        System.out.println(st);
        st.setLength(0);
        Arrays.fill(visited, 0);

    }
}