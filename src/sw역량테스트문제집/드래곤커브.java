package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브 {

    static int N;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[101][101];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            move(Integer.parseInt((st.nextToken()), Integer.parseInt((st.nextToken()),
                getDirections(
                    Integer.parseInt((st.nextToken()), Integer.parseInt((st.nextToken())));
        }

        System.out.println(count());
    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] == 0 && board[i + 1][j] == 0 && board[i][j + 1] == 0
                    && board[i + 1][j + 1] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static List<Integer> getDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        while (0 < g--) {
            for (int i = directions.size() - 1; 0 <= i; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }
        return directions;
    }

    public static void move(int x, int y, List<Integer> dir) {
        board[x][y] = 0;
        for (int now : dir) {
            x += dx[now];
            y += dy[now];
            board[x][y] = 0;
        }
    }


}