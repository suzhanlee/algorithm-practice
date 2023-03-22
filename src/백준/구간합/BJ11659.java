package 백준.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {

    static int N, M;
    static int[] sum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        sum[0] = Integer.parseInt(st1.nextToken());

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st1.nextToken());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            int tmp;

            if (x == 1) {
                tmp = 0;
            } else {
                tmp = sum[x - 2];
            }

            sb.append(sum[y - 1] - tmp).append('\n');


        }

        System.out.println(sb);


    }

}
