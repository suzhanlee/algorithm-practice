//package 백준.그래프탐색;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BJ5547 {
//
//    static int W, H;
//    static int[][] graph;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        W = Integer.parseInt(st.nextToken());
//        H = Integer.parseInt(st.nextToken());
//
//        graph = new int[W][H];
//
//        for (int i = 1; i <= W; i++) {
//            StringTokenizer st1 = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= H; j++) {
//                if (j % 2 == 0) {
//                    graph[i][j] = Integer.parseInt(st1.nextToken());
//                } else {
//                    graph[i][j] = Integer.parseInt(st1.nextToken());
//                }
//            }
//
//        }
//
//
//    }
//
//}
