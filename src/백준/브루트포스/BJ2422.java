package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2422 {

    static int N, M;
    static int[][] graph;
    static int[] visited;
    static int answer;
    static int[] iceCream = new int[3];

    public static void combination(int L, int startLine) {
        if (L == 3) {
            if (check()) {
                answer++;
            }
        } else {

            for (int i = startLine; i <= N; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    iceCream[L] = i;
                    combination(L + 1, i + 1);
                    visited[i] = 0;

                }
            }
        }
    }

    public static boolean check() {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (graph[iceCream[i]][iceCream[j]] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st1.nextToken());
            int i2 = Integer.parseInt(st1.nextToken());

            graph[i1][i2] = 1;
            graph[i2][i1] = 1;
        }

        combination(0, 1);

        System.out.println(answer);

    }
}
