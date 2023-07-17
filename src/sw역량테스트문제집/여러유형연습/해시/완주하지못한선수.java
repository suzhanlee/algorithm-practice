package sw역량테스트문제집.여러유형연습.해시;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }

        for (int i = 0; i < participant.length; i++) {
            if (!map.containsKey(participant[i])) {
                return participant[i];
            }

            map.replace(participant[i], map.get(participant[i]) - 1);

            if(map.get(participant[i]) == 0) {
                map.remove(participant[i]);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        완주하지못한선수 main = new 완주하지못한선수();
        String solution = main.solution(new String[]{"leo", "kiki", "eden"},
            new String[]{"eden", "kiki"});

        System.out.println(solution);
    }
}
