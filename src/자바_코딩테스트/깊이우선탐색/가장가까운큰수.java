package 자바_코딩테스트.깊이우선탐색;

import java.util.Arrays;

class 가장가까운큰수 {

    static int length;
    static int[] nums;
    static int n;
    static boolean flag = false;
    static int answer;
    static int[] visited;

    public int solution(int n) {
        this.n = n;
        answer = 0;

        length = String.valueOf(n).length();
        nums = new int[length];

        int value = n;
        visited = new int[length];

        for (int i = nums.length - 1; i >= 0; i--) {

            int x = (int) (value / (Math.pow(10, i)));
            nums[nums.length - 1 - i] = x;

            value -= (x * Math.pow(10, i));
        }

        Arrays.sort(nums);

        dfs(0, 0);

        if (answer == 0) {
            return -1;
        }

        return answer;
    }

    public static void dfs(int N, int value) {

        if (N == length) {

            if (flag == true && value > n) {
                answer = value;
                flag = false;
                return;
            }

            if (value == n) {
                flag = true;
            }

        } else {
            for (int i = 0; i < length; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(N + 1, value * 10 + nums[i]);
                    visited[i] = 0;
                }
            }
        }


    }

    public static void main(String[] args) {
        가장가까운큰수 T = new 가장가까운큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
