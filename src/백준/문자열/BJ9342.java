package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9342 { //50% 정도에서 틀림...

    static int T;
    static StringBuilder sb = new StringBuilder();


    public static void solution(String str) {

        String regex = "^[A-F]?A+F+C+[A-F]?$";

        if (str.matches(regex)) {
            sb.append("Infected!").append('\n');
        } else {
            sb.append("Good!").append('\n');
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            solution(str);
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }
}
