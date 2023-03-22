package 프로그래머스.프로그래머스_구현;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {

    static int answer = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static Queue<Integer> queue;

    public static int solution(int n, int[][] wires) {

        for (int i = 0; i < wires.length; i++) {
            int sum = 0;

            graph = new ArrayList<ArrayList<Integer>>();

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < wires.length; j++) {
                if (j == i) {
                    continue;
                }
                int x = wires[j][0];
                int y = wires[j][1];
                graph.get(x).add(y);
                graph.get(y).add(x);

            }

            queue = new LinkedList<>();
            visited = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (visited[j] == 0) {
                    visited[j] = 1;
                    queue.offer(j);
                    bfs();
                    for (int k = 1; k <= n; k++) {
                        if (visited[k] == 1) {
                            sum++;
                        }

                    }
                    break;
                }
            }
            sum = Math.abs(sum - (n - sum));
            answer = Math.min(sum, answer);
        }

        return answer;

    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            for (int x : graph.get(poll)) {

                if (visited[x] == 0) {
                    visited[x] = 1;
                    queue.offer(x);
                }
            }


        }

    }

    public static void main(String[] args) {

        int n = 7;
        int[][] wires = new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};

        int answer = solution(n, wires);
        System.out.println(answer);

    }

}
