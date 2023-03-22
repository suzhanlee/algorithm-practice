package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8892 {

    static int T;
    static int N;
    static String[] arr;

    public static int solution() {

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String strH = arr[i] + arr[j];
                String strT = arr[j] + arr[i];

                if (strH.length() % 2 == 0) {
                    String str1 = strH.substring(0, (strH.length() / 2));
                    String str2 = strH.substring(strH.length() / 2);
                    StringBuffer sb = new StringBuffer(str2).reverse();
                    if (str1.equals(sb)) {
                        System.out.println(strH);
                        return 1;
                    }
                }

                if (strH.length() % 2 == 1) {
                    String str1 = strH.substring(0, (strH.length() / 2));
                    String str2 = strH.substring((strH.length() / 2) + 1);
                    StringBuffer sb = new StringBuffer(str2).reverse();
                    if (str1.contentEquals(sb)) {
                        System.out.println(strH);
                        return 1;
                    }
                }

                if (strT.length() % 2 == 0) {
                    String str1 = strT.substring(0, (strT.length() / 2));
                    String str2 = strT.substring(strT.length() / 2);
                    StringBuffer sb = new StringBuffer(str2).reverse();
                    if (str1.contentEquals(sb)) {
                        System.out.println(strT);
                        return 1;
                    }
                }

                if (strT.length() % 2 == 1) {
                    String str1 = strT.substring(0, (strT.length() / 2));
                    String str2 = strT.substring((strT.length() / 2) + 1);
                    StringBuffer sb = new StringBuffer(str2).reverse();
                    if (str1.contentEquals(sb)) {
                        System.out.println(strT);
                        return 1;
                    }
                }

            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new String[N];

            for (int j = 0; j < N; j++) {
                arr[j] = br.readLine();

            }
            int cnt = solution();
            if (cnt != 1) {
                System.out.println(0);
            }


        }


    }

}
