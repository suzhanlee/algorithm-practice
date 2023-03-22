package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {

    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static int[] visited;
    static ArrayList<Point> points = new ArrayList<>();

    static class Point implements Comparable<Point> {

        int V;
        int move;

        public Point(int v, int move) {
            V = v;
            this.move = move;
        }

        @Override
        public int compareTo(Point o) {
            if (this.V == o.V) {
                return this.move - o.move;
            } else {
                return this.V - o.V;
            }
        }
    }

    public static void dfs(int V) {

        for (int x : graph.get(V)) {
            if (visited[x] == 0) {
                visited[x] = 1;
                sb1.append(x).append(" ");
                dfs(x);
            }
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();
            for (int x : graph.get(poll)) {
                if (visited[x] == 0) {
                    visited[x] = 1;
                    sb2.append(x).append(" ");
                    queue.offer(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());
            if (x >= y) {
                points.add(new Point(x, y));
            } else {
                points.add(new Point(y, x));
            }
        }

        Collections.sort(points);

        for (Point point : points) {
            graph.get(point.V).add(point.move);
            graph.get(point.move).add(point.V);
        }

        visited = new int[N + 1];
        visited[V] = 1;
        sb1.append(V).append(" ");
        dfs(V);

        visited = new int[N + 1];
        visited[V] = 1;
        queue.offer(V);
        sb2.append(V).append(" ");
        bfs();

        System.out.println(sb1);
        System.out.println(sb2);

    }

}
