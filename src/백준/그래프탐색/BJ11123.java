//package 백준.그래프탐색;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BJ11123 { // 문제 설명 부족...
//
//    static int T, H, W;
//    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
//    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
//    static ArrayList<ArrayList<String>> graph;
//    static Queue<Point> queue = new LinkedList<>();
//    static int[][] visited;
//    static int answer;
//
//    static class Point {
//
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void bfs() {
//
//        while (!queue.isEmpty()) {
//
//            Point point = queue.poll();
//
//            for (int i = 0; i < 8; i++) {
//                int nx = point.x + dx[i];
//                int ny = point.y + dy[i];
//
//                if(nx >= 1 && nx <= H && ny >= 1 && ny <= W && visited[nx][ny] == 0) {
//                    if (graph.get(nx).get(ny-1).equals("#")) {
//                        visited[nx][ny] = 1;
//                        answer++;
//
//                    }
//
//                }
//            }
//
//
//        }
//    }
//
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        T = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < 2; i++) {
//            graph = new ArrayList<ArrayList<String>>();
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            H = Integer.parseInt(st.nextToken());
//            W = Integer.parseInt(st.nextToken());
//
//            for (int j = 0; j <= H; j++) {
//                graph.add(new ArrayList<>());
//            }
//            visited = new int[H + 1][W + 1];
//
//            for (int j = 1; j <= H ; j++) {
//                String str = br.readLine();
//                for (int k = 0; k < W; k++) {
//                    graph.get(j).add(k,String.valueOf(str.charAt(k)));
//                }
//            }
//
//            for (int j = 1; j <= H; j++) {
//                for (int k = 1; k <= W; k++) {
//                    if (graph.get(j).get(k-1).equals("#") && visited[i][j] == 0) {
//                        visited[j][k] = 1;
//                        queue.offer(new Point(i, j));
//                        bfs();
//                    }
//                }
//            }
//
//            System.out.println(answer);
//            answer = 0;
//
//        }
//
//
//    }
//
//}
