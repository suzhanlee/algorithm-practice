package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1427 { //선택 정렬

    static String N;
    static long[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void solution() {

        for (int i = 0; i < N.length() - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < N.length(); j++) {

                if (arr[idx] < arr[j]) {
                    idx = j;
                }
            }

            long tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();

        arr = new long[N.length()];

        for (int i = 0; i < N.length(); i++) {
            arr[i] = N.charAt(i) - '0';
        }

        solution();

        for (int i = 0; i < N.length(); i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}
