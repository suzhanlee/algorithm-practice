package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {

    static int N, M;
    static int[][] graph;
    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] dis;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {

        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {

            Point pt = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && visited[nx][ny] == 0) {

                    if (graph[nx][ny] == 1) {

                        visited[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                        dis[nx][ny] = dis[pt.x][pt.y] + 1;
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
            String str = st1.nextToken();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        visited[1][1] = 1;
        bfs(1, 1);
        System.out.println(dis[N][M] + 1);

    }

}
