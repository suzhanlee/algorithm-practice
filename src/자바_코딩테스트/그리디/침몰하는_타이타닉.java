package 자바_코딩테스트.그리디;

import java.util.Arrays;

class 침몰하는_타이타닉 {

    public int solution(int[] nums, int m) {
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= m) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        침몰하는_타이타닉 T = new 침몰하는_타이타닉();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(
            new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83,
                21, 81}, 120));
    }
}