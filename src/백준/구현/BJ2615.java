package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2615 {

    static int[][] board = new int[19][19];
    static int[][] visited = new int[19][19];

    static int victoryB = 0;
    static int victoryW = 0;

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; // 1 2 3 4 5 6 7 8
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    static ArrayList<Location> locations = new ArrayList<Location>();

    static class Location implements Comparable<Location> {

        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location o) {
            return this.y - o.y;
        }
    }

    // 검은알 : 2 , 흰 알 : 1

    public static void solution(int x, int y, int color) {

        solution1(x, y, color);
        solution2(x, y, color);
        solution3(x, y, color);
        solution4(x, y, color);
        solution5(x, y, color);
        solution6(x, y, color);
        solution7(x, y, color);
        solution8(x, y, color);

    }

    private static void solution1(int x, int y, int color) {

        boolean flag = true;
        Location location = new Location(x, y);

        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {

            nx += dx[0];
            ny += dy[0];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] != color) {
                    flag = false;
                }
            } else {
                return;
            }

        }

        if (flag) {

            nx += dx[0];
            ny += dy[0];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] == color) {
                    flag = false;
                }
            }

            x -= dx[0];
            y -= dy[0];

            if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {

                if (board[x][y] == color) {
                    flag = false;
                }
            }

            if (flag) {
                locations.add(location);
                if (color == 1) {
                    victoryW++;
                } else {
                    victoryB++;
                }
            }

        }

    }

    private static void solution2(int x, int y, int color) {

        boolean flag = true;
        Location location = new Location(x, y);
        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {

            nx += dx[1];
            ny += dy[1];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] != color) {
                    flag = false;
                }
            } else {
                return;
            }

        }

        if (flag) {

            nx += dx[1];
            ny += dy[1];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] == color) {
                    flag = false;
                }
            }

            x -= dx[1];
            y -= dy[1];

            if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {

                if (board[x][y] == color) {
                    flag = false;
                }
            }

            if (flag) {
                locations.add(location);
                if (color == 1) {
                    victoryW++;
                } else {
                    victoryB++;
                }
            }

        }

    }

    private static void solution3(int x, int y, int color) {

        boolean flag = true;
        Location location = new Location(x, y);

        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {

            nx += dx[2];
            ny += dy[2];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] != color) {
                    flag = false;
                }
            } else {
                return;
            }

        }

        if (flag) {

            nx += dx[2];
            ny += dy[2];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] == color) {
                    flag = false;
                }
            }

            x -= dx[2];
            y -= dy[2];

            if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {

                if (board[x][y] == color) {
                    flag = false;
                }
            }

            if (flag) {
                locations.add(location);
                if (color == 1) {
                    victoryW++;
                } else {
                    victoryB++;
                }
            }

        }

    }

    private static void solution4(int x, int y, int color) {

        boolean flag = true;
        Location location = new Location(x, y);

        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {

            nx += dx[3];
            ny += dy[3];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] != color) {
                    flag = false;
                }
            } else {
                return;
            }

        }

        if (flag) {

            nx += dx[3];
            ny += dy[3];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] == color) {
                    flag = false;
                }
            }

            x -= dx[3];
            y -= dy[3];

            if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {

                if (board[x][y] == color) {
                    flag = false;
                }
            }

            if (flag) {
                locations.add(location);
                if (color == 1) {
                    victoryW++;
                } else {
                    victoryB++;
                }
            }

        }

    }

    private static void solution5(int x, int y, int color) {

        boolean flag = true;
        Location location = new Location(x, y);

        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {

            nx += dx[4];
            ny += dy[4];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] != color) {
                    flag = false;
                }
            } else {
                return;
            }

        }

        if (flag) {

            nx += dx[4];
            ny += dy[4];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] == color) {
                    flag = false;
                }
            }

            x -= dx[4];
            y -= dy[4];

            if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {

                if (board[x][y] == color) {
                    flag = false;
                }
            }

            if (flag) {
                locations.add(location);
                if (color == 1) {
                    victoryW++;
                } else {
                    victoryB++;
                }
            }

        }

    }

    private static void solution6(int x, int y, int color) {

        boolean flag = true;
        Location location = new Location(x, y);

        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {

            nx += dx[5];
            ny += dy[5];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] != color) {
                    flag = false;
                }
            } else {
                return;
            }

        }

        if (flag) {

            nx += dx[5];
            ny += dy[5];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] == color) {
                    flag = false;
                }
            }

            x -= dx[5];
            y -= dy[5];

            if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {

                if (board[x][y] == color) {
                    flag = false;
                }
            }

            if (flag) {
                locations.add(location);
                if (color == 1) {
                    victoryW++;
                } else {
                    victoryB++;
                }
            }

        }

    }

    private static void solution7(int x, int y, int color) {

        boolean flag = true;
        Location location = new Location(x, y);

        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {

            nx += dx[6];
            ny += dy[6];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] != color) {
                    flag = false;
                }
            } else {
                return;
            }

        }

        if (flag) {

            nx += dx[6];
            ny += dy[6];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] == color) {
                    flag = false;
                }
            }

            x -= dx[6];
            y -= dy[6];

            if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {

                if (board[x][y] == color) {
                    flag = false;
                }
            }

            if (flag) {
                locations.add(location);
                if (color == 1) {
                    victoryW++;
                } else {
                    victoryB++;
                }
            }

        }

    }

    private static void solution8(int x, int y, int color) {

        boolean flag = true;
        Location location = new Location(x, y);

        int nx = x;
        int ny = y;

        for (int i = 0; i < 4; i++) {

            nx += dx[7];
            ny += dy[7];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] != color) {
                    flag = false;
                }
            } else {
                return;
            }

        }

        if (flag) {

            nx += dx[7];
            ny += dy[7];

            if (nx >= 0 && nx <= 18 && ny >= 0 && ny <= 18) {

                if (board[nx][ny] == color) {
                    flag = false;
                }
            }

            x -= dx[7];
            y -= dy[7];

            if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {

                if (board[x][y] == color) {
                    flag = false;
                }
            }

            if (flag) {
                locations.add(location);
                if (color == 1) {
                    victoryW++;
                } else {
                    victoryB++;
                }
            }

        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (visited[i][j] == 0 && (board[i][j] == 1 || board[i][j] == 2)) {

                    visited[i][j] = 1;
                    solution(i, j, board[i][j]);

                }

            }
        }

        Collections.sort(locations);

        if (victoryB == 2 && victoryW == 0) {

            System.out.println(2);
            int x = locations.get(0).x + 1;
            int y = locations.get(0).y + 1;
            System.out.println(x + " " + y);

        } else if (victoryW == 2 && victoryB == 0) {

            System.out.println(1);
            int x = locations.get(0).x + 1;
            int y = locations.get(0).y + 1;
            System.out.println(x + " " + y);

        } else {
            System.out.println(0);
        }

    }

}
