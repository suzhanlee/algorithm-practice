package 코테대비52문제.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 팰린드롬의수 {

    static String s;
    static int[] visited;
    static Set<String> arrayList;

    public String[] solution(String s) {

        팰린드롬의수.s = s;
        arrayList = new HashSet<>();
        visited = new int[s.length()];

        String[] answer = {};

        dfs(0, "");

        for (String s1 : arrayList) {
            System.out.print(s1 + " ");
        }
        System.out.println();

        return answer;
    }

    public void dfs(int L, String str) {

        if (L == s.length()) {
            if (isPlendrom(str)) {
                arrayList.add(str);
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    dfs(L+1, str + s.charAt(i));
                    visited[i] = 0;
                }
            }
        }
    }

    public boolean isPlendrom(String str) {

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        팰린드롬의수 T = new 팰린드롬의수();

        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}