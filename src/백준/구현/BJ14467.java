package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ14467 {

    static int N;
    static HashMap<Integer, Integer> cows = new HashMap<>();
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            if (cows.get(number) == null) {
                cows.put(number, location);
            } else {
                Integer lc = cows.get(number);
                if (location != lc) {
                    answer++;
                    cows.put(number, location);
                }
            }
        }

        System.out.println(answer);
    }
}
