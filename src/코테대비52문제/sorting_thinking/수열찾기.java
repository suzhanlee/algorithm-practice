package 코테대비52문제.sorting_thinking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 수열찾기 {

    public int[] solution(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] answer = new int[nums.length / 2];

        Arrays.sort(nums);

        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int idx = 0;

        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }

            map.put(num, map.get(num) - 1);
            map.put(num * 2, map.get(num * 2) - 1);
            answer[idx] = num;
            idx++;

        }

        return answer;
    }

    public static void main(String[] args) {

        수열찾기 T = new 수열찾기();

        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(
            Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}