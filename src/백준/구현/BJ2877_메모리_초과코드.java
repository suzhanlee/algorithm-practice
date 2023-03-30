package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2877_메모리_초과코드 {

    static int K;
    static int idx;
    static int num;
    static boolean flag = false;

    public static void solution() {

        idx = 1;

        if (K == 1) {
            System.out.println(4);
        } else if (K == 2) {
            System.out.println(7);

        } else {

            int tmp = K;

            while (tmp > 0) {

                tmp = (int) (tmp - Math.pow(2, idx));
                idx++;

            }

            // idx-1 : 자릿수

            for (int i = 1; i < idx - 1; i++) {

                K -= Math.pow(2, i);

            }

            dfs(0, "");

        }

    }

    private static void dfs(int L, String str) {

        if (flag) {
            return;
        }

        if (L == idx - 1) {
            num++;

            if (K == num) {
                System.out.println(str);
                flag = true;

            }

        } else {

            dfs(L + 1, str + 4);
            dfs(L + 1, str + 7);
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        solution();

    }
}
