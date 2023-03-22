package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {

    public static int solution(char[] chars) {

        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                stack.push(chars[i]);

            } else {
                stack.pop();
                if (chars[i - 1] == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] chars = str.toCharArray();
        System.out.println(쇠막대기.solution(chars));

    }
}
