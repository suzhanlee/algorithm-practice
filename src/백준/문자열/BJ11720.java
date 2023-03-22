package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11720 {

    static int N;
    static String K;
    static int answer;

    public static void solution() {

        for (char x : K.toCharArray()) {
            answer += x - '0';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        K = br.readLine();

        solution();

        System.out.println(answer);


    }

}
