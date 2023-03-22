package 백준.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13549 {

    static int N, K;
    static Queue<Location> queue = new LinkedList<>();
    static int[] visited;
    static int answer = Integer.MAX_VALUE;

    static class Location {

        int time;
        int location;

        public Location(int time, int location) {
            this.time = time;
            this.location = location;
        }
    }


    public static void bfs(int V, int L) {

        queue.offer(new Location(0, V));
        visited[V] = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int j = 0; j < size; j++) {

                Location lc = queue.poll();

                if (lc.location == K) {
                    answer = Math.min(answer, lc.time);
                }

                int[] move = new int[3];

                move[0] = lc.location * 2;
                move[1] = lc.location - 1;
                move[2] = lc.location + 1;

                for (int i = 0; i < 3; i++) {
                    if (move[i] >= 0 && move[i] <= 100000) {
                        if (visited[move[i]] == 0) {

                            visited[move[i]] = 1;

                            if (i == 0) {
                                queue.offer(new Location(lc.time, move[i]));
                            } else if (i == 1) {
                                queue.offer(new Location(lc.time + 1, move[i]));
                            } else {
                                queue.offer(new Location(lc.time + 1, move[i]));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100010];
        bfs(N, 0);

        System.out.println(answer);
    }

}
