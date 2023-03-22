package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11365 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String str = br.readLine();
            if (str.equals("END")) {
                break;
            } else {
                StringBuilder sb = new StringBuilder();

                for (int i = str.length() - 1; i >= 0; i--) {
                    sb.append(str.charAt(i));
                }

                System.out.println(sb.toString());
            }


        }

    }

}
