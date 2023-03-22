package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1325 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int cnt;
    static int answer = 0;
    static int[] computer;


    public static int dfs(int L) {

        for (int x : graph.get(L)) {
            if (visited[x] == 0) {
                visited[x] = 1;
                cnt++;
                dfs(x);
                visited[x] = 0;
            }
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        graph = new ArrayList<ArrayList<Integer>>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new int[M + 1];
        computer = new int[M + 1];

        for (int i = 0; i <= M; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st1.nextToken());
            int i2 = Integer.parseInt(st1.nextToken());
            graph.get(i2).add(i1);
        }

        for (int i = 1; i <= M; i++) {
            cnt = 0;
            visited[i] = 1;
            int cnt = dfs(i);
            answer = Math.max(answer, cnt);
            computer[i] = cnt;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= M; i++) {
            if (computer[i] == answer) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
