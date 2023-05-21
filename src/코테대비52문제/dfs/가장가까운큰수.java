package 코테대비52문제.dfs;

import java.util.Arrays;

public class 가장가까운큰수 {

    static int answer = -1;
    static boolean flag = false;
    static int[] visited;

    public int solution(int n) {

        char[] chars = String.valueOf(n).toCharArray();
        int length = chars.length;

        int[] ints = new int[length];

        for (int i = 0; i < length; i++) {

            int x = chars[i] - '0';
            ints[i] = x;

        }

        Arrays.sort(ints);


        visited = new int[length];

        dfs(length, 0, 0, n, ints);

        return answer;
    }

    public static void dfs(int N, int L, Integer value, int n, int[] ints) {

        if (L == N) {
            if (flag) {
                return;
            }

            if (value > n) {
                answer = value;
                flag = true;
            }

        } else {

            for (int i = 0; i < N; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(N, L + 1, value * 10 + ints[i], n, ints);
                    visited[i] = 0;
                }
            }

        }


    }

    public static void main(String[] args) {

        가장가까운큰수 T = new 가장가까운큰수();

        System.out.println(T.solution(123));
        answer = -1;
        flag = false;
        System.out.println(T.solution(321));
        answer = -1;
        flag = false;
        System.out.println(T.solution(20573));
        answer = -1;
        flag = false;
        System.out.println(T.solution(27711));
        answer = -1;
        flag = false;
        System.out.println(T.solution(54312));
    }
}
