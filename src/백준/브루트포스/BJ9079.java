//package 백준.브루트포스;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BJ9079 {
//    static int T;
//    static String[][] graph;
//    static int answer;
//    static int[] visited;
//
//    static class Point {
//        int x;
//        int y;
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void dfs(int L, int cnt) {
//
//        if (L == 8) {
//            if (check()) {
//                answer = Math.min(answer, cnt);
//            }
//        } else {
//            for (int i = 0; i < 8; i++) {
//                ArrayList<Point> points = flip(i);
//                if (visited[i] == 0) {
//                    visited[i] = 1;
//                    for (Point point : points) {
//                        if (graph[point.x][point.y].equals("H")) {
//                            graph[point.x][point.y] = "T";
//                        } else {
//                            graph[point.x][point.y] = "H";
//                        }
//                    }
//                    dfs(L + 1, cnt + 1);
//                    visited[i] = 0;
//                    dfs(L + 1, cnt);
//                    visited[i] = 1;
//                }
//            }
//        }
//    }
//
//    private static ArrayList<Point> flip(int i) {
//        if (i == 0) {
//            ArrayList<Point> points = new ArrayList<>();
//            points.add(new Point(0, 0));
//            points.add(new Point(0, 1));
//            points.add(new Point(0, 2));
//
//            return points;
//        } else if (i == 1) {
//            ArrayList<Point> points = new ArrayList<>();
//            points.add(new Point(1, 0));
//            points.add(new Point(1, 1));
//            points.add(new Point(1, 2));
//
//            return points;
//        } else if (i == 2) {
//            ArrayList<Point> points = new ArrayList<>();
//            points.add(new Point(2, 0));
//            points.add(new Point(2, 1));
//            points.add(new Point(2, 2));
//
//            return points;
//        } else if (i == 3) {
//            ArrayList<Point> points = new ArrayList<>();
//            points.add(new Point(0, 0));
//            points.add(new Point(1, 0));
//            points.add(new Point(2, 0));
//
//            return points;
//        } else if (i == 4) {
//            ArrayList<Point> points = new ArrayList<>();
//            points.add(new Point(0, 1));
//            points.add(new Point(1, 1));
//            points.add(new Point(2, 1));
//
//            return points;
//        } else if (i == 5) {
//            ArrayList<Point> points = new ArrayList<>();
//            points.add(new Point(0, 2));
//            points.add(new Point(1, 2));
//            points.add(new Point(2, 2));
//
//            return points;
//        } else if (i == 6) {
//            ArrayList<Point> points = new ArrayList<>();
//            points.add(new Point(0, 0));
//            points.add(new Point(1, 1));
//            points.add(new Point(2, 2));
//
//            return points;
//        } else {
//            ArrayList<Point> points = new ArrayList<>();
//            points.add(new Point(0, 2));
//            points.add(new Point(1, 1));
//            points.add(new Point(2, 0));
//
//            return points;
//        }
//    }
//    private static boolean check() {
//
//        if (graph[0][0].equals("H")) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (!graph[i][j].equals("H")) {
//                        return false;
//                    }
//                }
//            }
//        } else {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (!graph[i][j].equals("T")) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        T = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < T; i++) {
//            graph = new String[3][3];
//            for (int j = 0; j < 3; j++) {
//
//                StringTokenizer st = new StringTokenizer(br.readLine());
//
//                String str1 = st.nextToken();
//                String str2 = st.nextToken();
//                String str3 = st.nextToken();
//
//                graph[j][0] = str1;
//                graph[j][1] = str1;
//                graph[j][2] = str1;
//
//            }
//            answer = Integer.MAX_VALUE;
//            visited = new int[8];
//            dfs(0, 0);
//            System.out.println(answer);
//        }
//
//
//    }
//
//}
