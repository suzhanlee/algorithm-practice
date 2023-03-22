package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16953 {

    static int A, B;
    static int answer;
    static boolean flag = true;

    public static void solution() {

        while (B != A) {

            if (B % 2 == 0) {
                B = B / 2;
                answer++;
            } else {
                String newString = String.valueOf(B);
                int length = newString.length();

                if (newString.charAt(length - 1) - '0' != 1) {
                    flag = false;
                    break;
                } else {
                    B -= 1;
                    B = B / 10;
                    answer++;
                    if (B < A) {
                        flag = false;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        solution();

        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(answer + 1);
        }
    }
}
