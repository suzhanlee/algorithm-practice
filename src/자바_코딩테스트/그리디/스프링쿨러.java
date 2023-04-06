package 자바_코딩테스트.그리디;

import java.util.Arrays;

class 스프링쿨러 {

    public int solution(int n, int[] nums) {

        int answer = 0;

        int[][] cooler = new int[nums.length + 1][2];

        for (int i = 0; i <= n; i++) {
            cooler[i][0] = Math.max(0, i - nums[i]);
            cooler[i][1] = Math.min(n, i + nums[i]);
        }

        Arrays.sort(cooler, (a, b) -> a[0] - b[0]); // start 기준 정렬

        int start = 0;
        int end = 0;
        int idx = 0;

        while (idx < cooler.length) {

            while (idx < cooler.length && cooler[idx][0] <= start) {
                end = Math.max(end, cooler[idx][1]);
                idx++;
            }

            answer++;

            if (end == n) {
                return answer;
            }

            if (start == end) {
                return -1;
            }

            start = end;
        }

        return answer;
    }

    public static void main(String[] args) {
        스프링쿨러 T = new 스프링쿨러();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}