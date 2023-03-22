package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2753 {

    static int N;
    static int answer;

    public static void solution() {

        if (N % 4 == 0) {
            if (N % 100 != 0 || N % 400 == 0) {
                answer = 1;
            } else {
                answer = 0;
            }
        } else {
            answer = 0;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        solution();

        System.out.println(answer);


    }

}
