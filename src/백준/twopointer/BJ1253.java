package 백준.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253 {

    static int N;
    static int[] arr;
    static int answer;

    public static void solution() {

        for (int i = 0; i < N; i++) {
            int lt = 0;
            int rt = N - 1;
            while (true) {

                if (lt == i) {
                    lt++;
                } else if (rt == i) {
                    rt--;
                }

                if (lt >= rt) {
                    break;
                }

                if (arr[lt] + arr[rt] > arr[i]) {
                    rt--;
                } else if (arr[lt] + arr[rt] < arr[i]) {
                    lt++;
                } else {
                    answer++;
                    break;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution();

        System.out.println(answer);
    }

}
