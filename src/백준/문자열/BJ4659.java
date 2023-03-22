package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4659 { //실패 (50%)

    static StringBuilder sb = new StringBuilder();
    static char[] collection = {'a', 'e', 'i', 'o', 'u'};

    public static void solution(String str) {

        boolean hasCollection = false; // 모음이 있나 없나 <0/1 로 구분>
        int acnt = 0; // 연속된 자음의 갯수
        int Acnt = 0; // 연속된 모음의 갯수
        boolean isConst = true; // 자음인가? 모음인가?
        boolean isDouble = false; // 연속된 같은 글자(2 연속)가 있는가?
        boolean isTrifle = false; // 모음이나 자음이 연속으로 3개 나왔는가?

        char[] chars = str.toCharArray();

        for (char value : collection) {
            if (chars[0] == value) {
                hasCollection = true;
                Acnt++;
                break;
            }
        }

        for (int i = 1; i < str.length(); i++) {

            if (chars[i] == chars[i - 1]) {
                if ((chars[i] != 'e') && (chars[i] != 'o')) {
                    isDouble = true;
                    break;
                }
            }

            for (char c : collection) {
                if (chars[i] == c) {
                    isConst = false;
                    hasCollection = true;
                    Acnt++;
                    break;
                }
            }

            if (isConst) {
                acnt++;
                Acnt = 0;
            } else {
                acnt = 0;
            }

            if (acnt >= 3) {
                isTrifle = true;
                break;
            }

            if (Acnt >= 3) {
                isTrifle = true;
                break;
            }

            isConst = true;
        }

        if (!hasCollection) {
            sb.append("<").append(str).append(">").append(" is not acceptable.").append('\n');
        } else if (isDouble) {
            sb.append("<").append(str).append(">").append(" is not acceptable.").append('\n');
        } else if (isTrifle) {
            sb.append("<").append(str).append(">").append(" is not acceptable.").append('\n');
        } else {
            sb.append("<").append(str).append(">").append(" is acceptable.").append('\n');
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();

            if (!str.equals("end")) {
                solution(str);
            } else {
                break;
            }
        }

        System.out.println(sb);


    }

}
