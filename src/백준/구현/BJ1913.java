package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1913 {

    static int N, K;
    static int[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        visited = new int[N][N];

        int idx = 0;

        int x = 0;
        int y = 0;

        visited[x][y] = N * N;

        while (true) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny] == 0) {
                visited[nx][ny] = visited[x][y] - 1;

                if (visited[nx][ny] == 1) {
                    break;
                }

                x = nx;
                y = ny;

            } else {
                idx++;
            }

            if (idx >= 4) {
                idx = 0;
            }

        }

        int kx = 0, ky = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j] == K) {
                    kx = i + 1;
                    ky = j + 1;
                }
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(kx).append(" ").append(ky);

        System.out.println(sb);
    }

}