package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14719 {

    static int N, M;
    static int[] board;
    static int answer;

    public static void solution() {

        for (int i = 2; i <= M - 1; i++) {

            int leftMax = 0;
            int rightMax = 0;

            int lt = i - 1;
            int rt = i + 1;

            while (lt != -1) {

                leftMax = Math.max(leftMax, board[lt]);
                lt--;
            }

            while (rt != M + 1) {

                rightMax = Math.max(rightMax, board[rt]);
                rt++;
            }

            int range = Math.min(leftMax, rightMax);

            int explore = explore(range, i);

            if (explore >= 0) {
                answer += explore;
            }

        }


    }

    public static int explore(int range, int i) {
        return range - board[i];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        board = new int[M + 1];

        for (int i = 1; i <= M; i++) {

            int x = Integer.parseInt(st1.nextToken());

            board[i] = x;

        }

        solution();

        System.out.println(answer);

    }
}
