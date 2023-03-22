package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2606 {

    static int N, K;
    static int[][] graph;
    static int[] visited;
    static int answer;

    public static void dfs(int L) {
        visited[L] = 1;

        for (int i = 1; i <= N; i++) {
            if (graph[L][i] == 1 && visited[i] == 0) {
                answer++; //(1,2) , (1,5) , (2,3) , (2,5) 총 4개
                dfs(i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            graph[i1][i2] = graph[i2][i1] = 1;
        }

        visited[1] = 1;
        dfs(1);
        System.out.println(answer);

    }
}
