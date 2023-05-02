package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 내선물을받아줘 {

    // E => +1
    // W => -1

    static int N;
    static char[] arr;
    static int[] visited;
    static int[][] board;

    public static void solution() {

        for (int i = 0; i < N; i++) {

            int idx = i;

            while (true) {

                if (arr[idx] == 'E') {
                    board[i][idx] = 1;
                    idx ++;
                } else {
                    break;
                }
            }
        }

        bfs();


    }

    public static void bfs() {

        Queue<Integer> queue = new LinkedList<>();

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();



        }



    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        arr = tmp.toCharArray();

        board = new int[N][N];

        solution();


    }

}
