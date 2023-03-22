package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ11047_1 {

    static int N, K;
    static int answer;
    static Integer[] arr;

    public static void solution() {

        int tmp = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= K) {
                tmp = i;
                break;
            }
        }

        for (int i = 0; i < arr.length - tmp; i++) {

            while (K >= arr[i]) {
                if (K >= arr[i]) {
                    K -= arr[i];
                    answer++;
                    if (K == 0) {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(arr, Collections.reverseOrder());

        solution();
        System.out.println(answer);


    }

}
