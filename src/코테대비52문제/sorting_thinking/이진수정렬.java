package 코테대비52문제.sorting_thinking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 이진수정렬 {

    public int[] solution(int[] nums) {

        int[] answer = new int[nums.length];

        ArrayList<Binary> arrayList = new ArrayList<>();
        for (int i : nums) {
            String s = Integer.toBinaryString(i);
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if(c == '1') {
                    cnt++;
                }
            }
            System.out.print(cnt + " ");
            arrayList.add(new Binary(i, cnt));

        }

        Collections.sort(arrayList);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i).num;

        }

        return answer;
    }

    static class Binary implements Comparable<Binary> {

        int num;
        int binary;

        public Binary(int num, int binary) {
            this.num = num;
            this.binary = binary;
        }

        @Override
        public int compareTo(Binary o) {
            if (binary == o.binary) {
                return num - o.num;
            } else {
                return binary - o.binary;
            }
        }
    }


    public static void main(String[] args) {

        이진수정렬 T = new 이진수정렬();

        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}