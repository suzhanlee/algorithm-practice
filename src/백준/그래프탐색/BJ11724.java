package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11724 { // checked[] 로 하는 방식이 visited[][] 보다 훨씬 빠르다 잘 이용하자!!

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[][] visited;
    static int answer;
    static int[] checked;

    public static void dfs(int V) {

        for (int x : graph.get(V)) {
            if (checked[x] == 0) {
                checked[x] = 1;
                dfs(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

//        visited = new int[N + 1][N + 1];
        checked = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i <= N; i++) {
            if (checked[i] == 0) {
                checked[i] = 1;
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
