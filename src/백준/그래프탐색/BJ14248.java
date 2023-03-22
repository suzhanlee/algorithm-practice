package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14248 {

    static int N, S;
    static int[] graph;
    static int[] visited;
    static int answer;
    static Queue<Pebble> queue = new LinkedList<>();

    static class Pebble {

        int location;
        int move;

        public Pebble(int location, int move) {
            this.location = location;
            this.move = move;
        }
    }

    public static void bfs(int V) {

        queue.offer(new Pebble(V, graph[V]));
        visited[V] = 1;

        while (!queue.isEmpty()) {

            Pebble pebble = queue.poll();

            int nx = pebble.location + pebble.move;

            if (nx >= 1 && nx <= N && visited[nx] == 0) {

                visited[nx] = 1;
                queue.offer(new Pebble(nx, graph[nx]));

            }

            nx = pebble.location - pebble.move;

            if (nx >= 1 && nx <= N && visited[nx] == 0) {

                visited[nx] = 1;
                queue.offer(new Pebble(nx, graph[nx]));

            }
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1];
        visited = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        bfs(S);

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 1) {
                answer++;
            }
        }

        System.out.println(answer);


    }

}
