package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int answer = 0;
        int idx1 = 0;
        int idx2 = 0;
        int sum = arr[idx1];

        while (true) {

            if (sum == M) {
                answer++;
                idx1++;
                if (idx1 == N) {
                    break;
                }
                sum -= arr[idx1 - 1];

            } else if (sum < M) {
                idx2++;
                if (idx2 == N) {
                    break;
                }
                sum += arr[idx2];
            } else {
                idx1++;
                if (idx1 == N) {
                    break;
                }
                sum -= arr[idx1 - 1];
            }
        }

        System.out.println(answer);
    }
}
