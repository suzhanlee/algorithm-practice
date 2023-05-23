package 코테대비52문제.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 타일점프 {

    static Queue<Integer> queue;
    static int[] visited;
    static int L;

    public int solution(int[] nums) {

        visited = new int[nums.length];

        L = 0;

        queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = 1;

        return bfs(nums);
    }

    public int bfs(int[] nums) {

        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {

                Integer poll = queue.poll();

                for (int j = 1; j <= nums[poll]; j++) {

                    int nx = poll + j;

                    if (nx == nums.length - 1) {
                        return L + 1;
                    }

                    if (nx < nums.length && visited[nx] == 0) {
                        visited[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;

        }
        return -1;
    }

    public static void main(String[] args) {

        타일점프 T = new 타일점프();

        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(
            T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}