package 백준.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ22862 {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st1.nextToken());
            arr[i] = num % 2 == 0 ? true : false;
        }

        // 투포인터
        int max = 0;
        int lt = 0;
        int rt = 0;
        int cnt = 0;
        while (rt < N) {
            if (cnt < K) {
                if (!arr[rt]) {
                    cnt++;
                }
                rt++;
                max = Math.max(rt - lt - cnt, max);
            } else if (arr[rt]) {
                rt++;
                max = Math.max(rt - lt - cnt, max);
            } else if (!arr[rt]) {
                if (!arr[lt]) {
                    cnt--;
                }
                lt++;
            }
        }

        System.out.println(max);
    }
}