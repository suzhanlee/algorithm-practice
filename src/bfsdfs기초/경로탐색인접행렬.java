package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로탐색인접행렬 {

    static ArrayList<ArrayList<Integer>> graph;
    static int N, M;
    static int answer = 0;
    static int[] visited;

    public static void dfs(int V) {

        if (V == N) {
            answer++;

        } else {
            for (int x : graph.get(V)) {
                if (visited[x] == 0) {

                    visited[x] = 1;
                    dfs(x);
                    visited[x] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st1.nextToken());
            int i2 = Integer.parseInt(st1.nextToken());
            graph.get(i1).add(i2);
        }
        visited = new int[N + 1];
        visited[1] = 1;

        dfs(1);
        System.out.println(answer);
    }
}
