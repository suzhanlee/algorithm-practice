package 프로그래머스.프로그래머스_해시;

import java.util.Collection;
import java.util.HashMap;

public class 위장 {

    static int answer = 1;
    static HashMap<String, Integer> map = new HashMap<>();

    public static int solution(String[][] clothes) {

        for (int i = 0; i < clothes.length; i++) {

            String[] clothe = clothes[i];
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);

        }

        Collection<Integer> values = map.values();

        for(Integer value : values) {
            answer *= (value + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {

        String[][] clothes = new String[][]{{"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int answer = solution(clothes);

        System.out.println(answer);

    }

}
