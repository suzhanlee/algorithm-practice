package 백준.문자열;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        String str = "ab-ab+a-ba";
        StringTokenizer st = new StringTokenizer(str, "-");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }

}
