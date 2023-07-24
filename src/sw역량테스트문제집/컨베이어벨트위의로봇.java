package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {

    static int K;
    static int N;
    static int[][] board;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        board = new int[N * 2][2];
        robot = new boolean[N];

        for (int i = 0; i < 2 * N; i++) {
            board[i][0] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int time = 1;

        while (true) {

            turnAroundBoard();
            turnAroundRobot();

            for (int i = robot.length - 1; i > -1; i--) {
                if (robot[i]) {
                    int nxt = i + 1;
                    if (nxt == N) {
                        robot[i] = false;
                        continue;
                    }

                    if (nxt < N && !robot[nxt]) {
                        if (board[nxt][0] > 0) {

                            robot[nxt] = true;
                            robot[i] = false;
                            board[nxt][0]--;

                            if (board[nxt][0] == 0 && board[nxt][1] == 0) {
                                cnt++;
                                board[nxt][1] = 1;
                            }
                        }
                    }
                }
            }

            if (!robot[0] && board[0][0] > 0) {

                board[0][0]--;
                robot[0] = true;

                if (board[0][0] == 0 && board[0][1] == 0) {
                    cnt++;
                    board[0][1] = 1;
                }
            }

            if (cnt >= K) {
                break;
            }
            time++;
        }

        System.out.println(time);
    }

    private static void turnAroundRobot() {
        for (int i = robot.length - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
    }

    private static void turnAroundBoard() {

        int tmp1 = board[board.length - 1][0];
        int tmp2 = board[board.length - 1][1];

        for (int i = board.length - 1; i > 0; i--) {

            board[i][0] = board[i - 1][0];
            board[i][1] = board[i - 1][1];
        }

        board[0][0] = tmp1;
        board[0][1] = tmp2;
    }
}