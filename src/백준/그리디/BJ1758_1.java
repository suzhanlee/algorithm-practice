package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BJ1758_1 {

    static int N;
    static Integer[] arr;
    static long answer;

    public static void solution() {

        for (int i = 0; i < arr.length; i++) {

            int num = arr[i] - (i + 1 - 1);

            if (num >= 0) {
                answer += num;
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
