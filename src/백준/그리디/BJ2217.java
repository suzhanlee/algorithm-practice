package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2217 {

    static int N;
    static int[] arr;
    static int Max = Integer.MIN_VALUE;

    public static void solution() {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                if (j == arr.length - 1) {
                    sum = arr[i] * (N - i);
                    Max = Math.max(Max, sum);
                }
            }

            sum = 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        solution();

        System.out.println(Max);

    }
}
