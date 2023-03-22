package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ11256 {

    static int T, J, N; //테스트의 수, 사탕의 개수, 상자의 개수
    static Integer[] arr;
    static int sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            J = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            arr = new Integer[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());

                int R = Integer.parseInt(st1.nextToken());
                int C = Integer.parseInt(st1.nextToken());

                arr[i] = R * C;
            }

            Arrays.sort(arr, Collections.reverseOrder());

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] < J) {
                    J -= arr[i];
                } else {
                    System.out.println(i + 1);
                    break;
                }
            }

        }

    }

}
