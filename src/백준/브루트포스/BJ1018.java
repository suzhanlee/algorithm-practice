package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018 {

    static int N, M;
    static int[][] wArr;
    static int[][] bArr;
    static Character[][] arr;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int sum = 0;
    static int answer = Integer.MAX_VALUE;
    static int[][] visited;

    public static int solution(int x, int y, int sum) {

        int tmp = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (i % 2 == 0) { // i = 짝수
                    if (j % 2 == 0) { // j = 짝수
                        if (arr[i][j] != 'W') {
                            sum++;
                        }
                    } else { // j = 홀수
                        if (arr[i][j] != 'B') {
                            sum++;
                        }
                    }
                } else {
                    if (j % 2 == 0) { // j = 짝수
                        if (arr[i][j] != 'B') {
                            sum++;
                        }
                    } else { // j = 홀수
                        if (arr[i][j] != 'W') {
                            sum++;
                        }
                    }

                }

            }
        }

        tmp = sum;
        sum = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (i % 2 == 0) { // i = 짝수
                    if (j % 2 == 0) { // j = 짝수
                        if (arr[i][j] != 'B') {
                            sum++;
                        }
                    } else { // j = 홀수
                        if (arr[i][j] != 'W') {
                            sum++;
                        }
                    }
                } else {
                    if (j % 2 == 0) { // j = 짝수
                        if (arr[i][j] != 'W') {
                            sum++;
                        }
                    } else { // j = 홀수
                        if (arr[i][j] != 'B') {
                            sum++;
                        }
                    }

                }

            }
        }

        sum = Math.min(sum, tmp);
        return sum;

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Character[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 8 <= N && j + 8 <= M) {
                    int solution = solution(i, j, sum);
                    answer = Math.min(answer, solution);
                }
            }
        }

        System.out.println(answer);

    }

}
