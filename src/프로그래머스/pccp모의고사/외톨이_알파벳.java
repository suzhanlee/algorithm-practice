package 프로그래머스.pccp모의고사;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 외톨이_알파벳 {

    static String input_string;
    static Map<Character, Integer> map = new HashMap<>();
    static Set<Character> answerSet = new HashSet<>();
    static List<Character> answerList = new ArrayList<>();

    public static String solution(String input_string) {
        String answer = "";
        외톨이_알파벳.input_string = input_string;

        map.put(input_string.charAt(0),1);

        for (int i = 1; i < input_string.length(); i++) {

            if (input_string.charAt(i) != input_string.charAt(i - 1) && map.containsKey(input_string.charAt(i))) {
                answerSet.add(input_string.charAt(i));
            }

            map.put(input_string.charAt(i), map.getOrDefault(input_string.charAt(i), 1) + 1);

        }

        answerList.addAll(answerSet);

        Collections.sort(answerList);

        for (Character character : answerList) {
            answer += character;
        }

        if(answer.equals("")) {
            answer = "N";
        }

        return answer;
    }

    public static void main(String[] args) {

        String answer = solution("zbzbz");
        System.out.println(answer);

    }

}
