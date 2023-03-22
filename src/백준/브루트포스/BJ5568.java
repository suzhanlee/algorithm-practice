package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ5568 {

    static int N, K;
    static int[] arr;
    static int answer;
    static int[] visited;
    static ArrayList<String> answers = new ArrayList<>();

    public static void dfs(int L, String sum) {

        if (L == K) {
            if (check(sum)) {
                answers.add(sum);
                answer++;
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(L + 1, sum + arr[i]);
                    visited[i] = 0;
                }

            }
        }

    }

    public static boolean check(String sum) {

        for (String x : answers) {
            if (x.equals(sum)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, "");

        System.out.println(answer);


    }

}
