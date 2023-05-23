package 코테대비52문제.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 집으로이동 {

    static Queue<Integer> queue;
    static int[] visited;
    static int[] dx;

    public int solution(int[] pool, int a, int b, int home) {

        queue = new LinkedList<>();

        dx = new int[]{a, -b};

        visited = new int[home + 2 * b + 1];

        queue.offer(0);
        visited[0] = 1;

        return bfs(0, 0, home);

    }

    public int bfs(int L, int cnt, int home) {

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            for (int i = 0; i <= 1; i++) {
                int nx = poll + dx[i];
                if (i == 1) {
                    cnt++;
                } else {
                    cnt--;
                }

                if (nx >= 0 && nx <= visited.length - 1 && visited[nx] == 0) {

                    visited[nx] = 1;
                    queue.offer(nx);

                    if (nx == home) {
                        return L + 1;
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