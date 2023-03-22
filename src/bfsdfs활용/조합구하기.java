package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합구하기 {

    static int N, M;
    static int[] arr;

    public static void dfs(int L, int startPoint) {

        if (L == M) {
            for (int i = 0; i < M; i++) {

                System.out.print(arr[i] + " ");
            }

            System.out.println();

        } else {
            for (int i = startPoint; i <= N; i++) {  // 뻣는 가지 개수

                arr[L] = i;
                dfs(L + 1, i + 1);

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0, 1);
    }
}
