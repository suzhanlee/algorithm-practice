package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합의경우의수 {

    static int[][] arr;

    public static int dfs(int N, int R) {

        if (R == 1) {
            return arr[N][R] = N;
        } else if (N == R) {
            return arr[N][R] = 1;
        } else {
            return arr[N][R] = dfs(N - 1, R - 1) + dfs(N - 1, R);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][R + 1];

        System.out.println(dfs(N, R));

    }
}
