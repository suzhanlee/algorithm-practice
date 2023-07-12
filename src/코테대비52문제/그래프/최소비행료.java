package 코테대비52문제.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 최소비행료 {

    static Queue<int[]> queue;
    static ArrayList<ArrayList<int[]>> graph;

    public int solution(int n, int[][] flights, int s, int e, int k) {
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<int[]>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});

        return bfs(e, 0, k, 0, Integer.MAX_VALUE);
    }

    public int bfs(int e, int L, int k, int ncost, int answer) {

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] q = queue.poll();
                int now = q[0];
                int nowCost = q[1];

                for (int[] ints : graph.get(now)) {

                    int next = ints[0];
                    int nextCost = ints[1];

                    int totalCost = nowCost + nextCost;

                    if (next == e) {

                        answer = Math.min(answer, totalCost);
                    }

                    queue.offer(new int[]{next, totalCost});

                }
            }
            L++;
            if (L > k) {
                break;
            }
        }
        if (answer == Integer.MAX_VALUE) {
            return -1;
        } else {
            return answer;
        }
    }

    public static void main(String[] args) {

        최소비행료 T = new 최소비행료();

        System.out.println(T.solution(5,
            new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10},
                {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(
            T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8,
            new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30},
                {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10,
            new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10},
                {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}},
            1, 8, 2));
    }
}