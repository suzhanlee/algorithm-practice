package 백준.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2018 {

    static int N;
    static int[] arr;
    static int answer;
    static int sum;

    public static void solution() {

        int lt = 1;
        int rt = 1;

        while (lt <= rt) {

            sum += arr[rt];

            if (lt == arr.length - 1) {
                answer++;
                break;
            }
            if (sum == N) {
                answer++;
                lt++;
                rt = lt;
                sum = 0;
                continue;
            } else if (sum > N) {
                lt++;
                rt = lt;
                sum = 0;
                continue;
            }

            rt++;

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        solution();
        System.out.println(answer);


    }

}
