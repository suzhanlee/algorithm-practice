package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바둑이승차dfs {

    static int[] arr;
    static int C, N;
    static int answer;

    public static void dfs(int L, int value) {

        if (value > C) {
            return;

        } else if (L == N) {
            answer = Math.max(answer, value);

        } else {

            dfs(L + 1, value + arr[L]);
            dfs(L + 1, value);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        System.out.println(answer);
    }
}
