package 자바_코딩테스트.그리디;

import java.util.Arrays;

class 꽃이피는최단시간 {

    public int solution(int[] plantTime, int[] growTime) {

        int answer = 0;

        int[][] period = new int[plantTime.length][2];

        for (int i = 0; i < period.length; i++) {

            period[i][0] = plantTime[i];
            period[i][1] = growTime[i];

        }

        Arrays.sort(period, (a, b) -> -(a[1] - b[1]));

        int start = 0;
        int end = 0;

        int idx = 0;

        while (idx <= period.length - 1) {

            end = Math.max(end, start + period[idx][0] + period[idx][1]);

            start += period[idx][0];
            idx++;
        }

        return end;
    }

    public static void main(String[] args) {
        꽃이피는최단시간 T = new 꽃이피는최단시간();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(
            T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(
            T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}