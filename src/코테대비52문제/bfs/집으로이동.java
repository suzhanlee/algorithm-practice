package 코테대비52문제.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 집으로이동 {

    static Queue<nVertex> queue;
    static int[][] visited;
    static int[] dx;

    public int solution(int[] pool, int a, int b, int home) {

        queue = new LinkedList<>();

        dx = new int[]{a, -b};

        visited = new int[2][1001];

        for (int j : pool) {
            visited[0][j] = 1;
            visited[1][j] = 1;
        }

        queue.offer(new nVertex(0, 0));
        visited[0][0] = 1;
        visited[1][0] = 1;

        return bfs(0, home);

    }

    static class nVertex {

        int nx;
        int cnt;

        public nVertex(int nx, int cnt) {
            this.nx = nx;
            this.cnt = cnt;
        }
    }

    public int bfs(int L, int home) {

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                nVertex poll = queue.poll();

                for (int i = 0; i <= 1; i++) {

                    int nx = poll.nx + dx[i];
                    int cnt;

                    if (nx == home) {
                        return L + 1;
                    }

                    if (i == 0) {
                        cnt = 0;

                        if (nx >= 0 && visited[0][nx] == 0 && nx <= visited[0].length - 1) {
                            visited[0][nx] = 1;
                            queue.offer(new nVertex(nx, cnt));

                        }
                    } else {
                        cnt = poll.cnt + 1;

                        if (nx >= 0 && visited[1][nx] == 0 && nx <= visited[1].length - 1 && cnt < 2) {
                            visited[1][nx] = 1;
                            queue.offer(new nVertex(nx, cnt));

                        }
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args) {

        집으로이동 T = new 집으로이동();

        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}