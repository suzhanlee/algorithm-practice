package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치킨배달 {

    static int N, M;
    static int[][] board;
    static List<Point> chickenPts = new ArrayList<>();
    static List<Point> tmpPts = new ArrayList<>();

    static Queue<Point> queue;
    static int sum;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;
    static int[][] dir;
    static int cnt;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {

                int value = Integer.parseInt(st1.nextToken());
                if (value != 2) {
                    board[i][j] = value;
                } else {
                    chickenPts.add(new Point(i, j));
                }
            }
        }

        tmpPts.add(0, null);
        tmpPts.add(1, null);

        combi(0, 0);
        System.out.println(answer);
    }


    private static void combi(int L, int start) {
        if (L == M) {
            for (int i = 0; i < 2; i++) {
                Point tmpPt = tmpPts.get(i);
                System.out.println("x : " + tmpPt.x + " " + "y : " + tmpPt.y);
                board[tmpPt.x][tmpPt.y] = 2;
            }

            System.out.println("======" + cnt);
            cnt++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        queue = new LinkedList<>();
                        queue.add(new Point(i, j));
                        bfs();
                    }
                }
            }

            answer = Math.min(answer, sum);
            sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 0;
                    }
                }
            }

            tmpPts = new ArrayList<>();
            tmpPts.add(0, null);
            tmpPts.add(1, null);
        } else {

            for (int i = start; i < chickenPts.size(); i++) {
                Point pt = chickenPts.get(i);
                tmpPts.add(L, pt);
                combi(L + 1, start + 1);
            }

        }
    }

    private static void bfs() {

        visited = new int[N][N];
        dir = new int[N][N];

        while (!queue.isEmpty()) {
            Point pt = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    dir[nx][ny] = dir[pt.x][pt.y] + 1;
                    queue.offer(new Point(nx, ny));
                    if (board[nx][ny] == 2) {
                        sum += dir[nx][ny];
                        return;
                    }
                }
            }

        }

    }

}
