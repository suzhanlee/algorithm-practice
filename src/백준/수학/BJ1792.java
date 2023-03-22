package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1792 { //시간 초과 -> 다이아 문제였다....

    static int N;

    public static int solution(int a, int b, int gcd) {

        int min = 0;
        int answer = 0;
        int tmp = 0;

        for (int i = gcd; i <= a; i++) {
            for (int j = gcd; j <= b; j++) {

                if (i < j) {
                    min = j;
                } else {
                    min = i;
                }

                for (int k = gcd; k <= min; k++) {

                    if (i % k == 0 && j % k == 0) {
                        tmp = k;
                    }
                }

                if (tmp == gcd) {
                    tmp = 1;
                    answer++;
                }

            }
        }
        return answer;


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            sb.append(solution(a, b, d)).append('\n');

        }

        System.out.println(sb);
    }
}
