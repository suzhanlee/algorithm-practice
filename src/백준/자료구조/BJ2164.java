package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ2164 {

    static int N;

    public static int solution() {

        Deque<Integer> deque = new ArrayDeque();

        for (int i = N; i >= 1; i--) {
            deque.add(i);
        }

        int idx = 0;

        while (!(deque.size() == 1)) {
            if (idx % 2 == 0) {
                deque.removeLast();

            } else {
                Integer removeLast = deque.removeLast();
                deque.addFirst(removeLast);
            }
            idx++;
        }

        return deque.peekLast();

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(solution());

    }

}
