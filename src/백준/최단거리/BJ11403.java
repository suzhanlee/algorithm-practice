package 백준.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11403 {

    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static int[][] answer;

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N + 1];
        queue.offer(V);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int x : graph.get(poll)) {
                if (visited[x] == 0) {
                    visited[x] = 1;
                    queue.offer(x);
                    answer[V - 1][x - 1] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        answer = new int[N][N];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

//        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
