package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20365 {

    static int N;
    static String str;
    static int answer;

    public static void solution() {

        int B = 0;
        int R = 0;

        StringBuilder tmp = new StringBuilder();
        tmp.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) != str.charAt(i - 1)) {
                tmp.append(str.charAt(i));
            }
        }

        for (char x : tmp.toString().toCharArray()) {
            if (x == 'B') {
                B++;
            } else {
                R++;
            }
        }

        if (B > ((long) tmp.toString().length()) / 2) { // B >= ~~~ 이것은 틀림 why?
            answer = 1 + R;
        } else {
            answer = 1 + B;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        str = br.readLine();

        solution();

        System.out.println(answer);


    }

}
