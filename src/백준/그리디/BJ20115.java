package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20115 {

    static int N;
    static Double[] arr;
    static double answer;

    public static void solution() {

        for (int i = 0; i < arr.length - 1; i++) {
            answer += arr[i] / 2;

        }

        answer += arr[arr.length - 1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new Double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Double.valueOf(st.nextToken());
        }

        Arrays.sort(arr);

        solution();

        System.out.println(answer);

    }
}
