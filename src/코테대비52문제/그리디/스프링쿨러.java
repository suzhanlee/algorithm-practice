package 코테대비52문제.그리디;

import java.util.Arrays;

public class 스프링쿨러 {

    public int solution(int n, int[] nums) {

        int answer = 0;
        int[][] board = new int[nums.length + 1][2];

        for (int i = 0; i <= n; i++) {
            board[i][0] = Math.max(0, i - nums[i]);
            board[i][1] = Math.min(n, i + nums[i]);
        }

        Arrays.sort(board, (a, b) -> a[0] - b[0]);

        int start = 0, end = 0, i = 0;

        while (i < board.length) {

            while (i < board.length && board[i][0] <= start) {
                end = Math.max(end, board[i][1]);
                i++;
            }

            answer++;

            if (end == n) {
                return answer;
            }

            if (start == end) {
                return -1;
            }

            start = end;

        }

        return answer;
    }

    public static void main(String[] args) {

        스프링쿨러 T = new 스프링쿨러();

        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
