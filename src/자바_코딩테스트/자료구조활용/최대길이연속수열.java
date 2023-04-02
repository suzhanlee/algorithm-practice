package 자바_코딩테스트.자료구조활용;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class 최대길이연속수열 {

    public int solution(int[] nums) {
        int answer = 1;
        int sum = 1;
        Set<Integer> set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        ArrayList<Integer> answerList = new ArrayList<>(set);
        Collections.sort(answerList);

        for (int i = 1; i < answerList.size(); i++) {

            if (answerList.get(i) == answerList.get(i-1) + 1) {
                sum++;
            } else {
                answer = Math.max(sum, answer);
                sum = 0;
            }

        }

        answer = Math.max(sum, answer);

        return answer;
    }

    public static void main(String[] args) {
        최대길이연속수열 T = new 최대길이연속수열();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}