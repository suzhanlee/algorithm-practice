package 백준.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470 {

    static int N;
    static int[] arr;
    static int a1, a2;
    static int tmp, sum, max;

    public static void solution() {
        max = Integer.MAX_VALUE;

        int lt = 0;
        int rt = arr.length - 1;

        while (lt < rt) {

            sum = arr[lt] + arr[rt];
            tmp = Math.abs(sum);

            if (tmp < max) {
                max = tmp;
                a1 = arr[lt];
                a2 = arr[rt];
            }

            if (sum > 0) {
                rt--;
            } else {
                lt++;
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution();

        System.out.println(a1 + " " + a2);


    }

}
