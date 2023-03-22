package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11501 {

    static int T;
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            int max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = N-1; j >= 0; j--) {
                if(arr[j] > max) {
                    max = arr[j];
                } else {
                    answer += (max - arr[j]);
                }
            }

            sb.append(answer).append('\n');
            answer = 0;

        }

        System.out.println(sb);

    }

}
