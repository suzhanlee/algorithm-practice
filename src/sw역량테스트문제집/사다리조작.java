package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작 {

    private static int N, M, H;
    private static int[][] board;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static boolean flag;

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 1;
        }

        if (M == 0) {
            answer = 0;
        } else {

            for (int i = 0; i <= 3; i++) {

                flag = false;
                dfs(0, i);
                if (flag) {
                    answer = i;
                    break;
                }
            }
        }

        if (answer > 3) {
            answer = -1;
        }

        System.out.println(answer);


    }

    private static void dfs(int cnt, int max) {

        if (flag) {
            return;
        }
        if (max == cnt) {
            if (move()) {
                flag = true;
            }
            return;
        }

        for (int j = 1; j <= H; j++) {
            for (int i = 1; i < N; i++) {
                if (board[j][i - 1] == 1 && board[j][i] == 1 && board[j][i + 1] == 1) {

                    board[j][i] = 1;
                    dfs(cnt + 1, max);
                    board[j][i] = 0;
                }
            }
        }


    }

    private static boolean move() {

        for (int i = 1; i <= N; i++) {
            int idx = i;
            int level = 1;
            while (level <= H) {
                if (board[level][idx] == 0) {
                    idx += 1;
                } else if (board[level][idx - 1] == 0) {
                    idx -= 1;
                }
                level++;
            }

            if (idx == i) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

