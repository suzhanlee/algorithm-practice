package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14719실패코드 {

    static int N, M;
    static int[] board;
    static int[][] graph;
    static int answer;

    public static void solution() {

        int height = 0;
        int start = -1;

        for (int i = M; i >= 1; i--) {

            if (board[i] > board[i - 1]) {
                height = board[i];
                start = i;
                break;
            }

        }

        int tmp = start;

        for (int i = start; i >= 1; i--) {

            if (board[i] < board[i - 1]) {
                int idx = i - 1;
                if (idx - 1 >= 1) {
                    while (idx >= 1) {
                        if (board[idx] < board[idx - 1]) {
                            idx--;
                        } else {
                            answer += explore(Math.min(board[idx],board[tmp]), idx, tmp);
                            break;
                        }
                    }
                    i = idx;
                    tmp = idx;

                } else {
                    answer += explore(Math.min(board[idx],board[tmp]), idx, tmp);
                    tmp = idx;
                }

            }
        }
    }

    public static int explore(int height, int x, int y) {

        int cnt = 0;
        for (int i = height; i >= 1; i--) {
            for (int j = x + 1; j < y; j++) {
                if (graph[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        board = new int[M + 1];
        graph = new int[N + 1][M + 1];

        for (int i = 1; i <= M; i++) {

            int x = Integer.parseInt(st1.nextToken());

            board[i] = x;

            for (int k = x; k >=1; k--) {

                graph[k][i] = 1;

            }


        }

        solution();

        System.out.println(answer);

    }
}
