package 자바_코딩테스트.깊이우선탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Ip주소 {

    static LinkedList<String> tmp;
    static ArrayList<String> res;

    public void DFS(int start, String s) {

        if (tmp.size() == 4 && start == s.length()) {
            String newStr = "";
            for (String x : tmp) {
                newStr += x + ".";
            }
            res.add(newStr.substring(0, newStr.length() - 1));

        } else {
            for (int i = start; i < s.length(); i++) {

                if (s.charAt(start) == '0' && i > start) {
                    return;
                }

                String num = s.substring(start, i + 1);

                if (Integer.parseInt(num) > 255) {
                    return;
                }

                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, s);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Ip주소 T = new Ip주소();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}