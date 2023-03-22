package 백준.브루트포스;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16439 {

    static int N, M; //회원수, 치킨수
    static int[][] arr;
    static int answer;
    static int[] visited;
    static int[] chicken;

    public static void combination(int L, int start) {
        if (L == 3) {
            int tmp = 0;

            for (int i = 0; i < N; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < M; j++) {
                    if (visited[j] == 1) {
                        max = Math.max(max, arr[i][j]);
                    }
                }
                tmp += max;
            }
            answer = Math.max(tmp, answer);
        } else {

            for (int i = start; i < M; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    combination(L + 1, i + 1);
                    visited[i] = 0;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[M];
        arr = new int[N][M];
        chicken = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int i1 = Integer.parseInt(st1.nextToken());
                arr[i][j] = i1;
            }
        }

        combination(0, 0);

        System.out.println(answer);
    }

}
