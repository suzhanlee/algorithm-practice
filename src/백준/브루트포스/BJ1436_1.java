package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1436_1 {

    static int N;
    static int cnt = 1;
    static int answer = 666;
    static int tmp = 1;
    static int tmp2 = 0;

    public static void solution() {

        while (N != cnt) {

            if (String.valueOf(answer).contains("5666")) {
                answer += tmp2;
                tmp2++;
                if (tmp2 == 9) {
                    tmp2 = 0;
                }
            } else {
                String s = String.valueOf(answer);
                s = tmp + s;
                tmp++;
            }

            cnt++;

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solution();

        System.out.println(answer);
    }

}
