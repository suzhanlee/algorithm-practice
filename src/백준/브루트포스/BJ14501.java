package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14501 {

    static int N;
    static ArrayList<Console> consoles = new ArrayList<>();

    static class Console {

        int day;
        int money;

        public Console(int day, int money) {
            this.day = day;
            this.money = money;
        }
    }

    public static void solution() {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            Console console = consoles.get(i);
            int day = console.day;

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            consoles.add(new Console(day, money));
        }

    }

}
