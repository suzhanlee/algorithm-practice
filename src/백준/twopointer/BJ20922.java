package 백준.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20922 {

    static int N, K;
    static int[] arr;
    static int[] cnt;
    static int answer;

    public static void solution() {

        int p1 = 0;
        int p2 = 0;

        while (p2 <= p1) {

            if (p1 <= N - 1 && cnt[arr[p1]] < K) {

                cnt[arr[p1]]++;
                p1++;
            } else if (cnt[arr[p1]] == K) {

                cnt[arr[p2]]--;
                p2++;
            }

            answer = Math.max(answer, p1 - p2);

            if (p1 == N) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        cnt = new int[100001];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        solution();
        System.out.println(answer);

    }
}
