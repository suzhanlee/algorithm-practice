package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ18232 {

    static int N, M;
    static int S, E;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int[] dis;
    static int[] dx = {1, -1};

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
                    if (x == E) {
                        return;
                    }
                }
            }

            for (int i = 0; i < 2; i++) {

                int nx = poll + dx[i];

                if (nx >= 1 && nx <= N) {

                    if (visited[nx] == 0) {
                        visited[nx] = 1;
                        queue.offer(nx);
                        dis[nx] = dis[poll] + 1;
                        if (nx == E) {
                            return;
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st1.nextToken());
        E = Integer.parseInt(st1.nextToken());

        visited = new int[N + 1];
        dis = new int[N + 1];

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);

        }

        bfs(S);

        System.out.println(dis[E]);


    }

}
