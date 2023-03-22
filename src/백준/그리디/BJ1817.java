package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1817 {

    static int N, M;
    static int answer;
    static int[] arr;

    public static void solution() {

        int tmp = M;

        for (int i = 0; i < arr.length; i++) {

            if (tmp - arr[i] < 0) {
                answer++;
                tmp = M;
            }
            tmp -= arr[i];

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N != 0) {

            arr = new int[N];

            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st1.nextToken());
            }

            solution();

            System.out.println(answer + 1);
        } else {
            System.out.println(0);
        }

    }


}
