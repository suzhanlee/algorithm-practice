//package 백준.그래프탐색;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BJ16918 {
//
//    static int R, C, N;
//    static Queue<Point> queue = new LinkedList<>();
//    static int[] dx = {1, 0, 0, -1};
//    static int[] dy = {0, 1, -1, 0};
//    static int[][] graph;
//    static int[][] timeTable;
//    static int time;
//
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
//    public static void bfs(int x, int y) {
//
//        if()
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                if(graph[i][j] == '.') {
//                    graph[i][j] = 'O';
//                    timeTable[i][j] = 3;
//                }
//            }
//        }
//
//        while (!queue.isEmpty()) {
//
//            Point pt = queue.poll();
//
//            if (graph[pt.x][pt.y] == 'O') {
//
//                for (int i = 0; i < 4; i++) {
//                    int nx = pt.x + dx[i];
//                    int ny = pt.y + dy[i];
//
//                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
//
//                        graph[nx][ny] = '.';
//                    }
//                }
//            }
//        }
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        R = Integer.parseInt(st.nextToken()); //행
//        C = Integer.parseInt(st.nextToken()); //열
//        N = Integer.parseInt(st.nextToken()); // N초 후 상태는?
//
//        graph = new int[R][C];
//
//        for (int i = 0; i < R; i++) {
//            StringTokenizer st1 = new StringTokenizer(br.readLine());
//            String str = st1.nextToken();
//            for (int j = 0; j < C; j++) {
//                graph[i][j] = str.charAt(j) - '0';
//            }
//        }
//
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                if (graph[i][j] == 'O') {
//                    timeTable[i][j] = 3;
//                    queue.offer(new Point(i, j));
//                }
//            }
//        }
//
//        bfs(0, 0);
//
//
//    }
//}
