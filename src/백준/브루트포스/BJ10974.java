package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10974 {

    static int N;
    static int[] visited;

    public static void dfs(int L, String s) {

        if (L == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i)).append(" ");
            }
            System.out.println(sb);

        } else {

            for (int i = 1; i <= N; i++) {

                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(L + 1, s + i);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new int[N + 1];

        dfs(0, "");

    }
}
