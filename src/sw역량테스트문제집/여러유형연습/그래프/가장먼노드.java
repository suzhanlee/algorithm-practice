package sw역량테스트문제집.여러유형연습.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] ints : edge) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }

        int[] answerNode = new int[n + 1];

        bfs(n, answerNode, graph);
        int max = 0;
        int answer = 0;

        for (int i = 1; i < answerNode.length; i++) {
            max = Math.max(max, answerNode[i]);
        }

        for (int i = 1; i < answerNode.length; i++) {
            if(max == answerNode[i]) {
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int n, int[] answerNode, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int[] visited = new int[n + 1];
        visited[1] = 1;
        visited[0] = 1;

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

           for(int x : graph.get(poll)) {
               if(visited[x] == 0) {
                   visited[x] = 1;
                   queue.offer(x);
                   answerNode[x] = answerNode[poll] + 1;
               }

           }
        }


    }


    public static void main(String[] args) {

        가장먼노드 main = new 가장먼노드();
//        int solution = main.solution(6,
//            new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        int solution = main.solution(4,
            new int[][]{{4, 3}, {1, 3}, {2, 3}});


        System.out.println(solution);

    }
}