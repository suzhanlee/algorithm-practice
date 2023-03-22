package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14916 {

    static int N;
    static int answer;

    public static void solution() {

        while (true) {

            if (N == 0) {
                break;
            }

            if (N < 0) {
                answer = -1;
                break;
            }

            if (N >= 10) {
                N -= 5;
                answer++;
            } else if (N < 10 && N % 2 == 0) {
                N -= 2;
                answer++;

            } else if (N < 10 && N % 2 == 1) {
                N -= 5;
                answer++;
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
