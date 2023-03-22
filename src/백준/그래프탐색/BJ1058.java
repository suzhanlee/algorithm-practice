package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1058 {

    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static int sum;
    static int answer;
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dis;

    public static void bfs() {

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
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {

            String s = br.readLine();
            for (int j = 1; j <= N; j++) {

                char c = s.charAt(j - 1);
                if (c == 'Y') {
                    graph.get(i).add(j);
                }

            }
        }

        for (int i = 1; i <= N; i++) {
            visited = new int[N + 1];
            dis = new int[N + 1];
            visited[i] = 1;
            queue.offer(i);
            bfs();

            for (int j = 1; j <= N; j++) {
                if (dis[j] == 2 || dis[j] == 1) {
                    sum++;
                }
            }
            answer = Math.max(answer, sum);
            sum = 0;
        }

        System.out.println(answer);


    }

}
