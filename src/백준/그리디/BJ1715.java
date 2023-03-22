package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1715 {

    static int N;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static int answer;

    public static void solution() {

        int tmp = 0;

        if (N == 1) {
            answer = 0;

        } else if (N == 2) {
            answer = queue.poll() + queue.poll();

        } else {

            while (queue.size() != 1) {

                Integer poll = queue.poll();
                Integer poll1 = queue.poll();

                tmp += (poll1 + poll);
                queue.offer(tmp);
                answer += tmp;
                tmp = 0;
            }

        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            queue.offer(x);
        }

        solution();
        System.out.println(answer);

    }
}
