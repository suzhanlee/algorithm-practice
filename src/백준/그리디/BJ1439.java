package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1439 {

    static String S;
    static int answer;
    static int zero;
    static int one;

    public static void solution() {

        if (S.charAt(0) == '0') {
            zero++;
        } else if (S.charAt(0) == '1') {
            one++;
        }

        for (int i = 1; i < S.length(); i++) {

            if (S.charAt(i - 1) != S.charAt(i)) {

                if (S.charAt(i) == '0') {

                    zero++;

                } else if (S.charAt(i) == '1') {

                    one++;
                }
            }
        }

        answer = Math.min(zero, one);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        solution();

        System.out.println(answer);

    }

}
