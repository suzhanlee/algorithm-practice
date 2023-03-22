package 백준.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11728 {

    //    static int N, M;
    static int[] arr1, arr2;
    static ArrayList<Integer> answer;

    public static void solution(int N, int M) {

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < N && idx2 < M) {
            if (arr1[idx1] < arr2[idx2]) {
                answer.add(arr1[idx1++]);
            } else {
                answer.add(arr2[idx2++]);
            }
        }

        while (idx1 < N) {
            answer.add(arr1[idx1++]);
        }
        while (idx2 < M) {
            answer.add(arr2[idx2++]);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        arr2 = new int[M];

        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        answer = new ArrayList<>();

        solution(N, M);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + " ");

        }
        System.out.println(sb);

//        Arrays.sort보다 Collections.sort가 빠르다.
//        정답을 출력 할 땐 sysout으로 찍으면 시간초과 난다.
//        StringBuilder에 넣어서 한번에 출력해줘야 한다.
    }
}
