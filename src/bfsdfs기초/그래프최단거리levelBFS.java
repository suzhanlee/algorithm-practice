package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프최단거리levelBFS {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int N, M;
    static int[] level;
    static Queue<Integer> queue = new LinkedList<>();

    public static void bfs(int V) {
        visited[V] = 1;
        int L = 0;

        queue.offer(V);
        while (!queue.isEmpty()) {
            for (int i = 0; i < graph.get(V).size(); i++) {

                Integer poll = queue.poll();
                for (int x : graph.get(poll)) {

                    if (visited[x] == 0) {
                        visited[x] = 1;
                        queue.offer(x);
                        level[x] = L + 1;
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st1.nextToken());
            int i2 = Integer.parseInt(st1.nextToken());
            graph.get(i1).add(i2);
        }
        visited = new int[N + 1];
        level = new int[N + 1];
        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(i + ":" + level[i]);
        }
    }
}
