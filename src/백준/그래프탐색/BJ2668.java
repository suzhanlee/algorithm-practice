package 백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ2668 {

    static int N;
    static int answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> answerList = new ArrayList<>();
    static int[] visited;
    static int[] arr;

    public static void solution() {

        for (int i = 1; i <= N; i++) {
            visited[i] = 1;
            dfs(i, i);
            visited[i] = 0;
        }
    }

    public static void dfs(int start, int target) {

        if (visited[arr[start]] == 0) {
            visited[arr[start]] = 1;
            dfs(arr[start], target);
            visited[arr[start]] = 0;
        }

        if (arr[start] == target) {
            answerList.add(target);
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new int[N + 1];
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();

        Collections.sort(answerList);

        answer = answerList.size();

        sb.append(answer).append('\n');

        for (int i = 0; i < answerList.size(); i++) {
            sb.append(answerList.get(i)).append('\n');
        }

        System.out.println(sb);

    }

}
