package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ9012 {

    static int N;

    public static String solution(Stack<Character> stack) {
        String answer = "NO";
        int cnt = 0;

        while (!stack.isEmpty()) {
            if (cnt > 0) {
                break;
            }
            Character pop = stack.pop();
            if (pop == '(') {
                cnt++;
            } else {
                cnt--;
            }
        }

        if (cnt == 0) {
            return "YES";
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Character> stack = new Stack<>();
            String str = st.nextToken();
            for (int j = 0; j < str.length(); j++) {
                stack.push(str.charAt(j));
            }
            System.out.println(solution(stack));
        }
    }
}
