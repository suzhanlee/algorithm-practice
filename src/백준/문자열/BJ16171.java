package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16171 { //정말 너무 힘들게 맞췄다... 브론즈 1문제인데 사실상 str.contains() 를 내가 직접 구현함.... 앞으로는 contains()를 꼭 사용하자!

    static String S, K;

    public static void solution() {

        String str = "";
        int cnt = 0;
        boolean flag = false;
        int length = K.length();

        for (char x : S.toCharArray()) {
            if (Character.isAlphabetic(x)) {
                str += x;
            }
        }

        for (int i = 0; i < str.length(); i++) {

            if (i + length > str.length()) {
                break;
            }

            if (str.charAt(i) == K.charAt(0)) {

                int idx = i;
                for (int j = idx; j < idx + length; j++) {
                    if (K.charAt(j - idx) == str.charAt(j)) {
                        cnt++;
                    } else {
                        break;
                    }
                }

                if (cnt == K.length()) {
                    flag = true;
                    System.out.println(1);
                }
                cnt = 0;
            }
        }

        if (!flag) {
            System.out.println(0);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        K = br.readLine();

        solution();


    }
}
