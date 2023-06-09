package 코테대비52문제.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 미로의최단거리통로2 {

    static int[][] visited;
    static Queue<Point> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dir;

    public int solution(int[][] board) {

        visited = new int[7][7];
        dir = new int[7][7];
        queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        return bfs(0);

    }

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int bfs(int L) {

        while (!queue.isEmpty()) {

            Point poll = queue.poll();

            for (int i = 0; i <= 3; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx <= 6 && ny <= 6 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dir[nx][ny] = dir[poll.x][poll.y] + 1;
                    if (nx == 6 && ny == 6) {
                        return dir[nx][ny];
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        미로의최단거리통로2 T = new 미로의최단거리통로2();

        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}