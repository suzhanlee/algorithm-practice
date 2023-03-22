package 프로그래머스.프로그래머스_깊이_너비_우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 네트워크 {

    static int n;
    // 네트워크 개수를 구하시오.
    static int[][] computers;
    static int answer;
    static int[] visited;


    public static int solution(int n, int[][] computers) {

        visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                answer++;
                visited[i] = 1;
                dfs(i, computers, n);
            }
        }

        return answer;
    }

    public static void dfs(int i, int[][] computers, int n) {

        for (int j = 0; j < n; j++) {
            if (visited[j] == 0 && computers[i][j] == 1) {
                visited[j] = 1;
                dfs(j, computers, n);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        computers = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        int answer = solution(n, computers);

        System.out.println(answer);


    }

}
