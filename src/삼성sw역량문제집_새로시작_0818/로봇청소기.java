package 삼성sw역량문제집_새로시작_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static int N, M;
    static int r, c, d;
    static int[][] board;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static Robot robot;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st1.nextToken());
        c = Integer.parseInt(st1.nextToken());
        d = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        robot = new Robot(r, c, d);

        doProcess();
        System.out.println(answer);
    }

    static class Robot {

        int r;
        int c;
        int d;

        public Robot(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    private static void doProcess() {
        while (true) {
            clean();
            if (isClean()) {
                if (!canGoBack()) {
                    break;
                }
            } else {
                turnLeft();
            }
        }
    }

    private static boolean isClean() {

        for (int i = 0; i < 4; i++) {
            int nx = robot.r + dx[i];
            int ny = robot.c + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (board[nx][ny] == 0) {
                return false;
            }
        }

        return true;
    }

    private static int changeDir(int nowDir) {
        return (nowDir + 1) % 4;

    }

    private static void clean() {
        if (board[robot.r][robot.c] == 0) {
            answer++;
            board[robot.r][robot.c] = 2;
        }
    }

    private static boolean canGoBack() {
        int back = changeDir(changeDir(robot.d));

        int nx = robot.r + dx[back];
        int ny = robot.c + dy[back];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 1) {
            return false;
        }

        // 후진
        robot.r = nx;
        robot.c = ny;

        return true;
    }

    private static void turnLeft() {
        if (robot.d - 1 < 0) {
            robot.d = 3;
        } else {
            robot.d -= 1;
        }

        int nx = robot.r + dx[robot.d];
        int ny = robot.c + dy[robot.d];

        if (board[nx][ny] == 0) {
            // 전진
            robot.r = nx;
            robot.c = ny;
        }

    }

}
