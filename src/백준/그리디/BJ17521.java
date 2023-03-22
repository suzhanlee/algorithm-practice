package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17521 {

    static int N; // 요일 수
    static long W; // 초기 현금
    static long answer;
    static long[] arr; // 요일당 주가
    static long cnt; // 현재 가지고 있는 코인 개수

    public static void solution() {

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i + 1] < arr[i]) { // 팔아야 함
                W += cnt * arr[i];
                cnt = 0;
            } else if (arr[i + 1] > arr[i]) { // 사야함
                long share = W / arr[i];
                W -= share * arr[i];
                cnt += share;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();

        answer = arr[N - 1] * cnt + W;

        System.out.println(answer);

    }

}
