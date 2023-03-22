package 백준.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ11279 {

    static int N;
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

    public static void solution(int num) {

        if (num == 0) {
            Integer poll = pQ.poll();
            if (poll == null) {
                System.out.println(0);
            } else {
                System.out.println(poll);
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


    }

}
