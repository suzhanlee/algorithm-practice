package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크레인인형뽑기 {

    public static int solution(int N, int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int x : moves) {
            for (int j = N - 1; j >= 0; j--) {
                if (board[j][x - 1] != 0) {
                    Integer push = board[j][x - 1];
                    board[j][x - 1] = 0;

                    if (!stack.isEmpty() && push == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(push);
                    }
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = N - 1; i >= 0; i--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int K = Integer.parseInt(br.readLine());
        int[] moves = new int[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(크레인인형뽑기.solution(N, board, moves));
    }
}
