package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ4949 {

    static String str;
    static Stack<String> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!(str = br.readLine()).equals(".")) {

            stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < str.length(); i++) {
                if (String.valueOf(str.charAt(i)).equals("(")) {
                    stack.push("(");
                } else if (String.valueOf(str.charAt(i)).equals("[")) {
                    stack.push("[");
                } else if (String.valueOf(str.charAt(i)).equals(")")) {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    String pop = stack.pop();
                    if (!pop.equals("(")) {
                        flag = false;
                        break;
                    }
                } else if (String.valueOf(str.charAt(i)).equals("]")) {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    String pop = stack.pop();
                    if (!pop.equals("[")) {
                        flag = false;
                        break;
                    }
                }
            }

            if (!flag) {
                System.out.println("no");
            } else if (stack.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }


        }
    }

}
