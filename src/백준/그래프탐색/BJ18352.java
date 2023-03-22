package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ18352 {

    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int[] dis;

    public static void bfs(int V) {
        visited[V] = 1;
        queue.offer(V);

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            for (int x : graph.get(poll)) {

                if (visited[x] == 0) {
                    visited[x] = 1;
                    queue.offer(x);
                    dis[x] = dis[poll] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 최단거리가 K
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[N + 1];
        dis = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());

        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());

            graph.get(x).add(y);
        }

        bfs(X);

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (dis[i] == K) {
                sb.append(i).append('\n');
            } else {
                cnt++;
            }
        }

        if (cnt == N) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
