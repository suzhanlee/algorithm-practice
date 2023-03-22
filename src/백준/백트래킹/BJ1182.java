package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182 {

    static int N, S;
    static int[] arr;
    static int[] visited;
    static int answer;

    public static void dfs(int V, int sum) {

        if (V == N) {
            if (sum == S) {
                answer++;
            }
        } else {
            dfs(V + 1, sum + arr[V]);
            dfs(V + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());

        }

        dfs(0, 0);
        if (S == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }

}
