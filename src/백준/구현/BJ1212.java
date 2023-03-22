package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1212 {

    static String S;
    static StringBuilder sb = new StringBuilder();

    public static void solution() {
        int length = S.length();

        for (int i = 0; i < length; i++) {
            String tmp = Integer.toBinaryString(S.charAt(i) - '0');

            if (tmp.length() == 2 && i != 0) {
                tmp = "0" + tmp;
            } else if (tmp.length() == 1 && i != 0) {
                tmp = "00" + tmp;
            }

            sb.append(tmp);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        solution();

        System.out.println(sb);

    }
}
