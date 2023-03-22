package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2667 {

    static int N;
    static int[][] graph;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static Queue<Point> queue = new LinkedList<>();
    static int answer;
    static List<Integer> apartList = new ArrayList<>();
    static int apart;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point pt = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (graph[nx][ny] == 1) {
                        graph[nx][ny] = 0;
                        queue.offer(new Point(nx, ny));
                        apart++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                    answer++;
                    bfs(i, j);
                    apartList.add(apart + 1);
                    apart = 0;
                }
            }
        }

        System.out.println(answer);
        Collections.sort(apartList);

        for (int i = 0; i < answer; i++) {
            System.out.println(apartList.get(i));

        }
    }
}
