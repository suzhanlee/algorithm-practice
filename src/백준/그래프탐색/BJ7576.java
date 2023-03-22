package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {

    static int N, M;
    static int[][] graph;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] visited;
    static int[][] dis;
    static Queue<Point> queue = new LinkedList<>();
    static int answer = Integer.MIN_VALUE;
    static boolean flag = true;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {

        while (!queue.isEmpty()) {
            Point pt = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0
                    && graph[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    graph[nx][ny] = 1;
                    dis[nx][ny] = dis[pt.x][pt.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        graph = new int[N][M];
        visited = new int[N][M];
        dis = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) {
                    dis[i][j] = 1;
                    visited[i][j] = 1;
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs(0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dis[i][j] == 0 && graph[i][j] != -1) {
                    flag = false;
                }
            }
        }

        if (flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer - 1);
        } else {
            System.out.println(-1);
        }

    }
}


