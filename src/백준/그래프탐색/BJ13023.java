package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static boolean flag = true;

    public static void dfs(int L, int V) {

        if (!flag) {
            return;
        }

        if (L == 4) {
            flag = false;
            System.out.println(1);

        } else {

            for (int x : graph.get(V)) {
                if (visited[x] == 0) {
                    visited[x] = 1;
                    dfs(L + 1, x);
                    visited[x] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);

        }

        for (int i = 0; i < N; i++) {
            visited = new int[N];
            visited[i] = 1;
            dfs(0, i);

        }

        if (flag) {
            System.out.println(0);
        }

    }

}
