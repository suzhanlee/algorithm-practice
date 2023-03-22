package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10798 {

    static String s1, s2, s3, s4, s5;
    static StringBuilder sb = new StringBuilder();

    public static void solution() {

        int s1L = s1.length();
        int s2L = s2.length();
        int s3L = s3.length();
        int s4L = s4.length();
        int s5L = s5.length();

        for (int i = 0; i < 15; i++) {
            if (s1L - 1 >= i) {
                sb.append(s1.charAt(i));
            }

            if (s2L - 1 >= i) {
                sb.append(s2.charAt(i));
            }

            if (s3L - 1 >= i) {
                sb.append(s3.charAt(i));
            }

            if (s4L - 1 >= i) {
                sb.append(s4.charAt(i));
            }

            if (s5L - 1 >= i) {
                sb.append(s5.charAt(i));
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = br.readLine();
        s2 = br.readLine();
        s3 = br.readLine();
        s4 = br.readLine();
        s5 = br.readLine();

        solution();

        System.out.println(sb);

    }
}
