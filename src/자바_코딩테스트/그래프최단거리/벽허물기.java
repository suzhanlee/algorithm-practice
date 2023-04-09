package 자바_코딩테스트.그래프최단거리;

import java.util.Arrays;
import java.util.PriorityQueue;

class 벽허물기 {

    public int solution(int[][] board) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            if (cur[2] > cost[cur[0]][cur[1]]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (board[nx][ny] == 0 && cost[nx][ny] > cur[2]) {

                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx, ny, cur[2]});

                } else if (board[nx][ny] == 1 && cost[nx][ny] > cur[2] + 1) {

                    cost[nx][ny] = cur[2] + 1;
                    pq.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        return cost[n - 1][m - 1];
    }
}
