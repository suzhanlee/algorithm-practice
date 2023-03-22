package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ21314 {

    static String str;
    static String max = "";
    static String min = "";
    static BufferedReader br;

    public static void solution() throws IOException {

        str = br.readLine();
        String newString = "";
        int cntMax = 0;
        int cntMin = 0;

        for (char x : str.toCharArray()) {

            if (x == 'M') {
                cntMax++;
            } else {
                if (cntMax >= 1) {
                    for (int i = 0; i < cntMax; i++) {
                        if (i == 0) {
                            max += 5;
                        } else {
                            max += 0;
                        }

                    }
                    max += 0;
                } else {
                    max += 5;
                }
                cntMax = 0;
            }
        }

        for (int i = 0; i < cntMax; i++) {
//            if (i == 0) {
//                max += 1;
//            } else {
//                max += 0;
//            }
            max += 1;
        }

        for (char x : str.toCharArray()) {

            if (x == 'M') {
                cntMin++;
            } else {
                if (cntMin >= 1) {
                    for (int i = 0; i < cntMin; i++) {
                        if (i == 0) {
                            min += 1;
                        } else {
                            min += 0;
                        }
                    }
                }
                min += 5;
                cntMin = 0;
            }
        }

        for (int i = 0; i < cntMin; i++) {
            if (i == 0) {
                min += 1;
            } else {
                min += 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        solution();

        System.out.println(max.toString());
        System.out.println(min.toString());

    }

}
