package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16916 { // KMP 문자열 매칭 알고리즘으로 풀어야 풀린다 (아직 안함 이제 해야함!!)

    static String P, S;
    static int answer = 0;

    public static void solution() {

        char[] pArray = P.toCharArray();
        char[] sArray = S.toCharArray();
        int length = S.length();
        int cnt = 0;

//        if(P.contains(S)) {  => 시간 초과 코드 ( 맞긴 하다 시간이 충분하다면...) , 겨우 만들었는데....
//
//            for (int i = 0; i < P.length(); i++) {
//                if (pArray[i] == sArray[0]) {
//                    int idx = i;
//                    if (i + length > P.length()) {
//                        break;
//                    }
//
//                    for (int j = i; j < i + length; j++) {
//                        if (pArray[j] == sArray[j - idx]) {
//                            cnt++;
//                        } else {
//                            break;
//                        }
//                    }
//
//                    if (cnt == length) {
//                        answer = 1;
//                        break;
//                    }
//
//                    cnt = 0;
//                }
//
//            }
//        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        P = br.readLine();
        S = br.readLine();

        solution();
        System.out.println(answer);

    }
}