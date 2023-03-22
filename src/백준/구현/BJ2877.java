package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2877 {

    static int K;
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        int num = 0;

        K++;

        while (K != -1) {


            num = K % 2;
            sb1.append(num);
            K = K / 2;

        }

        for (int i = sb1.toString().length() - 2; i >= 0; i--) {

            if (sb1.charAt(i) == '0') {
                sb2.append(4);
            } else {
                sb2.append(7);
            }
        }

        System.out.println(sb2);


    }

}
