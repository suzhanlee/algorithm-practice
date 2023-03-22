package 백준.브루트포스;//package 백준.브루트포스;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BJ2615 {
//
//    static int[][] graph = new int[20][20];
//    static int answer;
//    static int[][] visited;
//    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
//    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
//    static boolean flag = false;
//    static StringBuilder sb = new StringBuilder();
//    static boolean draw = false;
//    static int cnt = 0;
//    static int[][] check = new int[20][20];
//    static int a, b;
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
//    public static void dfs(int L, int color, int x, int y, int[] dir, int[][] visited) {
//
//        if (L == 4) {
//
//            for (int i : dir) {
//                if (i == 4) {
//                    if (graph[x + dx[i]][y + dy[i]] != color) {
//                        if (a + dx[7 - i] >= 1 && a + dx[7 - i] <= 19 && b + dy[7 - i] >= 1
//                            && b + dy[7 - i] <= 19) {
//                            if (graph[a + dx[7 - i]][b + dy[7 - i]] != color) {
//                                flag = true;
//                                cnt++;
//                                return;
//                            }
//                        } else {
//                            flag = true;
//                            cnt++;
//                            return;
//                        }
//                    }
//                }
//            }
//
//        } else {
//
//            for (int i = 0; i < 8; i++) {
//
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//
//                if (nx >= 1 && nx <= 19 && ny >= 1 && ny <= 19 && graph[nx][ny] == color
//                    && visited[nx][ny] == 0 && check[nx][ny] == 0) {
//                    visited[nx][ny] = 1;
//                    dir[i+1] = dir[i+1] + 1;
//                    dfs(L + 1, color, nx, ny, dir, visited);
//                    visited[nx][ny] = 0;
//                }
//            }
//        }
//
//        if (cnt >= 2) {
////            flag = false;
//            draw = true;
//        }
//    }
//
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for (int i = 1; i <= 19; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= 19; j++) {
//                int x = Integer.parseInt(st.nextToken());
//                graph[i][j] = x;
//            }
//        }
//
//        visited = new int[20][20];
//
//        for (int i = 1; i <= 19; i++) {
//            for (int j = 1; j <= 19; j++) {
//                if (graph[i][j] == 1) {
//                    int[] dir = new int[9];
//                    int[][] visited = new int[20][20];
//                    a = i;
//                    b = j;
//                    dfs(0, 1, i, j, dir, visited);
//                    if (flag) {
//                        sb.append(i).append(" ").append(j);
//                        answer = 1;
//                        flag = false;
//                    }
//                    check[i][j] = 1;
//
//                } else if (graph[i][j] == 2) {
//                    int[] dir = new int[9];
//                    int[][] visited = new int[20][20];
//                    a = i;
//                    b = j;
//                    dfs(0, 2, i, j, dir, visited);
//                    if (flag) {
//                        sb.append(i).append(" ").append(j);
//                        answer = 2;
//                        flag = false;
//                    }
//                    check[i][j] = 1;
//
//                }
//            }
//        }
//
//        if (draw) {
//            System.out.println(0);
//        } else {
//            System.out.println(answer);
//            System.out.println(sb);
//        }
//
//
//    }
//
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2615 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[19][19];
        int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

        //		board 입력받기
        for (int i = 0; i < 19; i++) {
            String input = br.readLine();
            for (int j = 0, index = 0; j < 19; index += 2, j++) {
                board[i][j] = input.charAt(index);
            }
        }

        // 모든 칸에 대해 오목 완성 찾기
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (board[i][j] == '1' || board[i][j] == '2') {
                    for (int k = 0; k < 4; k++) {
                        int x = i; // x좌표
                        int y = j; // y좌표
                        int cnt = 1; // 일치하는 바둑알의 개수

                        // 증가하는 방향 탐색
                        while (true) {
                            x += dir[k][0];
                            y += dir[k][1];
                            if (0 <= x && x < 19 && 0 <= y && y < 19) {
                                if (board[i][j] == board[x][y]) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        x = i;
                        y = j;

                        // 증가하는 방향의 반대방향 탐색
                        while (true) {
                            x -= dir[k][0];
                            y -= dir[k][1];
                            if (0 <= x && x < 19 && 0 <= y && y < 19) {
                                if (board[i][j] == board[x][y]) {
                                    cnt++;
                                } else {
                                    break;
                                }

                            } else {
                                break;
                            }
                        }

                        // 같은 오목눈이 5개라면
                        if (cnt == 5) {
                            System.out.println(board[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }

                    }
                }
            }
        }

//		아무도 이기지 않았을 경우
        System.out.println(0);


    }
}