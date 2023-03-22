package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ21938 {

    static int N, M, T;
    static List<ArrayList<Integer>> graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();
    static int[][] visited;
    static int answer;

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

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && visited[nx][ny] == 0) {
                    if (graph.get(nx).get(ny - 1) == 255) {
                        visited[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value1 = Integer.parseInt(st.nextToken());
                int value2 = Integer.parseInt(st.nextToken());
                int value3 = Integer.parseInt(st.nextToken());

                int average = (value1 + value2 + value3) / 3;
                graph.get(i).add(average);

            }
        }

        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {

                if (graph.get(i).get(j) >= T) {
                    graph.get(i).set(j, 255);
                } else {
                    graph.get(i).set(j, 0);
                }

            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                if (graph.get(i).get(j - 1) == 255 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    queue.offer(new Point(i, j));
                    bfs();
                    answer++;
                }

            }
        }

        System.out.println(answer);


    }

}
