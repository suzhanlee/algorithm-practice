package sw역량테스트문제집.여러유형연습.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int[][] board, visited;
    static int M, N;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static Queue<Point> queue = new LinkedList<>();

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

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0) {
                    if (board[nx][ny] == 1) {
                        visited[nx][ny] = visited[pt.x][pt.y] + 1;
                        if (nx == N && ny == M) {
                            return;
                        }
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        board = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}};
        N = board[0].length;
        M = board.length;
        visited = new int[N][M];

        queue.offer(new Point(0, 0));
        bfs();

        if (visited[N - 1][M - 1] == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(visited[N - 1][M - 1] + 1);
    }

}
