package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대매출 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int i = 0;
        int[] array = new int[N];
        while (st2.hasMoreTokens()) {
            array[i] = Integer.parseInt(st2.nextToken());
            i++;
        }

        int window = 0;
        for (int j = 0; j < K; j++) {
            window += array[j];
        }
        int max = window;

        for (int j = K; j < N; j++) {
            window += (array[j] - array[j - K]);
            if (window > max) {
                max = window;
            }
        }
        System.out.println(max);
    }

}
