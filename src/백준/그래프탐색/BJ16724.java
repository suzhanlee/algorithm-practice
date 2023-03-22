//package 백준.그래프탐색;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BJ16724 {
//
//    static int N, M;
//    static int[][] graph;
//    static int[] dx = {-1, 1, 0, 0}; // up down left right
//    static int[] dy = {0, 0, -1, 1}; //
//    static int[][] visited;
//    static int answer;
//    static int[][] checked;
//
//    public static int dfs(int x, int y) {
//
//        if(checked[x][y] != -1) {
//            return checked[x][y];
//        }
//
//        if(y < 1 || x < 1 || y > M || x > N || visited[x][y] == 1) {
//            return answer++;
//        }
//
//        visited[x][y] = 1;
//        int dir = graph[x][y];
//
//        int nx = x + dx[dir];
//        int ny = y + dy[dir];
//
//        checked[x][y] = dfs(nx, ny);
//        return checked[x][y];
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        graph = new int[N + 1][M + 1];
//        visited = new int[N + 1][M + 1];
//        checked = new int[N + 1][M + 1];
//
//        for (int i = 1; i <= N; i++) {
//            String s = br.readLine();
//            for (int j = 1; j <= M; j++) {
//                char c = s.charAt(j-1);
//
//                if (c == 'U') {
//                    graph[i][j] = 0;
//                } else if (c == 'D') {
//                    graph[i][j] = 1;
//                } else if (c == 'L') {
//                    graph[i][j] = 2;
//                } else if (c == 'R') {
//                    graph[i][j] = 3;
//                }
//                checked[i][j] = -1;
//            }
//        }
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= M; j++) {
//
//                if (visited[i][j] == 0) {
//                    visited[i][j] = 1;
//                    dfs(i, j);
//                }
//            }
//        }
//
//        System.out.println(answer);
//
//
//    }
//
//}
