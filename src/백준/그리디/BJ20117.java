package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ20117 {

    static int N;
    static Integer[] arr;
    static long answer;

    public static void solution() {

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new Integer[N];

        int i;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        if (N % 2 == 1) {

            for (i = 0; i < N / 2; i++) {

                answer += 2L * arr[i];
            }
            answer += arr[i];
        } else {

            for (i = 0; i < N / 2; i++) {

                answer += 2L * arr[i];
            }
        }

        System.out.println(answer);

    }

}

