package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1110 {

    static int N;
    static int answer;

    public static void solution() {
        int tmp = N;
        int a;
        int b;
        int c;

        while (true) {

            if (N < 10) {
                a = 0;
                b = N % 10;
                c = a + b;

            } else {
                a = N / 10;
                b = N % 10;
                c = a + b;
            }

            if (c >= 10) {
                N = b * 10 + (c % 10);
            } else {
                N = b * 10 + c;
            }
            answer++;

            if (N == tmp) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        solution();

        System.out.println(answer);
    }
}
