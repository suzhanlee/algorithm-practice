package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1120 {

    static String str;
    static int answer = Integer.MAX_VALUE;
    static String str1, str2;
    static int cnt;

    public static void solution() {

        if (str1.length() == str2.length()) {
            answer = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    answer++;
                }
            }

        } else if (str2.contains(str1)) {
            answer = 0;

        } else {

            cnt = str2.length() - str1.length();
            for (int i = 0; i <= cnt; i++) {
                int beginIndex = str1.length() + i;
                if (beginIndex >= str2.length()) {
                    beginIndex = str2.length();
                }
                String suffix = str2.substring(beginIndex);
                String prefix = str2.substring(0, i);

                String newS = prefix + str1 + suffix;

                int sum = 0;
                for (int j = 0; j < str2.length(); j++) {
                    if (newS.charAt(j) != str2.charAt(j)) {
                        sum++;
                    }
                }

                answer = Math.min(answer, sum);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        str1 = st.nextToken();
        str2 = st.nextToken();

        solution();

        System.out.println(answer);


    }

}
