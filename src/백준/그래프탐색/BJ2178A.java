package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178A {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();
    static int[][] visited;
    static int[][] dis;

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

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && visited[nx][ny] == 0) {
                    if (graph.get(nx).get(ny) == 1) {
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
        visited = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            graph.get(i).add(0);

            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == '1') {
                    graph.get(i).add(1);
                } else {
                    graph.get(i).add(0);
                }
            }
        }

        queue.offer(new Point(1, 1));
        bfs();

        System.out.println(dis[N][M] + 1);

    }

}
