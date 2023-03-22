package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중복순열 {

    static int N, M;
    static int arr[];
    static int marbles[];

    public static void dfs(int L) {

        if (L == M) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");

            }
            System.out.println();
            return;
        } else {

            for (int i = 0; i < N; i++) {
                arr[L] = marbles[i];
                dfs(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        marbles = new int[N];
        for (int i = 0; i < N; i++) {
            marbles[i] = i + 1;
        }
        dfs(0);
    }
}
