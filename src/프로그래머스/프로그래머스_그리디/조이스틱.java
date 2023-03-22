package 프로그래머스.프로그래머스_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 조이스틱 {

    static String name;

    public static int solution() {

        int answer = 0;
        int len = name.length();

        int move = len - 1;
        for (int i = 0; i < len; i++) {

            if (name.charAt(i) > 'N') {

                answer += 'Z' - name.charAt(i) + 1;

            } else {

                answer += name.charAt(i) - 'A';

            }

            int conA = i + 1;
            //다음 글자부터 연속된 A가 있는 경우 되돌아가는게 빠른지 확인
            while (conA < len && name.charAt(conA) == 'A') {
                conA++;
            }

            move = Math.min(move, i + len - conA + i);
        }

        answer += move;

        return answer;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        name = br.readLine();

        int answer = solution();

        System.out.println(answer);

//        char c = 'A';
//        int i = c - '0';
//
//        System.out.println("i = " + i);
//        System.out.println('Z' - '0');

    }

}
