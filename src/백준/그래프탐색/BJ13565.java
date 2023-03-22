package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13565 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Point> queue = new LinkedList<>();
    static String answer = "NO";
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {

            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0) {
                    if (graph.get(nx).get(ny) == 0) {
                        if (nx == N - 1) {
                            answer = "YES";
                            return;
                        }
                        visited[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));

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

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[N][M];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                graph.get(i).add(c - '0');
            }
        }

        for (int i = 0; i < M; i++) {
            if (graph.get(0).get(i) == 0) {
                visited[0][i] = 1;
                queue.offer(new Point(0, i));
            }
        }

        bfs();

        System.out.println(answer);

    }

}
