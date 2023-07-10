package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴 {

    static int K;
    static int[][] board;
    static int answer;
    static int[] dirArr;

    public static void setDir(int num) {

        for (int i = num; i <= 2; i++) {
            if (board[i][2] != board[i + 1][6]) {
                dirArr[i + 1] = -dirArr[i];
            } else {
                break;
            }

        }

        for (int i = num; i >= 1; i--) {
            if (board[i][6] != board[i - 1][2]) {
                dirArr[i - 1] = -dirArr[i];
            } else {
                break;
            }
        }
    }

    private static void turnDir() {

        for (int i = 0; i < 4; i++) {
            if (dirArr[i] == 1) {
                moveCircleDir(i);
            } else if (dirArr[i] == -1) {
                moveAntiCircleDir(i);
            }
        }

    }

    private static void moveAntiCircleDir(int num) {
        int first = board[num][0];

        for (int i = 1; i <= 7; i++) {
            board[num][i - 1] = board[num][i];
        }

        board[num][7] = first;
    }

    private static void moveCircleDir(int num) {
        int last = board[num][7];

        for (int i = 6; i >= 0; i--) {
            board[num][i + 1] = board[num][i];
        }

        board[num][0] = last;
    }

    public static void main(String[] args) throws IOException {

        board = new int[4][8];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String st = br.readLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = st.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            dirArr = new int[4];
            dirArr[num -1] = dir;
            setDir(num - 1);
            turnDir();

        }

        if (board[0][0] == 1) {
            answer += 1;
        }

        if (board[1][0] == 1) {
            answer += 2;
        }

        if (board[2][0] == 1) {
            answer += 4;
        }

        if (board[3][0] == 1) {
            answer += 8;
        }

        System.out.println(answer);
    }

}
