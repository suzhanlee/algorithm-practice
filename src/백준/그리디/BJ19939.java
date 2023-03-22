package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19939 {

    static int N, K; // 공의 개수, 바구니의 수
    // 각 바구니에는 1개이상의 공이 있어야 하지만, 바구니에 담긴 공의 개수는 모두 달라야 한다.
    static int answer;
    static int tmp;

    public static void solution() {

        for (int i = 1; i <= K; i++) {

            N -= i;
            if (N < 0) {
                break;
            }
        }

        if (N >= 0) {
            if (N % K > 0) {
                System.out.println(K);
            } else {
                System.out.println(K - 1);
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= K; i++) {
            tmp += i;
        }

        if (tmp > N) {
            System.out.println(-1);
        } else {
            solution();
        }
    }
}
