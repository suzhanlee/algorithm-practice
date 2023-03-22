package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11004 {

    static int N, K; // 배열의 크기, K 번째 수 구하기
    static int[] arr;
    static int answer;

    public static void conquer(int lt, int rt) {

        if (lt >= rt) {
            return;
        }

        int pivot = divide(lt, rt);

        conquer(lt, pivot - 1);
        conquer(pivot + 1, rt);

    }

    public static int divide(int left, int right) {

        int pivot = arr[left];
        int lt = left + 1;
        int rt = right;

        while (lt <= rt) {

            while (arr[lt] < pivot && lt > 0) {
                lt++;
            }

            while (arr[rt] > pivot && rt < arr.length - 1) {
                rt--;
            }

            if (lt <= rt) {
                swap(lt, rt);
                lt++;
                rt--;
            }
        }

        swap(left, rt);

        return rt;
    }

    private static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        conquer(0, arr.length - 1);

        System.out.println(arr[K - 1]);

    }
}
