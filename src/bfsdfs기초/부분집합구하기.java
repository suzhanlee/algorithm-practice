package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분집합구하기 {

    static int[] arr;
    static int num;

    public static void dfs(int K) {

        if (K == num + 1) {
            String str = "";
            for (int i = 1; i <= num; i++) {
                if (arr[i] == 1) {
                    str += (i + " ");
                }
            }
            if (str.length() > 0) {
                System.out.println(str);
            }
        } else {
            arr[K] = 1;
            dfs(K + 1);
            arr[K] = 0;
            dfs(K + 1);

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        num = N;

        부분집합구하기.dfs(1);
    }
}
