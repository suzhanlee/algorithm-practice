package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ15686 {

    static int N, M;
    static int answer = Integer.MIN_VALUE;
    static int[][] graph;
    // 0 : 빈칸,  1 : 집,  2 : 치킨집
    // 도시의 치킨거리 : 모든 집의 치킨 거리의 합
    // 집의 치킨 거리 : 해당 집과 가장 가까운 치킨집과의 거리
    static int chickenCnt;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();
    static int[][] visited;
    static ArrayList<Point> arrayList = new ArrayList<>();
    static ArrayList<Point> points = new ArrayList<>();

    static class Point {

        int x;
        int y;
        int[] dis;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs() {

        while (!queue.isEmpty()) {

            Point pt = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    if (graph[nx][ny] == 2) {
                        return Math.abs(nx - pt.x) + Math.abs(ny - pt.y);
                    }
                }
            }


        }
        return 0;
    }

    public static void dfs(int L, ArrayList<Point> points) {
        if (L == M - 1) {

            for (int i = 1; i <= M - 1; i++) {
                if (points.get(i - 1).x == -1) {
                    return;
                }

                Point point = points.get(i - 1);
                graph[point.x][point.y] = 2;

            }

            solution();

            for (int i = 1; i <= M - 1; i++) {

                Point point = points.get(i - 1);
                graph[point.x][point.y] = 0;
            }

        } else {

            points.add(L, arrayList.get(L));
            dfs(L + 1, points);
            points.add(L, new Point(-1, -1));
            dfs(L + 1, points);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st1.nextToken());
                if (x != 2) {
                    graph[i][j] = x;
                } else {
                    arrayList.add(new Point(i, j));
                }
            }
        }

        dfs(0, new ArrayList<>());
        System.out.println(answer);


    }

    private static void solution() {
        int cnt = 0; // 임시 도시의 치킨 거리
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited = new int[N + 1][N + 1];
                visited[i][j] = 1;
                queue.offer(new Point(i, j));
                int num = bfs();
                cnt += num;
            }

        }
        answer = Math.max(answer, cnt);
    }

}
