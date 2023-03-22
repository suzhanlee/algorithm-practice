package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650 {

    static int N, M;
    static int[] arr;

    public static void dfs(int V, int startPoint) {

        if (V == M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

        } else {
            for (int i = startPoint; i <= N; i++) {

                arr[V + 1] = i;
                dfs(V + 1, i + 1);

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];

        dfs(0, 1);
    }
}
