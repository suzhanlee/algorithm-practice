package 자바_코딩테스트.넓이우선탐색;

import java.util.LinkedList;
import java.util.Queue;

class 송아지를잡자 {

    public int solution(int s, int e) {

        int[][] visited = new int[2][200001];
        Queue<Integer> queue = new LinkedList<>();

        visited[0][s] = 1;
        queue.offer(s);
        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            L++;

            for (int i = 0; i < len; i++) {
                int x = queue.poll();

                for (int nx : new int[]{x - 1, x + 1, x * 2}) {
                    if (nx >= 0 && nx <= 200000 && visited[L % 2][nx] == 0) {
                        visited[L % 2][nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            e = e + L;

            if (e > 200000) {
                return -1;
            }

            if (visited[L % 2][e] == 1) {
                return L;
            }
        }
        return -1;
    }
}
