package 프로그래머스.프로그래머스_해시;

import java.util.HashSet;

public class 폰켓몬 {

    static int answer;
    static HashSet<Integer> set = new HashSet<>();

    public static int solution(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            set.add(nums[i]);

        }

        int want = nums.length / 2;

        if (set.size() > want) {
            answer = want;
        } else {
            answer = set.size();
        }

        return answer;

    }


    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 2, 3,};
        int answer = solution(nums);
        System.out.println(answer);


    }

}
