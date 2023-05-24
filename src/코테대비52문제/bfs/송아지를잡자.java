package 코테대비52문제.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 송아지를잡자 {

    static int[][] visited;
    static Queue<Integer> queue;
    static int[] dx = {1, -1};

    public int solution(int s, int e) {

        visited = new int[2][200001];
        queue = new LinkedList<>();

        queue.offer(s);
        visited[0][s] = 1;
        visited[1][s] = 1;

        return bfs(e, 0);
    }

    public int bfs(int e, int L) {

        int speed = 0;
        int cow = e;

        while (!queue.isEmpty()) {

            int size = queue.size();
            speed += 1;
            cow += speed;

            for (int i = 0; i < size; i++) {

                Integer poll = queue.poll();

                for (int j = 0; j <= 2; j++) {

                    int nx;

                    if (j == 0 || j == 1) {
                        nx = poll + dx[j];
                    } else {
                        nx = poll * 2;
                    }

                    if (nx >= 0 && nx <= 200000 && visited[L % 2][nx] == 0) {
                        visited[L % 2][nx] = 1;
                        queue.offer(nx);

                        if (visited[L % 2][cow] == 1) {
                            return L + 1;
                        }
                    }
                }
            }
            L++;

        }
        return -1;
    }

    public static void main(String[] args) {

        송아지를잡자 T = new 송아지를잡자();

        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
