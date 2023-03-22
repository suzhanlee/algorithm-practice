package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ22864 {

    static int A, B, C, M;
    static int answer;

    public static void solution() {

        int hour = 24;
        int burnTime = 0;

        while (hour != 0) { // 24 번 하도록

            if (burnTime + A <= M) {
                burnTime += A;
                answer += B;
            } else {
                burnTime -= C;
                if (burnTime < 0) {
                    burnTime = 0;
                }
            }

            hour--;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken()); //시간당 피로도
        B = Integer.parseInt(st.nextToken()); //시간당 일처리
        C = Integer.parseInt(st.nextToken()); //시간당 피로도 회복
        M = Integer.parseInt(st.nextToken()); //번아웃 시간

        solution();
        System.out.println(answer);


    }
}
