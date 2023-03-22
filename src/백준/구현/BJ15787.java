package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ15787 {

    static int N, M;
    static int[][] trains;
    static int answer;
    static HashSet<String> set = new HashSet<>();

    public static void solution1(int num, int i, int x) {

        if (num == 1) {
            trains[i][x] = 1;
        } else {
            trains[i][x] = 0;
        }

    }

    public static void solution2(int num, int i) {

        if (num == 3) {
            for (int k = 19; k >= 1; k--) {
                trains[i][k + 1] = trains[i][k];
            }
            trains[i][1] = 0;

        } else {
            for (int k = 1; k <= 19; k++) {
                trains[i][k] = trains[i][k + 1];
            }
            trains[i][20] = 0;


        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trains = new int[N + 1][21];

        for (int k = 0; k < M; k++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st1.nextToken());
            int i = Integer.parseInt(st1.nextToken());
            if (num == 1 || num == 2) {

                int x = Integer.parseInt(st1.nextToken());
                solution1(num, i, x);

            } else {

                solution2(num, i);
            }


        }

        for (int i = 1; i <= N; i++) {

            set.add(Arrays.toString(trains[i]));

        }

        answer = set.size();

        System.out.println(answer);

    }

}
