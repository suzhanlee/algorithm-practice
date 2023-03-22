package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ1316 {

    static int N;
    static int answer;

    public static void solution(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put(str.charAt(0), 1);

        for (int i = 1; i < str.length(); i++) {

            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

            if (str.charAt(i - 1) != str.charAt(i)) {
                if (map.get(str.charAt(i)) != 1) {
                    answer--;
                    break;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = N;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            solution(str);
        }

        System.out.println(answer);


    }

}
