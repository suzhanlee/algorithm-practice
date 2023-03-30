package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {

    static int N, M;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer;
    static Queue<Point> queue;
    static int[][] visited;
    static int[][] newGraph;

    // 세울 수 있는 벽의 개수 : 3개
    // 0 : 빈칸 , 1 : 벽, 2 : 바이러스

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

            Point pt = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && visited[nx][ny] == 0
                    && newGraph[nx][ny] != 1) {

                    visited[nx][ny] = 1;
                    newGraph[nx][ny] = 2;
                    queue.offer(new Point(nx, ny));

                }
            }


        }

    }

    public static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            queue = new LinkedList<>();
            visited = new int[N + 1][M + 1];

            newGraph = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                newGraph[i] = graph[i].clone();
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {

                    if (newGraph[i][j] == 2) {
                        queue.offer(new Point(i, j));
                    }

                }
            }

            bfs();
            countSafeZone();
        } else {

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (graph[i][j] == 0) {
                        graph[i][j] = 1;
                        dfs(wallCnt + 1);
                        graph[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void countSafeZone() {
        int safeZone = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (newGraph[i][j] == 0) {
                    safeZone++;
                }

            }
        }

        answer = Math.max(safeZone, answer);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());

            }
        }

        dfs(0);

        System.out.println(answer);

    }

}
