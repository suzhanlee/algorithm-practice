package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static int N, M;
    static int r, c;
    static int dir;
    static int[][] board;
    static int answer;
    static int[] dx = {-1, 0, 1, 0}; //반시계 방향
    static int[] dy = {0, 1, 0, -1};

    private static void solution() {

        board[r][c] = 2;

        while (true) {

            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                //청소되지 않은 빈칸이 있다면?
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] == 0) {
                    cnt++;
                    move(dir);
                }

            }

            if (cnt == 0) {
                int nx = r - dx[dir];
                int ny = c - dy[dir];

                if (board[nx][ny] != 1) {
                    back(nx, ny);
                } else {
                    break;
                }
            }

            // 후진할 수 있다면 후진하고 청소하기
            // 할 수 없다면 종료하기
        }

    }

    private static void move(int x) {
        if (x - 1 >= 0) {
            dir = x - 1;
            int nx = r + dx[dir];
            int ny = c + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] == 0) {
                r = nx;
                c = ny;
                board[r][c] = 2;
            }
        } else {
            dir = 3;
            int nx = r + dx[dir];
            int ny = c + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] == 0) {
                r = nx;
                c = ny;
                board[r][c] = 2;
            }
        }

    }

    private static void back(int nx, int ny) {
        r = nx;
        c = ny;
        board[r][c] = 2;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st2.nextToken());
        c = Integer.parseInt(st2.nextToken());

        dir = Integer.parseInt(st2.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        solution();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (board[i][j] == 2) {
                    answer++;
                }

            }
        }

        System.out.println(answer);

    }


}
