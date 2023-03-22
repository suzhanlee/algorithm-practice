package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {

    static int T;
    static int l;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static Queue<Point> queue;
    static int[][] visited;
    static int[][] dis;
    static int x2, y2;

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

            for (int i = 0; i < 8; i++) {

                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 0 && nx <= l-1 && ny >= 0 && ny <= l-1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[pt.x][pt.y] + 1;

                    if(nx == x2 && ny == y2) {
                        return;
                    }
                }

            }


        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            l = Integer.parseInt(br.readLine());

            queue = new LinkedList<>();
            visited = new int[l][l];
            dis = new int[l][l];

            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st1.nextToken());
            int y1 = Integer.parseInt(st1.nextToken());

            queue.offer(new Point(x1, y1));

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            x2 = Integer.parseInt(st2.nextToken());
            y2 = Integer.parseInt(st2.nextToken());

            if(x2 == x1 && y2 == y1) {
                System.out.println(0);
                continue;
            }

            bfs();
            System.out.println(dis[x2][y2]);

        }

    }
}
