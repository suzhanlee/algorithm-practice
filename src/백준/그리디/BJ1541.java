package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1541 {

    static String str;
    static int answer;
    static BufferedReader br;

    public static void solution() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int idx = 0;
        int tokens = st.countTokens();

        if (tokens == 1) {
            String data = st.nextToken();
            minusToken(data);

            answer = -answer;
        } else {

            while (st.hasMoreTokens()) {

                String data = st.nextToken();

                minusToken(data);
                if (idx < 1) {
                    answer = -answer;
                }
                idx++;
            }
        }
    }

    private static void minusToken(String data) {
        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '+') {
                answer -= Integer.parseInt(tmp.toString());
                tmp = new StringBuilder();
            } else {
                tmp.append(data.charAt(i));
            }
        }
        answer -= Integer.parseInt(tmp.toString());
    }

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        solution();

        System.out.println(answer);
    }
}
