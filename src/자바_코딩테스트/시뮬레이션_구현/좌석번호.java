package 자바_코딩테스트.시뮬레이션_구현;

class 좌석번호 {

    public int[] solution(int c, int r, int k) {

        int[] answer = new int[2];

        if (k > c * r) {
            return new int[]{0, 0};
        }

        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0;
        int y = 0;
        int cnt = 1;
        int d = 1;

        while (cnt < k) {

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }

            seat[x][y] = cnt;
            cnt++;
            x = nx;
            y = ny;
        }

        answer[0] = x + 1;
        answer[1] = y + 1;

        return answer;
    }
}
