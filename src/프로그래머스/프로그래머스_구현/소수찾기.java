package 프로그래머스.프로그래머스_구현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 소수찾기 {

    static int answer;
    static String number;
    static HashSet<Integer> set = new HashSet<>();
    static List<Character> characters = new ArrayList<>();
    static ArrayList<Integer> pms = new ArrayList<>();
    static HashSet<Integer> pmSet = new HashSet<>();
    static int[] pm;
    static int[] visited;

    public static int solution(String numbers) {

        number = numbers;
        for (int i = 0; i < numbers.length(); i++) {
            characters.add(numbers.charAt(i));
        }

        visited = new int[numbers.length()];
        pm = new int[numbers.length()];

        permutation(0);

        pms.addAll(pmSet);

        for (int i = 0; i < pms.size(); i++) {
            number = String.valueOf(pms.get(i));
//            visited = new int[number.length()];
            dfs(0, "");

        }

        answer = set.size();
        return answer;
    }

    private static void dfs(int L, String str) {

        if (L == number.length()) {

            if (str.equals("")) {
                return;
            }

            int x = Integer.parseInt(str);

            int cnt = 0;

            for (int i = 2; i <= x; i++) {

                if (x % i == 0) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                set.add(x);
//                System.out.println("x = " + x);
            }


        } else {

//            if(visited[L] == 0) {
//                visited[L] = 1;
            dfs(L + 1, str + number.charAt(L));
//                visited[L = 0;]
//            }
//            if(visited[L] == 0) {
            dfs(L + 1, str);
//            }
        }


    }

    public static void permutation(int L) {

        if (L == pm.length) {
            String str = "";
            for (int i = 0; i < pm.length; i++) {
                str += pm[i];
            }
            pmSet.add(Integer.parseInt(str));
        } else {

            for (int i = 0; i < number.length(); i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    pm[L] = number.charAt(i) - '0';
                    permutation(L + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int answer = solution("011");
        System.out.println(answer);

    }


}
