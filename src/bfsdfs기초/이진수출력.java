package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진수출력 {

    public static void dfs(int N) {

        if (N == 0) {
            return;
        } else {
            dfs(N / 2);
            System.out.print(N % 2 + " ");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        이진수출력.dfs(N);
    }
}
