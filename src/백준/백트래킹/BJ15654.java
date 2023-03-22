package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15654 {

    static int N, M;
    static int[] arr;
    static int[] visited;
    static int[] answer;

    public static void dfs(int V) {

        if (V == M) {

            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();

        } else {

            for (int i = 0; i < N; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    answer[V] = arr[i];
                    dfs(V + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        arr = new int[N];
        visited = new int[N];
        answer = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());

        }

        int K = arr.length - 1;

        while (K != 0) {
            for (int i = 0; i < K; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                }
            }
            K--;
        }

        dfs(0);
    }

}
