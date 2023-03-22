package 프로그래머스.프로그래머스_깊이_너비_우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타겟_넘버 {

    static int[] numbers;
    static int target;
    static int answer;
    static int[] visited;

    public static void dfs(int[] numbers, int L, int target, int sum) {
        if (L == numbers.length) {
            if (target == sum) {
                answer++;
            }
        } else {
            dfs(numbers, L + 1, target, sum + numbers[L]);
            dfs(numbers, L + 1, target, sum - numbers[L]);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        numbers = new int[]{4, 1, 2, 1};
        visited = new int[numbers.length];

        dfs(numbers, 0, target, 0);
        System.out.println(answer);


    }

}
