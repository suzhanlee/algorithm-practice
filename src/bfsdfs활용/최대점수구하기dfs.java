package bfsdfs활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대점수구하기dfs {

    static int[] timeArray;
    static int[] scores;
    static int N, M;
    static int answer = 0;

    public static void dfs(int L, int sum, int time) {

        if (time > M) {
            return;
        } else if (L == N) {
            answer = Math.max(answer, sum);
            return;
        } else {

            dfs(L + 1, sum + scores[L], time + timeArray[L]);
            dfs(L + 1, sum, time);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        scores = new int[N];
        timeArray = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st1.nextToken());
            int i2 = Integer.parseInt(st1.nextToken());
            scores[i] = i1;
            timeArray[i] = i2;

        }
        dfs(0, 0, 0);
        System.out.println(answer);
    }
}
