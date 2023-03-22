package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BJ11508 {

    static int N;
    static Integer[] arr;
    static long answer;

    public static void solution() {

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            cnt++;
            if (cnt == 3) {
                cnt = 0;
                continue;
            } else {
                answer += arr[i];
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        solution();
        System.out.println(answer);

    }

}
