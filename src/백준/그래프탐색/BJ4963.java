package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4963 {

    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
    static int[][] graph;
    static Queue<Point> queue;
    static int N, M;
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

            for (int i = 0; i < 8; i++) {

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

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            graph = new int[N][M];
            visited = new int[N][M];

            for (int i = 0; i < N; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int i1 = Integer.parseInt(st1.nextToken());
                    graph[i][j] = i1;
                }
            }

            queue = new LinkedList<>();
            int answer = 0;

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
        }


    }

}
