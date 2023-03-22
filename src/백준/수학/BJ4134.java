package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4134 { //시간초과 ...

    static StringBuilder sb = new StringBuilder();

    public static void solution(long K) {

        boolean flag = false;

        while (true) {

            for (long i = 2; i * i < K; i++) {
                if (K % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append(K).append('\n');
                break;
            }
            flag = false;
            K += 1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        for (int i = 0; i < N; i++) {
            long K = Long.parseLong(br.readLine());
            solution(K);
        }

        System.out.println(sb);

    }
}
