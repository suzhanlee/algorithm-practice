package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ1972 {

    static StringBuilder sb = new StringBuilder();

    public static boolean solution(String[] arr) {

        int idx = 1;

        while (idx != arr.length) {

            HashSet<String> hashSet = new HashSet<>();

            for (int i = 0; i < arr.length; i++) {
                if (i + idx <= arr.length - 1) {
                    hashSet.add(arr[i] + arr[i + idx]); // boolean 을 return 받을 수 있다.
                }
            }

            if (hashSet.size() != arr.length - idx) {
                return false;

            }
            idx++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("*")) {
                break;
            }

            String[] arr = new String[s.length()];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = String.valueOf(s.charAt(i));
            }

            boolean flag = solution(arr);
            if (flag) {
                sb.append(s).append(" ").append("is surprising").append('\n');
            } else {
                sb.append(s).append(" ").append("is NOT surprising").append('\n');
            }

        }

        System.out.println(sb.toString());
    }

}
