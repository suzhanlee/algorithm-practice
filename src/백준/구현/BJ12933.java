package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ12933 {

    static String str;
    static int answer;

    public static void solution() {

        ArrayList<Character> arr = new ArrayList<>();
        char[] quack = {'q', 'u', 'a', 'c', 'k'};
        int idx = 0;
        int answer = 0;

        for (int x = 0; x < str.length(); x++) {
            arr.add(str.charAt(x));
        }

        while (true) {

            for (int x = 0; x < arr.size(); x++) {
                char next = arr.get(x);
                char wanna = quack[idx];

                if (next == wanna) {
                    idx = (idx + 1) % 5;
                    arr.remove(x);
                    x--;
                }
            }

            if (idx == 0) {
                answer++;
            } else {
                System.out.println(-1);
                return;
            }
            if (arr.isEmpty()) {
                System.out.println(answer);
                return;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        if (str.length() % 5 != 0 || str.charAt(0) != 'q') {
            System.out.println(-1);
            return;
        }

        solution();

    }

}