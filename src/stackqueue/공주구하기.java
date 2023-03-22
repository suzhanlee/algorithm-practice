package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주구하기 {


    public static int solution(int N, int K) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);

        }

        int idx = 1;
        while (queue.size() != 1) {

            Integer poll = queue.poll();
            if (idx == K) {
                idx = 1;
                continue;
            }
            queue.offer(poll);
            idx++;

        }
        return queue.peek();

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(공주구하기.solution(N, K));

    }
}
