package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합이같은부분집합 {

    static int[] arr;
    static int N;
    static int totalCount;
    static boolean flag = false;
    static String answer = "NO";

    public static void dfs(int L, int sum) {

        if (flag == true) {
            return;
        }

        if (L == N) {
            if (totalCount - sum == sum) {
                answer = "YES";
                flag = true;
            }
        } else {

            dfs(L + 1, sum + arr[L]);
            dfs(L + 1, sum);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(st.nextToken());
            arr[i] = K;
            totalCount += arr[i];
        }

        dfs(0, 0);
        System.out.println(answer);
    }
}
