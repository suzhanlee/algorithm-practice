package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 경사로 {

    static int N, L;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        L = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(br.readLine());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (calRow(i)) {
                cnt++;
            }
            if (calCol(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean calRow(int row) {
        boolean[] isIncline = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = board[row][i] - board[row][i + 1];

            if (diff > 1 || diff < -1) {
                return false;

            } else if (diff == -1) {

                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isIncline[i - j]) {
                        return false;
                    }

                    if (board[row][i] != board[row][i - j]) {
                        return false;
                    }
                    isIncline[i - j] = true;
                }
            } else if (diff == 1) {

                for (int j = 1; j <= L; j++) {

                    if (i + j >= N || isIncline[i + j]) {
                        return false;
                    }

                    if (board[row][i] - 1 != board[row][i + j]) {
                        return false;
                    }

                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }

    public static boolean calCol(int col) {
        boolean[] isIncline = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = board[i][col] - board[i + 1][col];

            if (diff > 1 || diff < -1) {
                return false;

            } else if (diff == -1) {
                for (int j = 0; j < L; j++) {

                    if (i - j < 0 || isIncline[i - j]) {
                        return false;
                    }

                    if (board[i][col] != board[i - j][col]) {
                        return false;
                    }

                    isIncline[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= L; j++) {

                    if (i + j >= N || isIncline[i + j]) {
                        return false;
                    }

                    if (board[i][col] - 1 != board[i + j][col]) {
                        return false;
                    }

                    isIncline[i + j] = true;
                }
            }
        }
        return true;
    }
}
