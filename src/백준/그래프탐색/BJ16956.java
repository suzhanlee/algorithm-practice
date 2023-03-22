package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16956 {

    static int R, C;
    static Character[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean flag = false;
    //    static int[][] visited;
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

//        queue.offer(new Point(x, y));
//        int[][] visited = new int[R][C];
//        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
//                    visited[nx][ny] = 1;
                    if (graph[nx][ny] == 'S') {
                        flag = true;
                        return;
                    }

                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = 'D';
                    }

//                    queue.offer(new Point(nx, ny));

                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new Character[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char str = s.charAt(j);
                graph[i][j] = str;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'W') {
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs();

        if (!flag) {
            System.out.println(1);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(graph[i][j]);

                }
                System.out.println();

            }
        } else {
            System.out.println(0);
        }


    }

}
