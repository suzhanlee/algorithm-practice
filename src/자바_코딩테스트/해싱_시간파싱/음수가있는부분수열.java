package 자바_코딩테스트.해싱_시간파싱;


import java.util.HashMap;

public class 음수가있는부분수열 {

    public int solution(int[] nums, int m) {

        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        map.put(0, 1);

        for (int x : nums) {

            sum += x;

            if (map.containsKey(sum - m)) {
                answer += map.get(sum - m);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return answer;
    }

    public static void main(String[] args) {
        음수가있는부분수열 T = new 음수가있는부분수열();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}