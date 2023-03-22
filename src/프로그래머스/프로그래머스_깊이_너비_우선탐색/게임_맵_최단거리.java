package 프로그래머스.프로그래머스_깊이_너비_우선탐색;

import java.util.LinkedList;

class 게임_맵_최단거리 {

    int[][] maps, visited;
    int m, n;
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};

    void bfs() {
        visited[0][0] = 1;
        var queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[1];
            int y = curr[0];

            for (var i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (ny >= m || ny < 0 || nx >= n || nx < 0) {
                    continue;
                }
                if (visited[ny][nx] == 0 && maps[ny][nx] == 1) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        m = maps.length;
        n = maps[0].length;
        visited = new int[m][n];
        this.maps = maps;

        bfs();
        answer = visited[m - 1][n - 1] == 0 ? -1 : visited[m - 1][n - 1];
        return answer;
    }
}