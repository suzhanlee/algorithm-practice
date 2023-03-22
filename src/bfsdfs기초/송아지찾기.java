package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지찾기 {

    static int[] arr = {1, -1, 5};
    static Queue<Integer> queue = new LinkedList<>();

    public static int bfs(int S, int E) {

        int[] visited = new int[10001];
        visited[S] = 1;
        queue.offer(S);
        int L = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                for (int j = 0; j < 3; j++) {
                    int num = poll + arr[j];
                    if (num >= 1 && num <= 10000 && visited[num] == 0) {
                        if (num == E) {
                            return L + 1;
                        }
                        visited[num] = 1;
                        queue.offer(num);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(송아지찾기.bfs(S, E));
    }
}
