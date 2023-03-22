package 백준.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ11286 {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        }
    });

    public static void solution(int num) {

        if (num == 0) {
            Integer poll = pQ.poll();
            if (poll == null) {
                sb.append(0).append('\n');
            } else {
                sb.append(poll).append('\n');
            }
        } else {
            pQ.offer(num);
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            solution(num);
        }

        System.out.println(sb);

    }
}
