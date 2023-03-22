package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20300 {

    static int N;
    static long[] arr;
    static long answer = Integer.MIN_VALUE;

    public static void solution() {

        if (arr.length % 2 == 0) { // 짝

            for (int i = 0; i < arr.length / 2; i++) {

                answer = Math.max(answer, arr[i] + arr[arr.length - 1 - i]);
            }

        } else { // 홀

            for (int i = 0; i < (arr.length - 1) / 2; i++) {

                answer = Math.max(answer, arr[i] + arr[arr.length - 2 - i]);

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        solution();

        System.out.println(answer);
    }
}
