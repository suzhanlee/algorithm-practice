package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2578 {

    static int[][] board;
    static int count;
    static int bingo;

    public static void rCheck(int k, int l) { // 가로 체크
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            if (board[k][i] == 0) {
                cnt++;
            }
        }

        if (cnt == 5) {
            bingo++;
        }
    }

    public static void cCheck(int k, int l) {

        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            if (board[i][l] == 0) {
                cnt++;
            }
        }

        if (cnt == 5) {
            bingo++;
        }
    }

    public static void xCheck(int k, int l) {

        int cnt = 0;

        if (k == l) {
            for (int i = 0; i < 5; i++) {
                if (board[i][i] == 0) {
                    cnt++;
                }
            }
        }

        if (cnt == 5) {
            bingo++;
        }

        cnt = 0;

        if (k + l == 4) {
            for (int i = 0; i < 5; i++) {
                if (board[i][4 - i] == 0) {
                    cnt++;
                }
            }
        }

        if (cnt == 5) {
            bingo++;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int i3 = Integer.parseInt(st.nextToken());
            int i4 = Integer.parseInt(st.nextToken());
            int i5 = Integer.parseInt(st.nextToken());

            board[i][0] = i1;
            board[i][1] = i2;
            board[i][2] = i3;
            board[i][3] = i4;
            board[i][4] = i5;
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean flag = false;
            boolean out = false;

            for (int j = 0; j < 5; j++) {
                int value = Integer.parseInt(st.nextToken());
                count++;
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (value == board[k][l]) {
                            board[k][l] = 0;
                            rCheck(k, l); //가로 체크
                            cCheck(k, l); //세로 체크
                            xCheck(k, l); //대각선 체크
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        flag = false;
                        break;
                    }
                }

                if (bingo >= 3) {
                    out = true;
                    System.out.println(count);
                    break;
                }
            }
            if (out) {
                break;
            }
        }
    }
}
