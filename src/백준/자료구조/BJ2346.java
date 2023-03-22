package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ2346 {

    static int N;
    static Deque<Balloon> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    static class Balloon {

        int number;
        int move;

        public Balloon(int number, int move) {
            this.number = number;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            queue.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        Balloon poll = queue.poll();
        sb.append(poll.number).append(" ");
        int move = poll.move;

        while (!queue.isEmpty()) {
            if (move >= 0) {
                while (move != 1) {
                    Balloon balloon = queue.poll();
                    queue.addLast(balloon);
                    move--;
                }
                Balloon balloon = queue.poll();
                int number = balloon.number;
                sb.append(number).append(" ");
                move = balloon.move;
            } else {
                while (move != -1) {
                    Balloon balloon = queue.removeLast();
                    queue.addFirst(balloon);
                    move++;
                }
                Balloon balloon = queue.removeLast();
                int number = balloon.number;
                sb.append(number).append(" ");
                move = balloon.move;
            }

        }
        System.out.println(sb);
    }
}
