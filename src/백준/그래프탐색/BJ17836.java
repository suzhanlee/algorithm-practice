package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17836 {

    static int N, M, T;
    static int answer;
    static int[][] graph;
    static int[][] visited;
    static int[][] visited_for_sword;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();

    static class Point {

        int x;
        int y;
        int dis;
        boolean gram;

        public Point(int x, int y, int dis, boolean gram) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.gram = gram;
        }
    }

    public static void solution() {

        queue.offer(new Point(1, 1, 0, false));
        visited[1][1] = 1;
        visited_for_sword[1][1] = 1;
        bfs();
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            Point pt = queue.poll();

            if (pt.dis > T) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {

                    if (pt.gram) {

                        if (visited_for_sword[nx][ny] == 0) {
                            queue.offer(new Point(nx, ny, pt.dis + 1, true));
                            visited_for_sword[nx][ny] = 1;
                        }

                    } else {

                        if (visited[nx][ny] == 0 && graph[nx][ny] == 0) {
                            queue.offer(new Point(nx, ny, pt.dis + 1, false));
                            visited[nx][ny] = 1;
                        } else if (visited[nx][ny] == 0 && graph[nx][ny] == 2) {
                            queue.offer(new Point(nx, ny, pt.dis + 1, true));
                            visited[nx][ny] = 1;
                            visited_for_sword[nx][ny] = 1;
                        }

                    }

                    if (nx == N && ny == M) {
                        if (pt.gram) {
                            answer = pt.dis;
                            return;
                        } else {
                            if (graph[nx][ny] != 1) {
                                answer = pt.dis;
                                return;
                            }
                        }

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
        T = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];
        visited_for_sword = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        solution();
        if (answer == 0) {
            System.out.println("Fail");
        } else {
            System.out.println(answer + 1);
        }

    }

}
