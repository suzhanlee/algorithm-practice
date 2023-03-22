package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16435 {

    static int N, L; // 과일의 개수, 스네잌버드의 초기 길이
    static int answer;
    static Integer[] arr;

    public static void solution() {

        for (Integer integer : arr) {
            if (integer <= L) {
                L++;
                answer++;
            } else {
                break;
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        answer = L;

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        arr = new Integer[N];

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);

        solution();

        System.out.println(answer);

    }

}
