package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17086 {

    static int N, M;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
    static int[][] graph;
    static Queue<Point> queue = new LinkedList<>();
    static int[][] visited;
    static int[][] dis;

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

            for (int i = 0; i < 8; i++) {

                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && visited[nx][ny] == 0) {
                    if (graph[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                        dis[nx][ny] = dis[point.x][point.y] + 1;
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

        graph = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {

                int y = Integer.parseInt(st1.nextToken());

                graph[i][j] = y;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (graph[i][j] == 1) {
                    visited[i][j] = 1;
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                max = Math.max(max, dis[i][j]);

            }
        }

        System.out.println(max);
    }

}
