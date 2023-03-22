package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자찾기 {

    static String N;
    static String K;
    static int answer;

    public static void solution() {
        String NN = N.toLowerCase();
        char NK = K.toLowerCase().charAt(0);

        for (char x : NN.toCharArray()) {
            if (x == NK) {
                answer++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        K = br.readLine();

        문자찾기.solution();
        System.out.println(answer);

    }
}
