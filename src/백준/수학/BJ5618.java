package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ5618 {

    static int N;
    static ArrayList<Integer> answer;
    static int[] arr;

    public static void solution(int[] arr) {

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        for (int j = 1; j <= min; j++) {
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] % j == 0) {
                    cnt++;
                }

                if (cnt == arr.length) {
                    System.out.println(j);
                }
            }
            cnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            solution(arr);
        }


    }

}
