package 자바_코딩테스트.시뮬레이션_구현;

class 잃어버린_강아지 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] board) {

        int answer = 0;

        Point personPt = null;
        Point dogPt = null;

        int personIdx = 0;
        int dogIdx = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    personPt = new Point(i, j);
                } else if (board[i][j] == 3) {
                    dogPt = new Point(i, j);
                }
            }
        }

        while (true) {

            if ((personPt.x == dogPt.x) && (personPt.y == dogPt.y)) {
                break;
            }

            int personNx = personPt.x + dx[personIdx];
            int personNy = personPt.y + dy[personIdx];

            int dogNx = dogPt.x + dx[dogIdx];
            int dogNy = dogPt.y + dy[dogIdx];

            if (personNx < 0 || personNx >= board.length || personNy < 0
                || personNy >= board[0].length || board[personNx][personNy] == 1) {

                personIdx = (personIdx + 1) % 4;

            } else {
                personPt = new Point(personNx, personNy);
            }

            if (dogNx < 0 || dogNx >= board.length || dogNy < 0
                || dogNy >= board[0].length || board[dogNx][dogNy] == 1) {

                dogIdx = (dogIdx + 1) % 4;

            } else {
                dogPt = new Point(dogNx, dogNy);
            }

            answer++;
        }

        return answer;

    }

    public static void main(String[] args) {
        잃어버린_강아지 T = new 잃어버린_강아지();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}