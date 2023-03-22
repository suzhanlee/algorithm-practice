package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16926 {

    static int N, M, R;
    static int[][] board;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();

    public static void solution() {

        int cnt = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < cnt; j++) {

                int x = j;
                int y = j;

                int idx = 0;
                int tmp = board[x][y];

                while (idx < 4) {

                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    if (nx >= j && nx < N - j && ny >= j && ny < M - j) {

                        board[x][y] = board[nx][ny];
                        x = nx;
                        y = ny;

                    } else {
                        idx++;
                    }

                }
                board[j + 1][j] = tmp;
            }

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int e = Integer.parseInt(st1.nextToken());
                board[i][j] = e;
            }

        }

        solution();

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                sb.append(board[j][k]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);


    }

}
