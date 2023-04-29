package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] dis;
    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();

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

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0) {
                    if (graph.get(nx).get(ny) != 0) {
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

        graph = new ArrayList<ArrayList<Integer>>();
        dis = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph.get(i).add(j, Integer.parseInt(st1.nextToken()));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph.get(i).get(j) == 2) {
                    visited[i][j] = 1;
                    dis[i][j] = 0;
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dis[i][j] == 0 && graph.get(i).get(j) == 1) {
                    dis[i][j] = -1;
                }
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }
}
