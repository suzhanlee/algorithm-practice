package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14620 {

    static int N;
    static int[][] graph;
    static int answer = Integer.MAX_VALUE;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

//    static class Point {
//
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

    public static void dfs(int L, int sum) {

        if (L == 3) {
            answer = Math.min(answer, sum);
        } else {

            for (int i = 2; i < N; i++) {
                for (int j = 2; j < N; j++) {

                    if (visited[i][j] == 0 && check(i, j)) {
                        visited[i][j] = 1;

                        dfs(L + 1, sum + calculate(i, j));

                        visited[i][j] = 0;
                        clearVisit(i, j);


                    }
                }
            }
        }
    }

    private static void clearVisit(int i, int j) {

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            visited[nx][ny] = 0;
        }


    }

    private static int calculate(int i, int j) {

        int value = graph[i][j];

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            visited[nx][ny] = 1;

            value += graph[nx][ny];
        }

        return value;
    }

    private static boolean check(int i, int j) {

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (visited[nx][ny] == 1) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new int[N + 1][N + 1];
        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                graph[i][j] = i1;
            }
        }

        dfs(0, 0);
        System.out.println(answer);


    }

}
