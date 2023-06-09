package 자바_코딩테스트.그리디;

import java.util.Arrays;

class 이동횟수 {

    public int solution(int[] nums) {
        int answer = 0;

        Arrays.sort(nums);

        int lt = 0;
        int rt = nums.length - 1;

        while (lt <= rt) {

            if (nums[rt] + nums[lt] > 5) {
                if (nums[rt] <= 5) {
                    rt--;
                    answer++;
                }
            } else {
                lt++;
                rt--;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        이동횟수 T = new 이동횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}