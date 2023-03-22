package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2504 {

    static String str;
    static Stack<Character> stack = new Stack<>();
    static int answer = 0;

    public static void solution() {

        int value = 1;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                stack.push('(');
                value *= 2;
            } else if (str.charAt(i) == '[') {
                stack.push('[');
                value *= 3;
            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') {
                    answer += value;
                }
                stack.pop();
                value /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') {
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        solution();

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }

}
