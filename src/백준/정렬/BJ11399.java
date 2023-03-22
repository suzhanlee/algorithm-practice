package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11399 { //삽입 정렬

    static int N;
    static int[] arr;
    static int sum;
    static int answer;

    public static void solution() {

        for (int i = 1; i < N; i++) {

            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        for (int x : arr) {
            sum += x;
            answer += sum;
        }

        System.out.println(answer);


    }

}
