//package 백준.브루트포스;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BJ1149 {
//
//    static int N;
//    static int[][] graph; // 빨강, 초록, 파랑
//    static int answer;
//
//    public static void solution() {
//
//        int sum = 0;
//
//        sum += graph[0][0];
//
//
//
//
//
//        sum += graph[0][1];
//
//
//
//        sum += graph[0][2];
//
//
//
//
//    }
//
//    public static void dfs(int L, int sum) {
//
//
//        sum += graph[0][0];
//
//        if (L == 4) {
//
//        } else {
//
//            for (int i = 0; i < 3; i++) {
//
//                dfs(L + 1, sum);
//            }
//        }
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                graph[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        solution();
//        dfs(1, 0);
//
//    }
//
//}
