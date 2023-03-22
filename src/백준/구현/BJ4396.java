package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ4396 {

    static int N; // N * N 격자
    static Character[][] board;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static StringBuilder sb = new StringBuilder();
    static boolean mine = false;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new Character[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == 'x') {
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (board[nx][ny] == '*') {
                                cnt++;
                            }
                        }
                    }
                    if (board[i][j] == '*') {
                        sb.append('*');
                        mine = true;
//                        break;
                    } else {
                        visited[i][j] = cnt;
                        sb.append(cnt);
                    }
                } else {
                    sb.append(".");
                }
            }
//            if (mine) {
//                break;
//            }
            sb.append('\n');
        }

        if (mine) {
            StringBuilder newSb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '*') {
                        newSb.append('*');
                    } else if (visited[i][j] >= 0) {
                        newSb.append(visited[i][j]);

                    } else {
                        newSb.append('.');
                    }
                }
                newSb.append('\n');
            }
            System.out.println(newSb);

        } else {
            System.out.println(sb);
        }
    }
}
