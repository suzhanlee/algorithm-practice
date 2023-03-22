package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로의최단거리통로BFS {

    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Board> queue = new LinkedList<>();
    static int[][] dis;

    static class Board {

        int row;
        int colum;

        public Board(int row, int colum) {
            this.row = row;
            this.colum = colum;
        }
    }

    public static void bfs(int row, int colum) {

        queue.offer(new Board(row, colum));
        graph[1][1] = 1;

        while (!queue.isEmpty()) {
            Board board = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = board.row + dx[i];
                int newColum = board.colum + dy[i];
                if (newColum >= 1 && newColum <= 7 && newRow >= 1 && newRow <= 7
                    && graph[newRow][newColum] == 0) {
                    graph[newRow][newColum] = 1;
                    queue.offer(new Board(newRow, newColum));
                    dis[newRow][newColum] = dis[board.row][board.colum] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dis = new int[8][8];
        bfs(1, 1);

        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }
}
