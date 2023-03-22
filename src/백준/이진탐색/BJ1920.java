package 백준.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean flag = true;

    public static void solution(int x) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            int value = arr[mid];
            if (x == value) {
                sb.append(1).append('\n');
                flag = false;
                break;
            } else if (x > value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {

            int x = Integer.parseInt(st2.nextToken());
            solution(x);
            if (flag) {
                sb.append(0).append('\n');
            }
            flag = true;
        }

        System.out.println(sb);


    }

}
