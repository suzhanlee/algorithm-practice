package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 괄호문자제거 {

    public static String solution(String str) {

        char[] chars = str.toCharArray();
        Queue queue = new LinkedList();

        for (int i = 0; i < chars.length; i++) {
            queue.add(chars[i]);
        }

        String answer = "";

        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            Character poll = (Character) queue.poll();
            if (poll == '(') {
                idx++;
            } else if (poll == ')') {
                idx--;
            }

            if (Character.isAlphabetic(poll) && idx <= 0) {
                answer += poll;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(괄호문자제거.solution(str));
    }
}
