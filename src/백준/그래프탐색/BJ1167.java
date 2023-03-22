package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1167 {

    static int V;
    static ArrayList<ArrayList<Link>> graph;
    static int answer;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int[] distance;

    static class Link {

        int next;
        int distance;

        public Link(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for (Link link : graph.get(vertex)) {
                if (visited[link.next] == 0) {
                    visited[link.next] = 1;
                    queue.offer(link.next);
                    distance[link.next] = distance[vertex] + link.distance;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Link>>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int startNode = Integer.parseInt(st.nextToken());

            while (true) {

                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                graph.get(startNode).add(new Link(next, distance));
            }
        }

        distance = new int[V + 1];
        visited = new int[V + 1];
        visited[1] = 1;
        queue.offer(1);
        bfs();
        int max = 1;

        for (int i = 2; i <= V; i++) {
            if (distance[i] > distance[max]) {
                max = i;
            }
        }

        distance = new int[V + 1];
        visited = new int[V + 1];
        visited[max] = 1;
        queue.offer(max);
        bfs();
        Arrays.sort(distance);

        System.out.println(distance[V]);


    }

}
