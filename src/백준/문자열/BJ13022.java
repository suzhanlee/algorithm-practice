package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ13022 {

    static String S;
    static char[] chars;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        if (S.charAt(0) != 'w') {
            System.out.println(0);
        }
        map.put('w', 1);
        map.put('o', 0);
        map.put('l', 0);
        map.put('f', 0);

        chars = new char[S.length()];

        for (int i = 1; i < S.length(); i++) {
            chars[i] = S.charAt(i);
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            // w 다음에 w 와 o 만 가능
            // o 다음에 o 와 l 만 가능
            // o 가 오면 w 보다 적게 왔는지 확인
            // l가 오면 o 보다 적게 왔는지 확인

            if (chars[i] == 'w') {
                if (i - 1 != 0 || chars[i - 1] != 'w') {
                    break;
                }
            }
        }

        boolean flag = true;
        int cnt = map.get('w');
        for (Integer x : map.values()) {
            if (cnt != x) {
                System.out.println(0);
                flag = false;
                break;
            }

        }

        if (flag) {
            System.out.println(1);
        }
    }

}
