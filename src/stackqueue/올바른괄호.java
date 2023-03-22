package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 올바른괄호 {

    public static String solution(String str) {
        String answer = "YES";

        Stack stack = new Stack();

        for (char x : str.toCharArray()) {
            stack.push(x);
        }

        int idx = 0;

        for (int i = 0; i < str.toCharArray().length; i++) {

            Character pop = (Character) stack.pop();
            if (idx < 0) {
                answer = "NO";
                break;
            } else if (pop == ')') {
                idx++;
            } else if (pop == '(') {
                idx--;
            }
        }

        if (idx != 0) {
            answer = "NO";
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(올바른괄호.solution(str));
    }
}
