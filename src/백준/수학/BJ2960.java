package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2960 {

    static int N, K;
    static int[] visited = new int[10001];
    static int answer;

    public static void solution() {

        int idx = 2;
        int cnt = 0;

        while (cnt != K) {
            for (int i = idx; i <= N; i++) {

                if (visited[i] == 0) {
                    if (i % idx == 0) {
                        visited[i] = 1;
                        cnt++;
                    }
                }

                if (cnt == K) {
                    answer = i;
                    break;
                }
            }
            idx++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        solution();

        System.out.println(answer);
    }
}
