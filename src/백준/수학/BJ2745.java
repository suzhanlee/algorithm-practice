package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2745 {

    static String N;
    static int B;
    static int answer;

    public static void solution() {

        for (int i = 0; i < N.length(); i++) {

            char c = N.charAt(i);

            if ('A' <= c && c <= 'Z') {
                answer = answer * B + ((c - 'A') + 10);

            } else {
                answer = answer * B + (c - '0');
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken(); // 값
        B = Integer.parseInt(st.nextToken()); // 진법수

        solution();

        System.out.println(answer);


    }

}
