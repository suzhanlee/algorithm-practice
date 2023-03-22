package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1978 {

    static int N;
    static int answer;

    public static void solution(int K) {
        int cnt = 0;

        for (int i = 2; i < K; i++) {
            if (K % i == 0) {
                break;
            }
            cnt++;
        }
        if (cnt == K - 2) {
            answer++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(st.nextToken());
            solution(K);

        }

        System.out.println(answer);
    }
}
