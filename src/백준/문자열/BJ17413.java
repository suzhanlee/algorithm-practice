package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17413 {

    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void solution() {

        String tmp = "";
        boolean isWord = true;
        String tag = "";
        int cnt = 0;
        int idx = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '<') {
                isWord = false;
                if (!tmp.equals("")) {
                    StringBuilder stringBuffer = new StringBuilder(tmp);
                    String reverse = stringBuffer.reverse().toString();
                    sb.append(reverse);
                    tmp = "";
                }
            }

            if (isWord) {
                if (str.charAt(i) == ' ') {
                    StringBuilder stringBuffer = new StringBuilder(tmp);
                    String reverse = stringBuffer.reverse().toString();
                    sb.append(reverse).append(" ");
                    tmp = "";
                } else {
                    tmp += str.charAt(i);
                }
            } else {
                tag += str.charAt(i);
            }

            if (str.charAt(i) == '>') {
                isWord = true;
                sb.append(tag);
                tag = "";
            }
        }

        if (!tmp.equals("")) {
            StringBuilder stringBuilder = new StringBuilder(tmp);
            String reverse = stringBuilder.reverse().toString();
            sb.append(reverse);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        solution();

        System.out.println(sb);

    }
}
