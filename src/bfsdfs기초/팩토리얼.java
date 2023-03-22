package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼 {

    public static void dfs(int N, int answer) {

        if (N == 1) {
            System.out.println(answer);
            return;
        } else {
            answer = answer * N;
            dfs(N - 1, answer);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 1;

        팩토리얼.dfs(N, answer);
    }
}

//    public static int dfs(int N) {
//
//        if (N == 1) {
//            return 1;
//        } else {
//            return N * dfs(N - 1);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        System.out.println(팩토리얼.dfs(N));
//    }
//}
