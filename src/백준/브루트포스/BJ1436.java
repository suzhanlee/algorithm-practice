package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1436 {

    static int N;
    static int cnt = 1;
    static int answer = 666;

    public static void solution() {

        while (N != cnt) {

            answer++;

            if (String.valueOf(answer).contains("666")) {
                cnt++;
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
