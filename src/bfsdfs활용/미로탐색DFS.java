package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탐색DFS {

    static int[][] graph;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void dfs(int row, int colum) {

        if (row == 7 && colum == 7) {
            answer++;

        } else {
            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newColum = colum + dy[i];
                if (newRow >= 1 && newRow <= 7 && newColum >= 1
                    && newColum <= 7 && graph[newRow][newColum] == 0) {
                    graph[newRow][newColum] = 1;
                    dfs(newRow, newColum);
                    graph[newRow][newColum] = 0;

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
                int i1 = Integer.parseInt(st.nextToken());
                graph[i][j] = i1;
            }
        }
        graph[1][1] = 1;
        dfs(1, 1);
        System.out.println(answer);
    }
}
