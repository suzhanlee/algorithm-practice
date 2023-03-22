package 백준.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2343 {

    static int N, M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
    static int start;
    static int end;

    public static void solution() {

        while (start <= end) {

            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (sum > 0) {
                cnt++;
            }

            if (cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = Math.min(mid, answer);
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

            if (arr[i] > start) {
                start = arr[i];
            }

            end += arr[i];
        }

        solution();
        System.out.println(answer);

    }

}
