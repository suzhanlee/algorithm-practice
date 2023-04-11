package 자바_코딩테스트.sorting_thinking;

import java.util.Arrays;

class 이진수정렬 {

    public int[] solution(int[] nums) {

        int[] answer = new int[nums.length];
        int[][] res = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {

            int cnt = 0;
            int tmp = nums[i];

            while (tmp > 0) {
                cnt += (tmp % 2);
                tmp = tmp / 2;
            }

            res[i][0] = nums[i];
            res[i][1] = cnt;

        }

        Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < res.length; i++) {
            answer[i] = res[i][0];
        }

        return answer;
    }
}
