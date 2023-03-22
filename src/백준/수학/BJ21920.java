package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ21920 {

    static int N, X;
    static int[] arr;
    static ArrayList<Integer> array = new ArrayList<>();
    static double sum;
    static double average;

    public static void solution(int[] arr) {

        int gcd = 1;
        double cnt = 0;

        for (int i = 0; i < arr.length; i++) {

            int min;
            int max;
            if (arr[i] >= X) {
                max = arr[i];
                min = X;
            } else {
                max = X;
                min = arr[i];
            }

            gcd = eucd(max, min);

            if (gcd == 1) {
                sum += arr[i];
                cnt++;
            }
            gcd = 1;
        }

        if (cnt >= 1) {
            average = sum / cnt;
        }


    }

    public static int eucd(int max, int min) {
        int r = max % min;

        if (r == 0) {
            return min;
        } else {
            return eucd(min, r);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int i1 = Integer.parseInt(st.nextToken());
            arr[i] = i1;
        }

        X = Integer.parseInt(br.readLine());

        solution(arr);
        if (average > 0) {
            System.out.println(average);
        }
    }
}
