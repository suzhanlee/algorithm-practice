package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1541 {

    static String str;
    static ArrayList<String> arrayList = new ArrayList<>();
    static int answer;

    public static void solution() {

        StringTokenizer st = new StringTokenizer(str, "-");

        int idx = 0;

        while (st.hasMoreTokens()) {

            String s = st.nextToken();

            if (idx == 0) {
                StringTokenizer st1 = new StringTokenizer(s, "+");
                while (st1.hasMoreTokens()) {
                    String s1 = st1.nextToken();
                    answer += Integer.parseInt(s1);
                }
            } else {
                StringTokenizer st1 = new StringTokenizer(s, "+");
                while (st1.hasMoreTokens()) {
                    String s1 = st1.nextToken();
                    answer -= Integer.parseInt(s1);
                }
            }
            idx++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        solution();
        System.out.println(answer);

    }

}
