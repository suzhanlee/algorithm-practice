package 자바_코딩테스트.넓이우선탐색;


import java.util.LinkedList;
import java.util.Queue;

class 최단거리 {

    public int solution(int[][] board) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();

        int[][] dist = new int[7][7];

        queue.offer(new int[]{0, 0});
        int L = 0;

        while (!queue.isEmpty()) {

            L++;
            int len = queue.size();

            for (int i = 0; i < len; i++) {

                int[] p = queue.poll();

                for (int k = 0; k < 4; k++) {

                    int nx = p[0] + dx[k];
                    int ny = p[1] + dy[k];

                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) {

                        board[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                        dist[nx][ny] = L;

                    }
                }
            }
        }

        if (dist[6][6] == 0) {
            return -1;
        } else {
            return dist[6][6];
        }
    }

    public static void main(String[] args) {
        최단거리 T = new 최단거리();
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }

}
