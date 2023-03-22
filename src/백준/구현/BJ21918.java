package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21918 {

    static int N, M;
    static int[] bulbs;
    static StringBuilder sb = new StringBuilder();

    public static void solution1(int bulb, int status) {
        bulbs[bulb] = status;
    }

    public static void solution2(int l, int r) {

        for (int i = l; i <= r; i++) {
            if (bulbs[i] == 1) {
                bulbs[i] = 0;
            } else {
                bulbs[i] = 1;
            }

        }
    }

    public static void solution3(int l, int r) {

        for (int i = l; i <= r; i++) {
            bulbs[i] = 0;
        }
    }

    public static void solution4(int l, int r) {

        for (int i = l; i <= r; i++) {
            bulbs[i] = 1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bulbs = new int[N + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            bulbs[i] = Integer.parseInt(st1.nextToken());

        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st2.nextToken());
            if (number == 1) {
                int bulb = Integer.parseInt(st2.nextToken());
                int status = Integer.parseInt(st2.nextToken());
                solution1(bulb, status);

            } else if (number == 2) {
                int bulbA = Integer.parseInt(st2.nextToken());
                int bulbB = Integer.parseInt(st2.nextToken());
                solution2(bulbA, bulbB);

            } else if (number == 3) {
                int bulbA = Integer.parseInt(st2.nextToken());
                int bulbB = Integer.parseInt(st2.nextToken());
                solution3(bulbA, bulbB);

            } else if (number == 4) {
                int bulbA = Integer.parseInt(st2.nextToken());
                int bulbB = Integer.parseInt(st2.nextToken());
                solution4(bulbA, bulbB);
            }
        }

        for (int i = 1; i < bulbs.length; i++) {
            sb.append(bulbs[i]).append(" ");

        }

        System.out.println(sb);
    }
}
