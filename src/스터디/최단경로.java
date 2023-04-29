package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class 최단경로 {

    static ArrayList<Edge> list[];
    static int dis[];

    static class Edge implements Comparable<Edge> {

        int i, v;

        public Edge(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] in = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int dot = in[0], line = in[1];

        int start = Integer.parseInt(br.readLine());


        list = new ArrayList[dot + 1];

        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < line; i++) {

            String[] tt = br.readLine().split(" ");
            int a = Integer.parseInt(tt[0]);
            int b = Integer.parseInt(tt[1]);
            int dis = Integer.parseInt(tt[2]);
            list[a].add(new Edge(b, dis));
        }

        dis = new int[dot + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;

        dijkstra(start);

        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dis[i]);
            }
        }
    }

    private static void dijkstra(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge eg = pq.poll();

            for (Edge n : list[eg.i]) {
                if (dis[n.i] > eg.v + n.v) {
                    dis[n.i] = eg.v + n.v;

                }
            }
        }
    }
}
