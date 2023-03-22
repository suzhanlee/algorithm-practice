package sortingandsearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삽입정렬 {

    public static int[] solution(int[] arr) {

        int tmp = 0;

        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                    if (j == 0) {
                        arr[j] = tmp;
                    }
                } else {
                    arr[j + 1] = tmp;
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : 삽입정렬.solution(arr)) {
            System.out.print(x + " ");

        }
    }
}