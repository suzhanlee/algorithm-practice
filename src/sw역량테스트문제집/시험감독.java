package sw역량테스트문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {

    static long N;
    static long[] arr;
    static long B, C;
    static long answer;

    public static long solution(long testTakerNum) {

        long leftTakerNum = testTakerNum - B;
        long number = 1;

        if (leftTakerNum <= 0) {
            return number;
        }

        if (C >= leftTakerNum) {
            return number + 1;
        }

        number += (leftTakerNum / C);

        if (leftTakerNum % C != 0) {
            return number + 1;
        }

        return number;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        arr = new long[(int) N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st2.nextToken());
        C = Integer.parseInt(st2.nextToken());

        for (int i = 0; i < N; i++) {
            answer += solution(arr[i]);

        }

        System.out.println(answer);
    }

}
