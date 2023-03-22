package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1541_1 {

    static String str;
    static long answer;

    public static void solution() {

        StringTokenizer st = new StringTokenizer(str, "-");
        String string = st.nextToken();
        StringTokenizer st1 = new StringTokenizer(string, "+");

        while (st1.hasMoreTokens()) {

            answer += Integer.parseInt(st1.nextToken());
        }

        while (st.hasMoreTokens()) {

            String s = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(s, "+");

            while (st2.hasMoreTokens()) {
                answer -= Integer.parseInt(st2.nextToken());
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        solution();
        System.out.println(answer);

    }
}
