package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13305 {

    static int N;
    static long[] dis;
    static long[] city;
    static long answer;

    public static void solution() {

        answer += dis[0] * city[0];

        long min = city[0];

        for (int i = 1; i <= city.length - 1; i++) {

            if (min <= city[i]) {

                answer += min * dis[i];
            } else {
                answer += (city[i] * dis[i]);
                min = city[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dis = new long[N];
        city = new long[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {

            dis[i] = Long.parseLong(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            city[i] = Long.parseLong(st2.nextToken());
        }

        solution();

        System.out.println(answer);

    }

}
