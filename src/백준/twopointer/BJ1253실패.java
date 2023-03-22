package 백준.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253실패 {

    static int N;
    static long[] arr;
    static int answer;
    static long want;
    static long sum;
    static boolean flag = false;

    public static void solution() {

        for (int i = 0; i < N; i++) {
            if (arr[i] != 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return;
        }

        int lt = 0;
        int rt = arr.length - 2;
        int pt = arr.length - 1;

        while (pt != 0) {

            want = arr[pt];

            if (arr[lt] + arr[rt] == want) {
                answer++;
                pt--;
                lt = 0;
                rt = pt + 1;
                continue;
            } else if (arr[lt] + arr[rt] > want) {
                rt--;

            } else if (arr[lt] + arr[rt] < want) {
                lt++;
            }

            if (rt == pt) {
                rt--;
            }

            if (lt == pt) {
                lt++;
            }

            if (lt == rt || lt > rt) {
                pt--;
                lt = 0;
                rt = pt + 1;
            }

        }

        lt = 1;
        rt = arr.length - 1;
        pt = 0;
        while (lt < rt) {

            if (arr[lt] + arr[rt] == arr[pt]) {
                answer++;
                break;
            }

            if (arr[lt] + arr[rt] > arr[pt]) {
                rt--;
            } else if (arr[lt] + arr[rt] < arr[pt]) {
                lt++;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solution();

        if (flag) {
            System.out.println(answer);
        } else {
            if (N >= 3) {
                System.out.println(N);
            } else {
                System.out.println(0);
            }
        }


    }

}
