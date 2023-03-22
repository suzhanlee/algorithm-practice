package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1254 {

    static String S;
    static int answer;

    public static boolean solution(String str) {

        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {

            if (str.charAt(lt) != str.charAt(rt)) {
                return false;
            }

            lt++;
            rt--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        answer = S.length();

        for (int i = 0; i < S.length(); i++) {
            if (solution(S.substring(i))) {
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
