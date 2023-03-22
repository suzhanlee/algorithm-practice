package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15656 { //시간초과

    static int N, M;
    static int[] arr;
    static int[] answer;

    public static void dfs(int V) {

        if (V == M) {

            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();

        } else {
            int before = 0;

            for (int i = 0; i < N; i++) {
                if (before != arr[i]) {
                    answer[V] = arr[i];
                    before = arr[i];
                    dfs(V + 1);
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
        answer = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());

        }

        int K = arr.length - 1;

        Arrays.sort(arr);

        dfs(0);
    }

}
