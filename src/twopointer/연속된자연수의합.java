package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int rt = 0;
        int sum = 0;
        int answer = 0;

        for (int lt = 0; lt < N; lt++) {
            rt = lt;
            while (true) {
                sum += arr[rt];
                if (sum == N) {
                    answer++;
                    break;
                } else if (rt == N - 1) {
                    break;
                } else if (sum > N) {
                    break;
                }
                rt++;
            }
            sum = 0;
        }

        answer -= 1;

        System.out.println(answer);
    }
}
