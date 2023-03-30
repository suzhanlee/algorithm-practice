package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {

    static int N, K;
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dis;


    public static void bfs() {

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            if (poll == K) {
                break;
            }

            if (poll + 1 <= 100000 && visited[poll + 1] == 0) {
                visited[poll + 1] = 1;

                dis[poll + 1] = dis[poll] + 1;

                queue.offer(poll + 1);
            }

            if (poll - 1 >= 0 && visited[poll - 1] == 0) {
                visited[poll - 1] = 1;
                dis[poll - 1] = dis[poll] + 1;

                queue.offer(poll * 2);
            }

            if (2 * poll <= 100000 && visited[poll * 2] == 0) {
                visited[poll * 2] = 1;
                dis[poll * 2] = dis[poll] + 1;

                queue.offer(poll - 1);
            }


        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100002];
        dis = new int[100002];

        queue.offer(N);
        visited[N] = 1;
        bfs();

        System.out.println(dis[K]);

    }
}
