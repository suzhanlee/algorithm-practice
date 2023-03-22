package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정설계 {

    public static String solution(String str1, String str2) {

        String answer = "YES";

        Queue<Character> queue = new LinkedList<>();

        char[] chars1 = str1.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            queue.offer(chars1[i]);
        }

        char[] chars2 = str2.toCharArray();

        for (int i = 0; i < chars2.length; i++) {
            if (queue.contains(chars2[i])) {
                if (queue.peek() != chars2[i]) {
                    answer = "NO";
                    break;
                }
                queue.poll();
            }
        }

        if (!queue.isEmpty()) {
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(교육과정설계.solution(str1, str2));
    }
}
