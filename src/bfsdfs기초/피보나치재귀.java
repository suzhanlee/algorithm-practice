package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치재귀 {

    static int[] arr;

    public static int dfs(int N) {

        if (N == 1) {
            return arr[N] = 1;
        } else if (N == 2) {
            return arr[N] = 1;
        } else {
            return arr[N] = dfs(N - 1) + dfs(N - 2);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        피보나치재귀.dfs(N);

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
