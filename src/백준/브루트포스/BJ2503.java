package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2503 {

    static int N;
    static int answer;
    static List<BaseBall> baseBalls = new ArrayList<>();

    static class BaseBall {

        int number;
        int strike;
        int ball;

        public BaseBall(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void solution(List<BaseBall> baseBalls) {

        for (int i = 123; i <= 987; i++) {
            boolean flag = true;
            int cnt = 0;

            if (hasSameNumberOrHasZero(i)) {
                continue;
            }

            for (BaseBall baseBall : baseBalls) {
                int strike = baseBall.strike;
                int ball = baseBall.ball;

                if (!countStrike(i, baseBall)) {
                    flag = false;
                }

                if (!countBall(i, baseBall)) {
                    flag = false;
                }
                if (flag) {
                    cnt++;
                }
                flag = true;
            }

            if (cnt == baseBalls.size()) {
                answer++;
            }


        }
    }

    public static boolean countStrike(int number, BaseBall baseBall) {
        String str = String.valueOf(number);
        String bd = String.valueOf(baseBall.number);
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == bd.charAt(i)) {
                cnt++;
            }
        }

        if (cnt == baseBall.strike) {
            return true;
        }

        return false;
    }

    public static boolean countBall(int number, BaseBall baseBall) {
        String str = String.valueOf(number);
        String bd = String.valueOf(baseBall.number);
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == bd.charAt((i + 1) % 3)
                || str.charAt(i) == bd.charAt((i + 2) % 3)) {
                cnt++;
            }
        }

        if (cnt == baseBall.ball) {
            return true;
        }

        return false;
    }

    public static boolean hasSameNumberOrHasZero(int number) {
        String str = String.valueOf(number);
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        if (set.size() != 3 || set.contains('0')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            baseBalls.add(new BaseBall(number, strike, ball));
        }

        solution(baseBalls);

        System.out.println(answer);
    }
}
