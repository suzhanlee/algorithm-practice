package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012 {

    static int T, M, N, K;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue;
    static int answer;

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
                    if (graph[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {

            queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visited = new int[N][M];

            for (int i = 0; i < K; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st1.nextToken());
                int x = Integer.parseInt(st1.nextToken());
                graph[x][y] = 1;
            }

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1 && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        queue.offer(new Point(i, j));
                        answer++;
                        bfs();
                    }
                }
            }

            System.out.println(answer);
            answer = 0;

        }


    }
}



