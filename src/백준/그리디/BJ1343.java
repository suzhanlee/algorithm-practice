package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1343 {

    static String N;
    static StringBuilder sb = new StringBuilder();
    static boolean flag = false;

    public static void solution() {

        int cnt = 0;

        for (char x : N.toCharArray()) {

            if (x == 'X') {
                cnt++;
            } else if (x == '.') {
                if (cnt % 2 != 0) {
                    System.out.println(-1);
                    flag = true;
                    break;
                } else {

                    while (cnt != 0) {

                        if (cnt >= 4) {
                            cnt -= 4;
                            sb.append("AAAA");
                        } else if (cnt >= 2) {
                            cnt -= 2;
                            sb.append("BB");
                        }
                    }
                }
                sb.append('.');
            }
        }

        while (cnt != 0) {

            if (cnt >= 4) {
                cnt -= 4;
                sb.append("AAAA");

            } else if (cnt >= 2) {
                cnt -= 2;
                sb.append("BB");

            }

            if (cnt == 1) {
                if (!flag) {
                    System.out.println(-1);
                    flag = true;
                }
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();

        solution();

        if (!flag) {
            System.out.println(sb);
        }
    }
}
