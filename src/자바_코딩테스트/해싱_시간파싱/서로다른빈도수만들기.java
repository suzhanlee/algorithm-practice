package 자바_코딩테스트.해싱_시간파싱;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class 서로다른빈도수만들기 {

    public int solution(String s) {
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }

        Set<Integer> set = new HashSet<>();

        for (Map.Entry<Character, Integer> keySet : map.entrySet()) {

            if (set.contains(keySet.getValue())) {

                Integer value = keySet.getValue();

                while (true) {

                    value -= 1;
                    answer++;

                    if (value == 0) {
                        break;
                    } else if (!set.contains(value)) {
                        set.add(value);
                        break;
                    }
                }

            } else {
                set.add(keySet.getValue());
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        서로다른빈도수만들기 T = new 서로다른빈도수만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
