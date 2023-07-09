package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {

    static int N;
    static int[][] board;
    static int[] visited;
    static int answer;

    public static void dfs(int L, int startPoint) {

        if (L == N / 2) {
            calculate();
            if (answer == 0) {
                System.out.println(0);
                System.exit(0);
            }

        } else {
            for (int i = startPoint; i <= N; i++) {  // 뻣는 가지 개수

                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(L + 1, startPoint + 1);
                    visited[i] = 0;
                }

            }
        }
    }

    public static void calculate() {
        int totalStart = 0;
        int totalLink = 0;

        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {

                if (visited[i] == 1 && visited[j] == 1) {
                    totalStart += board[i][j];
                    totalStart += board[j][i];
                } else if (visited[i] == 0 && visited[j] == 0) {
                    totalLink += board[i][j];
                    totalLink += board[j][i];
                }


            }

        }

        answer = Math.min(answer, Math.abs(totalStart - totalLink));

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        answer = Integer.MAX_VALUE;

        dfs(0, 1);
        System.out.println(answer);


    }
}
