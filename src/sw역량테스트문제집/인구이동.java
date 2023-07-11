package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 인구이동 {

    static int N, L, R;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> queue = new LinkedList<>();
    static Set<Point> countries = new HashSet<>();
    static int answer;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            Point pt = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pt.x + dx[i];
                int ny = pt.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == 0) {

                    int diff = Math.abs(board[pt.x][pt.y] - board[nx][ny]);
                    if (L <= diff && diff <= R) {
                        countries.add(new Point(nx, ny));
                        countries.add(new Point(pt.x, pt.y));
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = 1;
                    }
                }
            }


        }

        if (countries.size() == 0) {
            return;
        }

        int sum = 0;

        for (Point country : countries) {
            sum += board[country.x][country.y];
        }

        int value = sum / countries.size();

        for (Point country : countries) {
            board[country.x][country.y] = value;
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        while (true) {

            visited = new int[N][N];

            boolean flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        visited[i][j] = 1;
                        queue.offer(new Point(i, j));
                        bfs();
                        if (countries.size() != 0) {
                            flag = true;
                        }
                    }
                }
            }

            if (!flag) {
                break;
            }

            answer++;
            countries = new HashSet<>();
        }

        System.out.println(answer);

    }
}
