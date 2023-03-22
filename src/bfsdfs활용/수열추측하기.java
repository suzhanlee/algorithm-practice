package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열추측하기 {

    static int N, F;
    static int[] arr;
    static int[] visited;
    static int[][] combiArray;
    static boolean flag = false;

    public static void dfs(int L, int sum) {
        if (flag == true) {
            return;
        }

        if (L == N && sum == F) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            flag = true;

        } else {

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    arr[L] = i;
                    dfs(L + 1, sum + (arr[L] * combi(N - 1, L)));
                    visited[i] = 0;
                }
            }
        }
    }

    public static int combi(int N, int R) {
        if (N == R || R == 0) {
            return combiArray[N][R] = 1;
        } else {
            return combiArray[N][R] = combi(N - 1, R - 1) + combi(N - 1, R);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new int[N + 1];
        combiArray = new int[N][N];

        dfs(0, 0);
    }
}
