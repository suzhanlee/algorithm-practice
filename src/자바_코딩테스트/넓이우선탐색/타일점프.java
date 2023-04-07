package 자바_코딩테스트.넓이우선탐색;

import java.util.LinkedList;
import java.util.Queue;

class 타일점프 {

    public int solution(int[] nums) {

        int n = nums.length;
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = 1;
        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int x = queue.poll();

                for (int j = 1; j <= nums[x]; j++) {
                    int nx = x + j;
                    if (nx == n - 1) {
                        return L + 1;
                    }

                    if (nx < n && visited[nx] == 0) {
                        visited[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return -1;
    }
}
