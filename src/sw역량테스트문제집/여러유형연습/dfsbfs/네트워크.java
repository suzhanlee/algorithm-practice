package sw역량테스트문제집.여러유형연습.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public int solution(int N, int[][] computers) {
        int answer = 0;
        visited = new int[N];

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
                BFS(computers, N);
                answer++;
            }
        }
        return answer;
    }

    static void BFS(int computers[][], int n) {

        while (!queue.isEmpty()) {
            int value = queue.poll();

            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && computers[value][i] == 1) {
                    visited[i] = 1;
                    queue.offer(i);
                }
            }

        }

    }
}