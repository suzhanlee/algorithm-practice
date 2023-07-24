package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지안녕 {

    static int R, C, T;
    static int[][] board;
    static int cleaner = -1;
    static Queue<Point> queue;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static class Point {

        int x, y, w;

        public Point(int x, int y, int w) {
            super();
            this.x = x;
            this.y = y;
            this.w = w;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (cleaner == -1 && board[i][j] == -1) {
                    cleaner = i;
                }
            }
        }

        for (int time = 0; time < T; time++) {

            checkDust();

            spread();

            operate();
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) {
                    continue;
                }
                answer += board[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void checkDust() {

        queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1 || board[i][j] == 0) {
                    continue;
                }
                queue.add(new Point(i, j, board[i][j]));
            }
        }

    }

    private static void spread() {

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            if (now.w < 5) {
                continue;
            }

            int amountOfSpread = now.w / 5;
            int cnt = 0;

            for (int d = 0; d < 4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];

                if (xx < 0 || xx >= R || yy < 0 || yy >= C) {
                    continue;
                }

                if (board[xx][yy] == -1) {
                    continue;
                }

                board[xx][yy] += amountOfSpread;
                cnt+=1;
            }

            board[now.x][now.y] -= amountOfSpread * cnt;
        }

    }

    private static void operate() {

        int top = cleaner;
        int down = cleaner + 1;

        for (int i = top - 1; i > 0; i--) {
            board[i][0] = board[i - 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            board[0][i] = board[0][i + 1];
        }

        for (int i = 0; i < top; i++) {
            board[i][C - 1] = board[i + 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            board[top][i] = board[top][i - 1];
        }

        board[top][1] = 0;

        for (int i = down + 1; i < R - 1; i++) {
            board[i][0] = board[i + 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            board[R - 1][i] = board[R - 1][i + 1];
        }

        for (int i = R - 1; i > down; i--) {
            board[i][C - 1] = board[i - 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            board[down][i] = board[down][i - 1];
        }

        board[down][1] = 0;
    }

}
