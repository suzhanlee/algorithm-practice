package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231 {

    static int N;
    static int answer;

    public static void solution() {

        for (int i = 1; i < N; i++) {

            String str = String.valueOf(i);
            int length = str.length();
            int tmp = i;

            for (int j = 0; j < length; j++) {
                tmp += (str.charAt(j) - '0');
            }

            if (tmp == N) {
                answer = i;
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
