package 백준.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 {

    static int N, M;
    static int[] arr;
    static long answer = Integer.MIN_VALUE;

    public static void solution() {

        int mid;
        int start = 0;
        int end = arr[arr.length - 1];

        while (start <= end) {

            mid = (start + end) / 2;

            long sum = 0;

            for (int i = 0; i < N; i++) {

                if (mid < arr[i]) {
                    sum += (arr[i] - mid);
                }
            }

            if (sum > M) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else if (sum < M) {
                end = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                break;
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);

        solution();

        System.out.println(answer);


    }

}
