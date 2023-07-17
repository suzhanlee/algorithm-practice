package sw역량테스트문제집.여러유형연습.해시;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {

    public int solution(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int cnt = nums.length / 2;

        for (int i = 0; i < map.size(); i++) {
            if (cnt >= 1) {
                cnt--;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        폰켓몬 main = new 폰켓몬();
        int solution = main.solution(new int[]{3, 1, 2, 3});
        System.out.println(solution);


    }

}
