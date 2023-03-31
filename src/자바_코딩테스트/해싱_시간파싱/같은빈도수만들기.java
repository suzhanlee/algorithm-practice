package 자바_코딩테스트.해싱_시간파싱;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 같은빈도수만들기 {

    public int[] solution(String s) {
        int[] answer = new int[5];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int maxCnt = -1;

        for (int i = 0; i < s.length(); i++) {
            maxCnt = Math.max(maxCnt, map.get(s.charAt(i)));
        }

        for (int i = 0; i < 5; i++) {

            char c = (char) ('a' + i);
            if(!map.containsKey(c)) {
                answer[i] = maxCnt;
            } else {
                Integer cnt = map.get(c);
                answer[i] = maxCnt - cnt;
            }


        }

        return answer;
    }

    public static void main(String[] args) {
        같은빈도수만들기 T = new 같은빈도수만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
