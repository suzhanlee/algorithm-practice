package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500 {

    static int N, M;
    static int[][] graph;
    static int answer;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int L, int x, int y, int sum) {

        if (L == 3) {
            answer = Math.max(answer, sum);

        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (visited[nx][ny] == 0) {

                        if (L == 1) {
                            visited[nx][ny] = 1;
                            dfs(L + 1, x, y, sum + graph[nx][ny]);
                            visited[nx][ny] = 0;
                        }

                        visited[nx][ny] = 1;
                        dfs(L + 1, nx, ny, sum + graph[nx][ny]);
                        visited[nx][ny] = 0;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dfs(0, i, j, graph[i][j]);
            }
        }

        System.out.println(answer);


    }

}
