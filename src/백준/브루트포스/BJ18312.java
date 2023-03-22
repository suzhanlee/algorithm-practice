package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18312 {

    static int N, K;
    static int answer;

    public static void solution() {

        for (int hour = 0; hour <= N; hour++) {
            if (hour % 10 == K || hour / 10 == K) {
                answer += 3600;
            } else {
                for (int min = 0; min < 60; min++) {
                    if (min % 10 == K || min / 10 == K) {
                        answer += 60;
                    } else {
                        for (int sec = 0; sec < 60; sec++) {
                            if (sec % 10 == K || sec / 10 == K) {
                                answer++;
                            }

                        }
                    }

                }
            }

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
