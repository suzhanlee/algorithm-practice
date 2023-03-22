package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대소문자변환 {

    static String str;
    static String answer = "";

    public static void solution() {

        for (char x : str.toCharArray()) {

            if (Character.isLowerCase(x)) {
                answer += Character.toUpperCase(x);

            } else {
                answer += Character.toLowerCase(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        대소문자변환.solution();

        System.out.println(answer);
    }

}
