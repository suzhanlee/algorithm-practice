package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17298 {

    static int N;
    static int[] arr;
    static int[] answers;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void solution() {

        stack.push(0);

        for (int i = 1; i < N; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answers[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answers[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(answers[i]).append(" ");

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        answers = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(sb);

    }

}
