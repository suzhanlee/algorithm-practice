package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대길이연속부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int lt = 0;
        int cnt = 0;
        int answer = 0;

        for (int rt = 0; rt < N; rt++) {
            if (arr[rt] == 0) {
                cnt++;

                while (cnt > K) {
                    if (arr[lt] == 0) {
                        cnt--;
                    }
                    lt++;
                }
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        System.out.println(answer);
    }
}
