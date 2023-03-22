package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ1874 {

    static int N;
    static Queue<Integer> queue = new LinkedList<>();
    static String answer = "YES";

    public static StringBuilder solution() {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.add(0);
        int start = 0;

        for (int i = 0; i < N; i++) {

            if (queue.peek() > start) {

                for (int j = start + 1; j <= queue.peek(); j++) {
                    stack.add(j);
                    sb.append("+").append('\n');
                }
                start = queue.peek();

            } else if (!(queue.peek().equals(stack.peek()))) {
                answer = "NO";
                break;
            }

            stack.pop();
            queue.poll();
            sb.append("-").append('\n');
        }

        return sb;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int i1 = Integer.parseInt(br.readLine());
            queue.offer(i1);
        }

        StringBuilder solution = solution();

        if (answer.equals("NO")) {
            System.out.println(answer);
        } else {
            StringBuilder sb = solution.deleteCharAt(solution.length() - 1);
            System.out.println(sb);
        }
    }
}
