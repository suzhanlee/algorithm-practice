package 백준.최단거리;

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
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int[] dis;
    static int cnt;

    public static void bfs(int V) {
        visited[V] = 1;

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

        N = Integer.parseInt(st.nextToken()); //도시 개수
        M = Integer.parseInt(st.nextToken()); //도로 개수
        K = Integer.parseInt(st.nextToken()); //최단 거리
        X = Integer.parseInt(st.nextToken()); //출발 도시 번호

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[N + 1];
        dis = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st1.nextToken());
            int i2 = Integer.parseInt(st1.nextToken());
            graph.get(i1).add(i2);
        }

        queue.offer(X);
        visited[X] = 1;
        bfs(0);

        for (int i = 1; i <= N; i++) {
            if (dis[i] == K) {
                cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println(-1);

        } else {
            for (int i = 1; i <= N; i++) {
                if (dis[i] == K) {
                    System.out.println(i);
                }
            }
        }

    }
}
