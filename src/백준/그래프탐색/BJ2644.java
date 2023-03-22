package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2644 {

    static int N;// 전체 사람수
    static int p1, p2; // 촌수를 계산해야 하는 두 사람의 번호
    static int M; // 관계의 개수
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int[] dis;

    public static void bfs(int p1, int p2) {

        queue.offer(p1);

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            if (poll == p2) {
                break;
            }

            for (int x : graph.get(poll)) {

                if (dis[x] == 0 && visited[x] == 0) {
                    visited[x] = 1;
                    queue.offer(x);
                    dis[x] = dis[poll] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[N + 1];
        dis = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(p1, p2);

        if (dis[p2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[p2]);
        }
    }
}
