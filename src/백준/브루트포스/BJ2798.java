package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2798 {

    static int N, M;
    static int[] arr;
    static int answer;

    public static void solution() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (min > (M - (arr[i] + arr[j] + arr[k])) && M >= arr[i] + arr[j] + arr[k]) {
                        answer = arr[i] + arr[j] + arr[k];
                        min = (M - (arr[i] + arr[j] + arr[k]));
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        solution();

        System.out.println(answer);


    }

}
