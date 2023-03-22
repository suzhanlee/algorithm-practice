package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5567 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int answer;
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

        N = Integer.parseInt(br.readLine()); // 동기의 수
        M = Integer.parseInt(br.readLine()); // 리스트의 길이

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[N + 1];
        dis = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        for (int i = 1; i <= N; i++) {
            if (dis[i] <= 2 && dis[i] >= 1) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
