package 프로그래머스.프로그래머스_해시;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    static String answer;
    static HashMap<String, Integer> map = new HashMap<>();

    public static String solution(String[] participant, String[] completion) {

        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            Integer integer = map.get(completion[i]);
            if(integer >= 1) {
                map.put(completion[i], map.get(completion[i]) - 1);
                if(map.get(completion[i]) <= 0) {
                    map.remove(completion[i]);

                }
            }
        }

        for(Map.Entry<String,Integer> map : map.entrySet()) {
            answer = map.getKey();
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};

        String answer = solution(participant, completion);

        System.out.println(answer);

    }

}
