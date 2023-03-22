package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9655 {

    static int N;
    static int[] dp;
    static int idx;

    public static void dp() {

        while (true) {

            if (N >= 3) {
                N -= 3;
                idx++;
            } else if (N > 0) {
                N -= 1;
                idx++;
            } else {
                return;
            }

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp();

        if (idx % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }

}
