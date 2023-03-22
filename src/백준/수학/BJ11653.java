package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11653 {

    static StringBuilder sb = new StringBuilder();

    public static void solution(int N) {

        int idx = 2;

        while (N != 1) {

            if (N % idx == 0) {
                N = N / idx;
                sb.append(idx).append('\n');

            } else {
                idx++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        solution(N);
        System.out.println(sb);

    }
}
