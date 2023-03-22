package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ6550 { //50% 에서 nullpoint exception...

    static StringBuilder sb = new StringBuilder();

    public static void solution(String s, String t) {

        int idx = 0;
        int cnt = 0;

        for (int i = 0; i < t.length(); i++) {

            if (idx > s.length()) {
                break;
            }

            if (cnt == s.length()) {
                break;
            }

            if (s.charAt(idx) == t.charAt(i)) {
                idx++;
                cnt++;
            }

        }

        if (cnt == s.length()) {
            sb.append("Yes").append('\n');
        } else {
            sb.append("No").append('\n');
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str;

        while (!(str = br.readLine()).equals("")) {
            st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();

            solution(s, t);

        }

        System.out.println(sb);

    }

}
