package 자바_코딩테스트.그래프최단거리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class 최소비행료 {

    public int solution(int n, int[][] flights, int s, int e, int k) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<int[]>());
        }

        int[] costs = new int[n];
        Arrays.fill(costs, 1000000000);

        for (int[] x : flights) {
            graph.get(x[0]).add(new int[]{x[1], x[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});
        costs[s] = 0;

        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int[] p = queue.poll();
                int now = p[0];
                int nowcost = p[1];

                for (int[] x : graph.get(now)) {
                    int next = x[0];
                    int cost = x[1];
                    if (nowcost + cost < costs[next]) {
                        costs[next] = nowcost + cost;
                        queue.offer(new int[]{next, costs[next]});
                    }
                }
            }

            L++;

            if (L > k) {
                break;
            }
        }

        if (costs[e] == 1000000000) {
            return -1;
        } else {
            return costs[e];
        }
    }
}
