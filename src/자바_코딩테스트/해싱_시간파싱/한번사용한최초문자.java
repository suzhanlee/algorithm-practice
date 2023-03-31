package 자바_코딩테스트.해싱_시간파싱;

import java.util.HashMap;
import java.util.Map;

class 한번사용한최초문자 {

    public int solution(String s) {
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }

        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == 1) {
                answer = i + 1;
                break;
            }
        }

        if(answer == 0) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        한번사용한최초문자 T = new 한번사용한최초문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}