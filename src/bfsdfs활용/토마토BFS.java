package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토BFS {

    static int N, M;
    static int[][] dis;
    static int[][] tomato;
    static Queue<Point> queue = new LinkedList();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;
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
            if (tomato[pt.x][pt.y] != 1) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && tomato[nx][ny] == 0) {

                    tomato[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[pt.x][pt.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tomato = new int[M][N];
        dis = new int[M][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st1.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs(0, 0);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) {
                    flag = false;
                }
            }
        }

        if (flag) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (tomato[i][j] == 0) {
                        answer = -1;
                        return;
                    }
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
