package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20164 {

    static String N;
    static int tmp;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;


    public static void solution2(int num) {

        int x = num % 10 + num / 10;

        if (x % 2 == 1) {
            tmp++;
        }

        if (x >= 10) {
            solution2(x);
        } else {
            solution1(x);
        }
    }

    public static void solution1(int num) {
        if (num % 2 == 1) {
            tmp += 1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();

        if (N.length() == 1) {
            solution1(Integer.parseInt(N));
            System.out.println(tmp + " " + tmp);

        } else if (N.length() == 2) {
            solution2(Integer.parseInt(N));
            System.out.println(tmp + " " + tmp);

        } else {

            nums = new int[2];

            combi(0, 1);

            System.out.println(max + " " + min);
        }
    }

    public static void combi(int L, int startLine) {

        if (L == 2) {

            int x = Integer.parseInt(N.substring(0, nums[0])) + Integer.parseInt(
                N.substring(nums[0], nums[1]))
                + Integer.parseInt(N.substring(nums[1]));

            if (x >= 100) {
                combi(0, 1);
            } else if (x >= 10) {
                solution2(x);
            } else {
                solution1(x);
            }

            max = Math.max(tmp, max);
            min = Math.min(tmp, min);
            tmp = 0;

        } else {
            for (int i = startLine; i <= N.length() - 1; i++) {
                nums[L] = i;
                combi(L + 1, i + 1);
            }
        }

    }

}
