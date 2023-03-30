package 자바_코딩테스트.시뮬레이션_구현;

import java.util.Arrays;

class 청소 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int idx = 0;
    static int[][] board;
    static Point startPt = new Point(0, 0);

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];

        this.board = board;

        for (int i = 0; i < k; i++) {
            move(startPt);
        }

        answer[0] = startPt.x;
        answer[1] = startPt.y;

        return answer;
    }

    public void move(Point pt) {

        int nx = pt.x + dx[idx];
        int ny = pt.y + dy[idx];

        if (nx >= 0 && nx <= board.length - 1 && ny >= 0 && ny <= board[0].length - 1) {

            if (board[nx][ny] == 1) {
                changeDirection();
            } else {
                startPt = new Point(nx, ny);
            }

        } else {
            changeDirection();
        }

    }

    public static void changeDirection() {
        idx = (idx + 1) % 4;
    }

    public static void main(String[] args) {
        청소 T = new 청소();
        int[][] arr1 = {{0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));

        startPt = new Point(0, 0);
        idx = 0;

        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));

        startPt = new Point(0, 0);
        idx = 0;

        int[][] arr3 = {{0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}