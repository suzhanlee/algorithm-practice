package 프로그래머스.프로그래머스_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 큰수만들기 {

    static String number;
    static int k;

    public static String solution() {

        StringBuilder answer = new StringBuilder();

        int idx = 0;
        int len = number.length() - k;

        for (int i = 1; i <= len; i++) {

            int max = Integer.MIN_VALUE;
            // 각 자리 수를 정하기 위해 정해진 범위를 탐색하는 반복문
            // 현재 문자열의 길이 - (만들어야 하는 자리 수 - 현재 만들고 있는 자리 수)
            // number.length() - (len -i)
            for (int j = 0; j < i + k; j++) {

                if ((number.charAt(j) - '0') == 9) {
                    max = 9;
                    idx = j;
                    break;
                }

                if (max < (number.charAt(j) - '0')) {
                    max = number.charAt(j) - '0';
                    idx = j;
                }
            }

            answer.append(max);
            number = number.substring(idx + 1, number.length());
        }

        return answer.toString();

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        number = br.readLine();
        k = Integer.parseInt(br.readLine());

        String answer = solution();
        System.out.println(answer);


    }

}
