package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피자배달거리DFS {

    static int[][] arr;
    static int N, M;
    static int answer;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] dis;
    static int sum;
    static int[][] visited;

    public static void dfs(int x, int y) {
        visited[x][y] = 0;

        if (arr[x][y] == 2) {
            sum = answer + dis[x][y];
            answer = Math.min(answer, sum);
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx < N && ny >= 1 && ny < N && visited[nx][ny] == 0) {
                    dis[nx][nx] = dis[x][y] + 1;
                    visited[nx][ny] = 1;
                    dfs(nx, ny);
                    visited[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //도시 행, 열
        M = Integer.parseInt(st.nextToken()); //피자집 갯수

        arr = new int[N][N];
        dis = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    dis[i][j] = 0;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
