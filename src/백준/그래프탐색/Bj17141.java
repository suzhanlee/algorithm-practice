package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj17141 {

    static int N, M;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = Integer.MAX_VALUE;
    static Queue<Point> queue;
    static int[][] visited;
    static int[][] newGraph;
    static int[][] dis;
    static ArrayList<Point> virusAbleLocation = new ArrayList<>();
    static int[] virusVisited = new int[10];

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

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && visited[nx][ny] == 0
                    && newGraph[nx][ny] != 1) {

                    visited[nx][ny] = 1;
                    newGraph[nx][ny] = -2;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[pt.x][pt.y] + 1;
                }
            }


        }

    }

    public static void dfs(int virusCnt, int start) {

        if (virusCnt == M) {
            queue = new LinkedList<>();
            visited = new int[N + 1][N + 1];
            dis = new int[N + 1][N + 1];
            newGraph = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] == 2) {
                        newGraph[i][j] = 0;

                    } else {
                        newGraph[i][j] = graph[i][j];
                    }
                }
            }

            for (int i = 0; i < virusVisited.length; i++) {
                if (virusVisited[i] == 1) {
                    Point pt = virusAbleLocation.get(i);
                    newGraph[pt.x][pt.y] = -2;
                    visited[pt.x][pt.y] = 1;
                    queue.offer(pt);
                }
            }

            bfs();
            solve();

        } else {

            for (int i = start; i < virusAbleLocation.size(); i++) {

                if (virusVisited[i] == 0) {
                    virusVisited[i] = 1;
                    dfs(virusCnt + 1, i + 1);
                    virusVisited[i] = 0;
                }
            }
        }
    }

    public static void solve() {

        boolean flag = true;
        int distance = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (newGraph[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    distance = Math.max(dis[i][j], distance);
                }

            }

            answer = Math.min(distance, answer);

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스 갯수

        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st1.nextToken());
                graph[i][j] = x;
                if (x == 2) {
                    virusAbleLocation.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }


    }

}
