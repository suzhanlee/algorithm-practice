package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 뱀 {

    static int N, K;
    static int L;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // 동 남 서 북
    static List<Point> snake = new ArrayList<>();
    static int answer;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution(Point pt, int number, int currentDir) {

        while (number >= 1) {

            answer++;

            int nx = pt.x + dx[currentDir];
            int ny = pt.y + dy[currentDir];

            // 뱀 사망
            if (meetWallOrSnake(nx, ny)) {
                System.out.println(answer);
                System.exit(0);
                return;
            }

            if (board[nx][ny] == 1) {
                snake.add(new Point(nx, ny));
                board[nx][ny] = 0;

            } else {
                snake.add(new Point(nx, ny));
                snake.remove(0);
            }

            pt.x = nx;
            pt.y = ny;

            number--;


        }

    }

    private static boolean meetWallOrSnake(int nx, int ny) {
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
            return true;
        }

        for (Point point : snake) {
            if (nx == point.x && ny == point.y) {
                return true;
            }
        }
        return false;
    }

    public static int changeDir(int currentDir, String changeDir) {

        if (changeDir.equals("L")) {
            return (currentDir + 3) % 4;
        }

        return (currentDir + 1) % 4;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken()) - 1;
            int y = Integer.parseInt(st1.nextToken()) - 1;

            board[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());

        int currentDir = 0;
        Point currentPoint = new Point(0, 0);
        snake.add(currentPoint);

        for (int i = 0; i < L; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            String changeDir = st2.nextToken();

            solution(currentPoint, x, currentDir);
            currentDir = changeDir(currentDir, changeDir);
        }


    }

}
