package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14496 {

    static int a, b; // 바꾸려는 문자
    static int N, M; // 전체 문자 수, 치환 가능한 문자쌍의 수
    static ArrayList<ArrayList<Integer>> graph;
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
                    if (x == b) {
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[N + 1];
        dis = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st2.nextToken());
            int B = Integer.parseInt(st2.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        if (a == b) {
            System.out.println(0);
        } else {
            bfs(a);
            if (dis[b] == 0) {
                System.out.println(-1);
            } else {
                System.out.println(dis[b]);
            }
        }


    }
}
